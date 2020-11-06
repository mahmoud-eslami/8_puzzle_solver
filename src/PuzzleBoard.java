import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PuzzleBoard {

    public static void SolvePuzzle(Node initialNode, Node goalNode,Node.SolveHuristic huristic) throws Exception{

        System.out.println("Wait to solve ...");

        String[] movementType = { "U", "D", "L", "R" };

        PriorityQueue<Node> NodesQueue = new PriorityQueue<Node>(800, (a, b) -> (a.hOfn + a.gOfn) - (b.hOfn + b.gOfn));

        Node fatherNode = initialNode.clone();
        fatherNode.hOfn = calculateMissPlace(fatherNode.nodeInfo, goalNode.nodeInfo);
        fatherNode.freeSpaceOrigin = findFreeSpaceOrigin(fatherNode.nodeInfo);
        NodesQueue.add(fatherNode);

        boolean queueIsNotEmpty = !NodesQueue.isEmpty();
        while (queueIsNotEmpty) {
            Node smallestChild = NodesQueue.poll();

            // System.out.println(smallestChild.nodeInfo);
            // CustomPrinter.NodeMemberPrinter(smallestChild);

            if (smallestChild.hOfn == 0) {
                CustomPrinter.NodeMemberPrinter(smallestChild);
                CustomPrinter.printAactionSequnce(smallestChild);
                CustomPrinter.printNodeInformation(smallestChild);
                return;
            }

            for (int i = 0; i < movementType.length; i++) {
                switch (movementType[i]) {
                    case "U":
                        if (smallestChild.freeSpaceOrigin.i > 0) {
                            Node upMoveChild = Movement.up(smallestChild.clone(), goalNode,huristic);
                            upMoveChild.hOfn = calculateMissPlace(upMoveChild.nodeInfo, goalNode.nodeInfo);
                            NodesQueue.add(upMoveChild);
                        }

                        break;
                    case "D":
                        if (smallestChild.freeSpaceOrigin.i < 2) {
                            Node downMoveChild = Movement.down(smallestChild.clone(), goalNode,huristic);
                            downMoveChild.hOfn = calculateMissPlace(downMoveChild.nodeInfo, goalNode.nodeInfo);
                            NodesQueue.add(downMoveChild);
                        }
                        break;
                    case "L":
                        if (smallestChild.freeSpaceOrigin.j > 0) {
                            Node leftMoveChild = Movement.left(smallestChild.clone(), goalNode,huristic);
                            leftMoveChild.hOfn = calculateMissPlace(leftMoveChild.nodeInfo, goalNode.nodeInfo);
                            NodesQueue.add(leftMoveChild);
                        }
                        break;
                    case "R":
                        if (smallestChild.freeSpaceOrigin.j < 2) {
                            Node rightMoveChild = Movement.right(smallestChild.clone(), goalNode,huristic);
                            rightMoveChild.hOfn = calculateMissPlace(rightMoveChild.nodeInfo, goalNode.nodeInfo);
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

    public int calculateManhattanDIstance(Node initialNode, Node goalNode) {
        return 2;
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
