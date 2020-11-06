public class CustomPrinter {
    static void welcomeInfoPrinter() {
        System.out.println();
        System.out.println("**************************************");
        System.out.println("**     Welcome to 8 puzzle game     **");
        System.out.println("**************************************");
        System.out.println();
    }

    static void NodeMemberPrinter(Node node) {
        System.out.println();
        for (int i = 0; i < node.nodeInfo.length; i++) {
            for (int j = 0; j < node.nodeInfo.length; j++) {
                System.out.print("|" + node.nodeInfo[i][j] + "|");
            }
            System.out.println();
        }
    }

    static void printAactionSequnce(Node node) {
        System.out.println();
        System.out.println(node.actionSequence);
    }

    static void printNodeInformation(Node node) {
        System.out.println();
        System.out.println("G(n) = " + node.gOfn + " H(n) = " + node.hOfn + " F(n) = " + (node.gOfn + node.hOfn) + " ");
        System.out.println("origin.i = " + node.freeSpaceOrigin.i + " origin.j = " + node.freeSpaceOrigin.j);
        System.out.println();
    }
}