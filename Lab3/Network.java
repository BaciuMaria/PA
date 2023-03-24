import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Network {
    public Comparator<? super Node> compare;
    private String name;
    public List<Node> nodes = new ArrayList<>();
    public Network(){}
    public Network(String name){ this.name= name; }
    public String getName(String name){ return this.name; }
    public void setName(String name){ this.name= name; }
    public void addNode(Node node) {
        nodes.add(node);
    }
    @Override
    public String toString() {
        return "Network{" +
                "name='" + name + '\'' +
                ", nodes=" + nodes +
                '}';
    }
    public Node getNode(int i)
    {
        return this.nodes.get(i);
    }
}