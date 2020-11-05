import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        // int[][] testNodeInfo = { { 7, 6, 4 }, { 5, 2, 1 }, { 0, 3, 8 } }; solve
        // int[][] testNodeInfo = { { 8, 0, 4 }, { 2, 5, 6 }, { 3, 1, 7 } }; java out of
        // ram
        // int[][] testNodeInfo = { { 3, 6, 5 }, { 1, 7, 4 }, { 0, 2, 8 } }; solve
        // int[][] testNodeInfo = { { 2, 0, 1 }, { 4, 3, 7 }, { 6, 5, 8 } }; not
        // solveable
        int[][] testNodeInfo = { { 2, 0, 1 }, { 4, 3, 7 }, { 6, 5, 8 } };
        int[][] goalNodeInfo = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
        ArrayList<String> actionSequence = new ArrayList<String>();
        Node goalNode = new Node(0, 0, goalNodeInfo, actionSequence, PuzzleBoard.findFreeSpaceOrigin(goalNodeInfo));
        Node initialNode = new Node(PuzzleBoard.calculateMissPlace(testNodeInfo, goalNodeInfo), 0, testNodeInfo,
                actionSequence, PuzzleBoard.findFreeSpaceOrigin(testNodeInfo));

        if (PuzzleBoard.isSolvable(initialNode)) {
            PuzzleBoard.SolvePuzzle(initialNode, goalNode);
        } else {
            System.out.println();
            System.out.println("Can't solve this puzzle ! becuase invention is odd :(");
        }
    }
}
