public class Node {
    private int hOfn, gOfn;
    private int[][] nodeInfo = {};
    private String[] actionSequence;
    private Origin freeSpaceOrigin;

    public Node(int hOfn, int gOfn, int[][] nodeInfo, String[] actionSequence, Origin freeSpaceOrigin) {
        this.sethOfn(hOfn);
        this.setgOfn(gOfn);
        this.setNodeInfo(nodeInfo);
        this.setActionSequence(actionSequence);
        this.setFreeSpaceOrigin(freeSpaceOrigin);
    }

    public Origin getFreeSpaceOrigin() {
        return freeSpaceOrigin;
    }

    public void setFreeSpaceOrigin(Origin freeSpaceOrigin) {
        this.freeSpaceOrigin = freeSpaceOrigin;
    }

    public String[] getActionSequence() {
        return actionSequence;
    }

    public void setActionSequence(String[] actionSequence) {
        this.actionSequence = actionSequence;
    }

    public int[][] getNodeInfo() {
        return nodeInfo;
    }

    public void setNodeInfo(int[][] nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    public int getgOfn() {
        return gOfn;
    }

    public void setgOfn(int gOfn) {
        this.gOfn = gOfn;
    }

    public int gethOfn() {
        return hOfn;
    }

    public void sethOfn(int hOfn) {
        this.hOfn = hOfn;
    }

    @Override
    public String toString() {
        return "g(n) : $gOfn , h(n) : $hOfn , nodeMembers : $nodeInfo , actionSeq : $actionSequence";
    }
        
}