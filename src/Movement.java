public class Movement {

    enum MovementType {
        UP, DOWN, LEFT, RIGHT
    }

    public static Node move(Node initialNode, Node goalNode, MovementType movementType) {
        Node tempNode = initialNode;

        if (movementType == MovementType.UP) {

            int freeSpaceMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j];
            int targetMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i - 1][tempNode.freeSpaceOrigin.j];

            tempNode.nodeInfo[tempNode.freeSpaceOrigin.i - 1][tempNode.freeSpaceOrigin.j] = freeSpaceMember;
            tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j] = targetMember;

            tempNode.actionSequence.add("U");
            tempNode.hOfn = PuzzleBoard.calculateMissPlace(initialNode, goalNode);
            tempNode.gOfn += 1;
            tempNode.freeSpaceOrigin = PuzzleBoard.findFreeSpaceOrigin(tempNode.nodeInfo);

        } else if (movementType == MovementType.DOWN) {

            int freeSpaceMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j];
            int targetMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i + 1][tempNode.freeSpaceOrigin.j];

            tempNode.nodeInfo[tempNode.freeSpaceOrigin.i + 1][tempNode.freeSpaceOrigin.j] = freeSpaceMember;
            tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j] = targetMember;

            tempNode.actionSequence.add("D");
            tempNode.hOfn = PuzzleBoard.calculateMissPlace(initialNode, goalNode);
            tempNode.gOfn += 1;
            tempNode.freeSpaceOrigin = PuzzleBoard.findFreeSpaceOrigin(tempNode.nodeInfo);

        } else if (movementType == MovementType.LEFT) {

            int freeSpaceMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j];
            int targetMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j - 1];

            tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j - 1] = freeSpaceMember;
            tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j] = targetMember;

            tempNode.actionSequence.add("L");
            tempNode.hOfn = PuzzleBoard.calculateMissPlace(initialNode, goalNode);
            tempNode.gOfn += 1;
            tempNode.freeSpaceOrigin = PuzzleBoard.findFreeSpaceOrigin(tempNode.nodeInfo);

        } else if (movementType == MovementType.RIGHT) {

            int freeSpaceMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j];
            int targetMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j + 1];

            tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j + 1] = freeSpaceMember;
            tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j] = targetMember;

            tempNode.actionSequence.add("R");
            tempNode.hOfn = PuzzleBoard.calculateMissPlace(initialNode, goalNode);
            tempNode.gOfn += 1;
            tempNode.freeSpaceOrigin = PuzzleBoard.findFreeSpaceOrigin(tempNode.nodeInfo);

        }
        return tempNode;
    }
}
