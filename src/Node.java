import java.io.Serializable;
import java.util.ArrayList;

public class Node {
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
    public String toString() {
        return "g(n) = " + gOfn + "| h(n) = " + hOfn + "| nodeMembers = " + nodeInfo + "| actionSeq = "
                + actionSequence;
    }

}