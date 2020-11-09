import java.util.ArrayList;

public class Node implements Cloneable {

    static enum SolveHuristic {
        MISS_PLACE, MANHATTAN_DISTANCE, MANHATTAN_PER_SEQUENCE
        , MANHATTAN_PER_SEQUENCE_POWER, MANHATTAN_LINEAR_SEQUENCE,
    }

    public double hOfn, gOfn;
    public int[][] nodeInfo = new int[3][3];
    public ArrayList<String> actionSequence;
    public CustomOrigin freeSpaceOrigin;

    public Node() {
    }

    public Node(Double hOfn, Double gOfn, int[][] nodeInfo, ArrayList<String> actionSequence,
            CustomOrigin freeSpaceOrigin) {
        this.hOfn = hOfn;
        this.gOfn = gOfn;
        this.nodeInfo = nodeInfo;
        this.actionSequence = actionSequence;
        this.freeSpaceOrigin = freeSpaceOrigin;
    }

    @Override
    public Node clone() throws CloneNotSupportedException {
        Node node = null;
        int[][] clonedMember = new int[3][3];
        try {
            node = (Node) super.clone();
        } catch (CloneNotSupportedException e) {
            node = new Node(this.hOfn, this.gOfn, this.nodeInfo, this.actionSequence, this.freeSpaceOrigin);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                clonedMember[i][j] = this.nodeInfo[i][j];
            }
        }
        node.actionSequence = (ArrayList<String>) this.actionSequence.clone();
        node.gOfn = this.gOfn;
        node.hOfn = this.hOfn;
        node.nodeInfo = clonedMember;
        node.freeSpaceOrigin = (CustomOrigin) this.freeSpaceOrigin.clone();
        return node;
    }

    @Override
    public String toString() {
        return "f(n) = " + (gOfn + hOfn);
    }

    public CustomOrigin calculateTilePosition(int tile) {
        CustomOrigin tileOrigin;
        int x = 0, y = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (nodeInfo[i][j] == tile) {
                    x = i;
                    y = j;
                }
            }
        }
        tileOrigin = new CustomOrigin(x, y);

        return tileOrigin;
    }

}