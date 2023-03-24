import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) {

        Network n1= new Network("A");
        Person p1= new Person("Maria",6702,6,7,2002);
        Person p2= new Person("Anca",6666,26,2,2002);
        Person p3= new Person("Irina",7777,5,4,2001);
        Person p4= new Person("Laura",2468,7,6,2002);
        Person p5= new Person("Bogdan",6768,6,6,2000);
        Person p6= new Person("Alex",2402,7,7,2000);
        Company c1= new Company("Lidl",1234);
        Company c2= new Company("Orange",1010);
        n1.addNode(p1);
        n1.addNode(p2);
        n1.addNode(p3);
        n1.addNode(p4);
        n1.addNode(p5);
        n1.addNode(p6);
        n1.addNode(c1);
        n1.addNode(c2);
        p1.addRelationship(p2,"best-friends");
        p1.addRelationship(p3,"roommates");
        p1.addRelationship(p4,"sisters");
        p2.addRelationship(p6,"married");
        p3.addRelationship(p5,"best-friends");
        p1.addRelationship(c1,"cashier");
        p3.addRelationship(c1,"boss");
        p4.addRelationship(c2,"boss");
        p5.addRelationship(c2,"programmer");
        p6.addRelationship(c2,"designer");
        CompareNodes compare= new CompareNodes();
        Collections.sort(n1.nodes, compare);
        System.out.println(n1.toString());
    }
}