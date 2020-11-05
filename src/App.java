import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] testNodeInfo = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 5, 8 } };
        int[][] goalNodeInfo = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
        ArrayList<String> actionSequence = new ArrayList<String>();
        Node goalNode = new Node(0, 0, goalNodeInfo, actionSequence, PuzzleBoard.findFreeSpaceOrigin(goalNodeInfo));
        Node initialNode = new Node(PuzzleBoard.calculateMissPlace(testNodeInfo, goalNodeInfo), 0, testNodeInfo,
                actionSequence, PuzzleBoard.findFreeSpaceOrigin(testNodeInfo));

        CustomPrinter.NodeMemberPrinter(initialNode);
        // if (PuzzleBoard.isSolvable(initialNode)) {
        //     PuzzleBoard.SolvePuzzle(initialNode, goalNode);
        // } else {
        //     System.out.println();
        //     System.out.println("Can't solve this puzzle ! becuase invention is odd :(");
        // }

        Node up = Movement.up(initialNode.clone(), goalNode);
        CustomPrinter.NodeMemberPrinter(up);
        CustomPrinter.printAactionSequnce(up);
        CustomPrinter.printNodeInformation(up);

        Node down = Movement.down(initialNode.clone(), goalNode);
        CustomPrinter.NodeMemberPrinter(down);
        CustomPrinter.printAactionSequnce(down);
        CustomPrinter.printNodeInformation(down);

        Node left = Movement.left(initialNode.clone(), goalNode);
        CustomPrinter.NodeMemberPrinter(left);
        CustomPrinter.printAactionSequnce(left);
        CustomPrinter.printNodeInformation(left);

        Node right = Movement.right(initialNode.clone(), goalNode);
        CustomPrinter.NodeMemberPrinter(right);
        CustomPrinter.printAactionSequnce(right);
        CustomPrinter.printNodeInformation(right);


    }
}
