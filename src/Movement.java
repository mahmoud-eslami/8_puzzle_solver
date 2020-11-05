public class Movement {

    public static Node up(Node initialNode, Node goalNode) {
        Node tempNode = initialNode;
        int freeSpaceMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j];
        int targetMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i - 1][tempNode.freeSpaceOrigin.j];

        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i - 1][tempNode.freeSpaceOrigin.j] = freeSpaceMember;
        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j] = targetMember;

        tempNode.actionSequence.add("U");
        tempNode.hOfn = PuzzleBoard.calculateMissPlace(tempNode.nodeInfo, goalNode.nodeInfo);
        tempNode.gOfn += 1;
        tempNode.freeSpaceOrigin = PuzzleBoard.findFreeSpaceOrigin(tempNode.nodeInfo);
        return tempNode;
    }

    public static Node down(Node initialNode, Node goalNode) {
        Node tempNode = initialNode;
        int freeSpaceMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j];
        int targetMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i + 1][tempNode.freeSpaceOrigin.j];

        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i + 1][tempNode.freeSpaceOrigin.j] = freeSpaceMember;
        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j] = targetMember;

        tempNode.actionSequence.add("D");
        tempNode.hOfn = PuzzleBoard.calculateMissPlace(tempNode.nodeInfo, goalNode.nodeInfo);
        tempNode.gOfn += 1;
        tempNode.freeSpaceOrigin = PuzzleBoard.findFreeSpaceOrigin(tempNode.nodeInfo);
        return tempNode;
    }

    public static Node left(Node initialNode, Node goalNode){
        Node tempNode = initialNode;
        int freeSpaceMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j];
        int targetMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j - 1];

        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j - 1] = freeSpaceMember;
        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j] = targetMember;

        tempNode.actionSequence.add("L");
        tempNode.hOfn = PuzzleBoard.calculateMissPlace(tempNode.nodeInfo, goalNode.nodeInfo);
        tempNode.gOfn += 1;
        tempNode.freeSpaceOrigin = PuzzleBoard.findFreeSpaceOrigin(tempNode.nodeInfo);
        return tempNode;
    }

    public static Node right(Node initialNode, Node goalNode){
        Node tempNode = initialNode;
        int freeSpaceMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j];
        int targetMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j + 1];

        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j + 1] = freeSpaceMember;
        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j] = targetMember;

        tempNode.actionSequence.add("R");
        tempNode.hOfn = PuzzleBoard.calculateMissPlace(tempNode.nodeInfo, goalNode.nodeInfo);
        tempNode.gOfn += 1;
        tempNode.freeSpaceOrigin = PuzzleBoard.findFreeSpaceOrigin(tempNode.nodeInfo);
        return tempNode;
    }
}
