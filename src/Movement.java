public class Movement {

    public static Node up(Node initialNode, Node goalNode, Node.SolveHuristic huristic) {
        Node tempNode = initialNode;
        int freeSpaceMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j];
        int targetMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i - 1][tempNode.freeSpaceOrigin.j];

        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i - 1][tempNode.freeSpaceOrigin.j] = freeSpaceMember;
        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j] = targetMember;
        if (huristic == Node.SolveHuristic.MISS_PLACE) {
            tempNode.hOfn = PuzzleBoard.calculateMissPlaceHeuristic(tempNode.nodeInfo, goalNode.nodeInfo);

        } else if (huristic == Node.SolveHuristic.MANHATTAN_DISTANCE) {
            tempNode.hOfn = PuzzleBoard.calculateManhattanDistanceHeuristic(tempNode, goalNode);

        } else if (huristic == Node.SolveHuristic.MANHATTAN_PER_SEQUENCE) {
            tempNode.hOfn = PuzzleBoard.calculateManhattanPerSequencedHeuristic(
                    PuzzleBoard.calculateManhattanDistanceHeuristic(tempNode, goalNode),
                    PuzzleBoard.calculateSequencedSpace(tempNode));
        }

        tempNode.actionSequence.add("U");
        tempNode.gOfn += 1;
        tempNode.freeSpaceOrigin = PuzzleBoard.findFreeSpaceOrigin(tempNode.nodeInfo);
        return tempNode;
    }

    public static Node down(Node initialNode, Node goalNode, Node.SolveHuristic huristic) {
        Node tempNode = initialNode;
        int freeSpaceMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j];
        int targetMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i + 1][tempNode.freeSpaceOrigin.j];

        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i + 1][tempNode.freeSpaceOrigin.j] = freeSpaceMember;
        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j] = targetMember;
        if (huristic == Node.SolveHuristic.MISS_PLACE) {
            tempNode.hOfn = PuzzleBoard.calculateMissPlaceHeuristic(tempNode.nodeInfo, goalNode.nodeInfo);

        } else if (huristic == Node.SolveHuristic.MANHATTAN_DISTANCE) {
            tempNode.hOfn = PuzzleBoard.calculateManhattanDistanceHeuristic(tempNode, goalNode);

        } else if (huristic == Node.SolveHuristic.MANHATTAN_PER_SEQUENCE) {
            tempNode.hOfn = PuzzleBoard.calculateManhattanPerSequencedHeuristic(
                    PuzzleBoard.calculateManhattanDistanceHeuristic(tempNode, goalNode),
                    PuzzleBoard.calculateSequencedSpace(tempNode));
        }
        tempNode.actionSequence.add("D");
        tempNode.gOfn += 1;
        tempNode.freeSpaceOrigin = PuzzleBoard.findFreeSpaceOrigin(tempNode.nodeInfo);
        return tempNode;
    }

    public static Node left(Node initialNode, Node goalNode, Node.SolveHuristic huristic) {
        Node tempNode = initialNode;
        int freeSpaceMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j];
        int targetMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j - 1];

        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j - 1] = freeSpaceMember;
        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j] = targetMember;
        if (huristic == Node.SolveHuristic.MISS_PLACE) {
            tempNode.hOfn = PuzzleBoard.calculateMissPlaceHeuristic(tempNode.nodeInfo, goalNode.nodeInfo);

        } else if (huristic == Node.SolveHuristic.MANHATTAN_DISTANCE) {
            tempNode.hOfn = PuzzleBoard.calculateManhattanDistanceHeuristic(tempNode, goalNode);

        } else if (huristic == Node.SolveHuristic.MANHATTAN_PER_SEQUENCE) {
            tempNode.hOfn = PuzzleBoard.calculateManhattanPerSequencedHeuristic(
                    PuzzleBoard.calculateManhattanDistanceHeuristic(tempNode, goalNode),
                    PuzzleBoard.calculateSequencedSpace(tempNode));
        }
        tempNode.actionSequence.add("L");
        tempNode.gOfn += 1;
        tempNode.freeSpaceOrigin = PuzzleBoard.findFreeSpaceOrigin(tempNode.nodeInfo);
        return tempNode;
    }

    public static Node right(Node initialNode, Node goalNode, Node.SolveHuristic huristic) {
        Node tempNode = initialNode;
        int freeSpaceMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j];
        int targetMember = tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j + 1];

        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j + 1] = freeSpaceMember;
        tempNode.nodeInfo[tempNode.freeSpaceOrigin.i][tempNode.freeSpaceOrigin.j] = targetMember;
        if (huristic == Node.SolveHuristic.MISS_PLACE) {
            tempNode.hOfn = PuzzleBoard.calculateMissPlaceHeuristic(tempNode.nodeInfo, goalNode.nodeInfo);

        } else if (huristic == Node.SolveHuristic.MANHATTAN_DISTANCE) {
            tempNode.hOfn = PuzzleBoard.calculateManhattanDistanceHeuristic(tempNode, goalNode);

        } else if (huristic == Node.SolveHuristic.MANHATTAN_PER_SEQUENCE) {
            tempNode.hOfn = PuzzleBoard.calculateManhattanPerSequencedHeuristic(
                    PuzzleBoard.calculateManhattanDistanceHeuristic(tempNode, goalNode),
                    PuzzleBoard.calculateSequencedSpace(tempNode));
        }
        tempNode.actionSequence.add("R");
        tempNode.gOfn += 1;
        tempNode.freeSpaceOrigin = PuzzleBoard.findFreeSpaceOrigin(tempNode.nodeInfo);
        return tempNode;
    }
}
