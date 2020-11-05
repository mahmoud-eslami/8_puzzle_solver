import java.util.ArrayList;
import java.util.List;

public class PuzzleBoard {

    public boolean isSolvable(Node node) {
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

    public int calculateMissPlace(Node initialNode, Node goalNode) {
        int missPlace = 0;
        for (int i = 0; i < initialNode.nodeInfo.length; i++) {
            for (int j = 0; j < initialNode.nodeInfo[i].length; j++) {
                if (initialNode.nodeInfo[i][j] != goalNode.nodeInfo[i][j]) {
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

    public CustomOrigin findFreeSpaceOrigin(int[][] nodeData) {
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
