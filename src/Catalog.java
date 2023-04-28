import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String name;
    public List<Document> docs = new ArrayList<>();
    public Catalog(){}
    public Catalog(String name){
        this.name=name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return  this.name;
    }
}