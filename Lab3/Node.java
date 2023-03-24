import java.util.Map;

public interface Node{
    String getName();
    int getId();
    int compareTo(Person other);
    int compareTo(Company other);
    default double getWeight() {
        return 0.0;
    }
    int nodeImportance();
}