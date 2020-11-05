import java.util.ArrayList;
import java.util.Arrays;

public class Node implements Cloneable {
    public int hOfn, gOfn;
    public int[][] nodeInfo = new int[3][3];
    public ArrayList<String> actionSequence;
    public CustomOrigin freeSpaceOrigin;

    public Node(int hOfn, int gOfn, int[][] nodeInfo, ArrayList<String> actionSequence, CustomOrigin freeSpaceOrigin) {
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
        return "g(n) = " + gOfn + "| h(n) = " + hOfn + "| nodeMembers = " + nodeInfo + "| actionSeq = "
                + actionSequence;
    }

}