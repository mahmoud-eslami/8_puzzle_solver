public class App {
    public static void main(String[] args) throws Exception {
        int[][] testNodeInfo = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
        String[] actionSequence = { "U", "D" };
        CustomOrigin freeOrigin = new CustomOrigin(2, 2);
        Node node = new Node(0, 0, testNodeInfo, actionSequence, freeOrigin);
        System.out.println(node.toString());
    }
}
