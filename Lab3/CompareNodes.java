import java.util.Comparator;

public class CompareNodes implements Comparator<Node> {
    public int compare(Node node1, Node node2) {
        return Integer.compare(node1.nodeImportance(), node2.nodeImportance());
    }
}
