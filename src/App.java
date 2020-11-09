import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] userNodeInfo = new int[3][3];
        Scanner myInput = new Scanner(System.in);
        System.out.println("notice : enter 0 instead of free space.");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("enter member in origin(" + i + "," + j + ")");
                String member = myInput.nextLine();
                userNodeInfo[i][j] = Integer.parseInt(member);
            }
        }
        
        int[][] goalNodeInfo = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
        ArrayList<String> actionSequence = new ArrayList<String>();
        Node goalNode = new Node(0.0, 0.0, goalNodeInfo, actionSequence, PuzzleBoard.findFreeSpaceOrigin(goalNodeInfo));
        Node initialNode = new Node(PuzzleBoard.calculateMissPlace(userNodeInfo, goalNodeInfo), 0.0, userNodeInfo,
                actionSequence, PuzzleBoard.findFreeSpaceOrigin(userNodeInfo));

        if (PuzzleBoard.isSolvable(initialNode)) {
            CustomPrinter.welcomeInfoPrinter();
            PuzzleBoard.SolvePuzzle(initialNode, goalNode, Node.SolveHuristic.MANHATTAN_PER_SEQUENCE);
        } else {
            System.out.println();
            System.out.println("Can't solve this puzzle ! becuase inversion is odd :(");
        }
    }
}
