public class Node {
    public int hOfn, gOfn;
    public int[][] nodeInfo = {};
    public String[] actionSequence;
    public CustomOrigin freeSpaceOrigin;

    public Node(int hOfn, int gOfn, int[][] nodeInfo, String[] actionSequence, CustomOrigin freeSpaceOrigin) {
        this.hOfn = hOfn;
        this.gOfn = gOfn;
        this.nodeInfo = new int[nodeInfo.length][];
        for (int i = 0; i < nodeInfo.length; i++) {
            this.nodeInfo[i] = nodeInfo[i].clone();
        }
        this.actionSequence = actionSequence;
        this.freeSpaceOrigin = freeSpaceOrigin;
    }

    @Override
    public String toString() {
        return "g(n) : $gOfn , h(n) : $hOfn , nodeMembers : $nodeInfo , actionSeq : $actionSequence";
    }

}