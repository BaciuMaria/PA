import java.util.HashMap;
import java.util.Map;

public class Person implements Node, Comparable<Person>{
    private String name;
    private int Id;
    Data data_nastere= new Data();
    private Map<Node, String> relationships = new HashMap<>();

    public Person(){}
    public Person(String name, int Id,int zi, int luna, int an){
        this.name= name;
        this.Id= Id;
        this.data_nastere.zi= zi;
        this.data_nastere.luna= luna;
        this.data_nastere.an= an;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getId() {
        return Id;
    }
    public String getData_nastere(){
        return data_nastere.zi + "." + data_nastere.luna + "." + data_nastere.an;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public void setData_nastere(Data data_nastere) {
        this.data_nastere.zi= data_nastere.zi;
        this.data_nastere.luna= data_nastere.luna;
        this.data_nastere.an= data_nastere.an;
    }
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.getName());
    }
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }
    public String getRelationship(Node node) {
        if(relationships.get(node)==null)
            return relationships.get(node);
        else return "There is no relationship.";
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                ", data_nastere=" + data_nastere +
                ", relationships=" + relationships +
                '}';
    }
    public Map<Node, String> getRelationships() {
        return this.relationships;
    }
    @Override
    public int nodeImportance() {
        return relationships.size();
    }

}