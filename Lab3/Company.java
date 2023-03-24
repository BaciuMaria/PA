import java.util.Map;

public class Company implements Node,Comparable<Company>{
    private String name;
    private int Id;
    public Company(){}
    public Company(String name, int Id){
        this.name= name;
        this.Id= Id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getId() {
        return Id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.getName());
    }
    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }
    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                '}';
    }
    @Override
    public int nodeImportance() {
        return 0;
    }
}
