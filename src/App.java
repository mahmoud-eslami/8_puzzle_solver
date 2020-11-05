import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] testNodeInfo = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 0, 8 } };
        int[][] goalNodeInfo = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
        ArrayList<String> actionSequence = new ArrayList<String>();
        Node goalNode = new Node(0, 0, goalNodeInfo, actionSequence, PuzzleBoard.findFreeSpaceOrigin(goalNodeInfo));
        Node initialNode = new Node(PuzzleBoard.calculateMissPlace(testNodeInfo, goalNodeInfo), 0, testNodeInfo,
                actionSequence, PuzzleBoard.findFreeSpaceOrigin(testNodeInfo));

        if (PuzzleBoard.isSolvable(initialNode)) {
            PuzzleBoard.SolvePuzzle();
            CustomPrinter.NodeMemberPrinter(initialNode);
            CustomPrinter.printAactionSequnce(initialNode);
            CustomPrinter.printNodeInformation(initialNode);
        } else {
            System.out.println();
            System.out.println("Can't solve this puzzle ! becuase invention is odd :(");
        }
    }
}
