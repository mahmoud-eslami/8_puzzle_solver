import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PuzzleBoard {

    public static void SolvePuzzle(Node initialNode, Node goalNode) {

        System.out.println("method called");

        String[] movementType = { "U", "D", "L", "R" };

        PriorityQueue<Node> NodesQueue = new PriorityQueue<Node>(1200, (a, b) -> (a.hOfn + a.gOfn) - (b.hOfn + b.gOfn));

        Node fatherNode = new Node(initialNode.hOfn, initialNode.gOfn, initialNode.nodeInfo, initialNode.actionSequence,
                initialNode.freeSpaceOrigin);
        fatherNode.hOfn = calculateMissPlace(initialNode.nodeInfo, goalNode.nodeInfo);
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
                            System.out.println("up");

                            Node upMoveChild = Movement.up(smallestChild, goalNode);
                            upMoveChild.hOfn = calculateMissPlace(upMoveChild.nodeInfo, goalNode.nodeInfo);
                            NodesQueue.add(upMoveChild);
                            CustomPrinter.NodeMemberPrinter(upMoveChild);

                        }

                        break;
                    case "D":
                        if (smallestChild.freeSpaceOrigin.i < 2) {
                            System.out.println("down");

                            Node downMoveChild = Movement.down(smallestChild, goalNode);
                            downMoveChild.hOfn = calculateMissPlace(downMoveChild.nodeInfo, goalNode.nodeInfo);
                            NodesQueue.add(downMoveChild);
                            CustomPrinter.NodeMemberPrinter(downMoveChild);

                        }
                        break;
                    case "L":
                        if (smallestChild.freeSpaceOrigin.j > 0) {
                            System.out.println("left");

                            Node leftMoveChild = Movement.left(smallestChild, goalNode);
                            leftMoveChild.hOfn = calculateMissPlace(leftMoveChild.nodeInfo, goalNode.nodeInfo);
                            NodesQueue.add(leftMoveChild);
                            CustomPrinter.NodeMemberPrinter(leftMoveChild);

                        }
                        break;
                    case "R":
                        if (smallestChild.freeSpaceOrigin.j < 2) {
                            System.out.println("right");

                            Node rightMoveChild = Movement.right(smallestChild, goalNode);
                            rightMoveChild.hOfn = calculateMissPlace(rightMoveChild.nodeInfo, goalNode.nodeInfo);
                            NodesQueue.add(rightMoveChild);
                            CustomPrinter.NodeMemberPrinter(rightMoveChild);

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
