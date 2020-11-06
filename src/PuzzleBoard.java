import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PuzzleBoard {

    public static void SolvePuzzle(Node initialNode, Node goalNode, Node.SolveHuristic huristic) throws Exception {

        System.out.println("Wait to solve ...");
        System.out.println("huristic : " + huristic);
        int checkedState = 0;

        String[] movementType = { "U", "D", "L", "R" };

        PriorityQueue<Node> NodesQueue = new PriorityQueue<Node>(800, (a, b) -> (a.hOfn + a.gOfn) - (b.hOfn + b.gOfn));

        Node fatherNode = initialNode.clone();
        if (huristic == Node.SolveHuristic.MISS_PLACE) {
            fatherNode.hOfn = calculateMissPlace(fatherNode.nodeInfo, goalNode.nodeInfo);
        } else if (huristic == Node.SolveHuristic.MANHATTAN_DISTANCE) {
            fatherNode.hOfn = calculateManhattanDIstance(fatherNode, goalNode);
        }
        fatherNode.freeSpaceOrigin = findFreeSpaceOrigin(fatherNode.nodeInfo);
        NodesQueue.add(fatherNode);

        boolean queueIsNotEmpty = !NodesQueue.isEmpty();
        while (queueIsNotEmpty) {
            checkedState++;
            Node smallestChild = NodesQueue.poll();

            // System.out.println(smallestChild.nodeInfo);
            // CustomPrinter.NodeMemberPrinter(smallestChild);

            if (smallestChild.hOfn == 0) {
                CustomPrinter.NodeMemberPrinter(smallestChild);
                CustomPrinter.printAactionSequnce(smallestChild);
                CustomPrinter.printNodeInformation(smallestChild);
                System.out.println(checkedState);
                return;
            }

            for (int i = 0; i < movementType.length; i++) {
                switch (movementType[i]) {
                    case "U":
                        if (smallestChild.freeSpaceOrigin.i > 0) {
                            Node upMoveChild = Movement.up(smallestChild.clone(), goalNode, huristic);
                            if (huristic == Node.SolveHuristic.MISS_PLACE) {
                                upMoveChild.hOfn = calculateMissPlace(upMoveChild.nodeInfo, goalNode.nodeInfo);
                            } else if (huristic == Node.SolveHuristic.MANHATTAN_DISTANCE) {
                                upMoveChild.hOfn = calculateManhattanDIstance(upMoveChild, goalNode);
                            }
                            NodesQueue.add(upMoveChild);
                        }

                        break;
                    case "D":
                        if (smallestChild.freeSpaceOrigin.i < 2) {
                            Node downMoveChild = Movement.down(smallestChild.clone(), goalNode, huristic);
                            if (huristic == Node.SolveHuristic.MISS_PLACE) {
                                downMoveChild.hOfn = calculateMissPlace(downMoveChild.nodeInfo, goalNode.nodeInfo);
                            } else if (huristic == Node.SolveHuristic.MANHATTAN_DISTANCE) {
                                downMoveChild.hOfn = calculateManhattanDIstance(downMoveChild, goalNode);
                            }
                            NodesQueue.add(downMoveChild);
                        }
                        break;
                    case "L":
                        if (smallestChild.freeSpaceOrigin.j > 0) {
                            Node leftMoveChild = Movement.left(smallestChild.clone(), goalNode, huristic);
                            if (huristic == Node.SolveHuristic.MISS_PLACE) {
                                leftMoveChild.hOfn = calculateMissPlace(leftMoveChild.nodeInfo, goalNode.nodeInfo);
                            } else if (huristic == Node.SolveHuristic.MANHATTAN_DISTANCE) {
                                leftMoveChild.hOfn = calculateManhattanDIstance(leftMoveChild, goalNode);
                            }
                            NodesQueue.add(leftMoveChild);
                        }
                        break;
                    case "R":
                        if (smallestChild.freeSpaceOrigin.j < 2) {
                            Node rightMoveChild = Movement.right(smallestChild.clone(), goalNode, huristic);
                            if (huristic == Node.SolveHuristic.MISS_PLACE) {
                                rightMoveChild.hOfn = calculateMissPlace(rightMoveChild.nodeInfo, goalNode.nodeInfo);

                            } else if (huristic == Node.SolveHuristic.MANHATTAN_DISTANCE) {
                                rightMoveChild.hOfn = calculateManhattanDIstance(rightMoveChild, goalNode);

                            }
                            NodesQueue.add(rightMoveChild);
                        }
                        break;
                }
            }
        }
        ;
    }

    public static boolean isSolvable(Node node) {
        int counter = 0;
        List<Integer> arrayLsit = new ArrayList<Integer>();

        for (int i = 0; i < node.nodeInfo.length; i++) {
            for (int j = 0; j < node.nodeInfo.length; j++) {
                arrayLsit.add(node.nodeInfo[i][j]);
            }
        }

        Integer[] arrayListToArray = new Integer[arrayLsit.size()];
        arrayLsit.toArray(arrayListToArray);

        for (int i = 0; i < arrayListToArray.length - 1; i++) {
            for (int j = i + 1; j < arrayListToArray.length; j++) {
                if (arrayListToArray[i] != 0 && arrayListToArray[j] != 0 && arrayListToArray[i] > arrayListToArray[j]) {
                    counter++;
                }
            }
        }
        return (counter % 2 == 0);
    }

    public static int calculateMissPlace(int[][] initialNode, int[][] goalNode) {
        int missPlace = 0;
        for (int i = 0; i < initialNode.length; i++) {
            for (int j = 0; j < initialNode[i].length; j++) {
                if (initialNode[i][j] != goalNode[i][j]) {
                    missPlace++;
                }
            }
        }
        return missPlace;
    }

    public static int calculateManhattanDIstance(Node initialNode, Node goalNode) {
        CustomOrigin currentTileOrigin;
        CustomOrigin goalTileOrigin;
        int distance, totalDistance = 0;
        for (int i = 0; i < 9; i++) {
            currentTileOrigin = initialNode.calculateTilePosition(i);
            goalTileOrigin = goalNode.calculateTilePosition(i);
            distance = Math.abs(currentTileOrigin.i - goalTileOrigin.i)
                    + Math.abs(currentTileOrigin.j - goalTileOrigin.j);
            totalDistance += distance;
        }
        return totalDistance;
    }

    public boolean checkState(Node initialNode, Node goalNode) {
        for (int i = 0; i < initialNode.nodeInfo.length; i++) {
            for (int j = 0; j < initialNode.nodeInfo[i].length; j++) {
                if (initialNode.nodeInfo[i][j] != goalNode.nodeInfo[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static CustomOrigin findFreeSpaceOrigin(int[][] nodeData) {
        CustomOrigin freeSpaceOrigin = new CustomOrigin();
        for (int i = 0; i < nodeData.length; i++) {
            for (int j = 0; j < nodeData.length; j++) {
                if (nodeData[i][j] == 0) {
                    freeSpaceOrigin = new CustomOrigin(i, j);
                }
            }
        }
        return freeSpaceOrigin;
    }
}
