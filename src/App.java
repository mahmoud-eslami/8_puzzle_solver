public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        int[][] testNodeInfo = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
        int[][] goalNodeInfo = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
        String[] actionSequence = {"U","D"};
        CustomOrigin freeOrigin = new CustomOrigin(2, 2);
        Node initialNode = new Node(0, 0, testNodeInfo, actionSequence, freeOrigin);
        Node goalNode = new Node(0, 0, goalNodeInfo, actionSequence, freeOrigin);

        CustomPrinter.NodeMemberPrinter(goalNode);
        CustomPrinter.printAactionSequnce(initialNode);
        CustomPrinter.printNodeInformation(initialNode);
    }
}
