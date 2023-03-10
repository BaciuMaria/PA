/**
 *  An instance of the "Best Route Problem" consists of locations and roads. Locations may be cities, airports, gas stations, etc.
 * Two locations may be connected by a road, or not. Roads may be highways, express, country, etc.
 *
 *     Each location has a name, type and x, y coordinates (assume that the locations are placed in a cartesian coordinate system).
 *     Each road has a type, length and a speed limit. The length of a road should not be less than the euclidian distance between the location coordinates.
 *
 * We consider the problem of determining the "best" route from one location to another.
 */
public class Lab2 {
    public static void main(String[] args) {
        Lab2 lab2= new Lab2();
        lab2.compulsory();
        lab2.homework();
    }
    void compulsory(){
        Location l1 = new Location();
        l1.setName("Galati");
        l1.setType(LocationType.CITY);
        l1.setX(6.7);
        l1.setY(8.9);
        System.out.println(l1.toString());
        Location l2 = new Location("Braila", LocationType.VILLAGE,5.5,6.6);
        System.out.println(l2.toString());
        Road r1 = new Road("Pod Galati-Braila", RoadType.HIGHWAY, l1, l2, 20, 60);
        System.out.println(r1.toString());
    }
    void homework() {
        Problem p1 = new Problem();
        System.out.println(p1.addLocation("Galati", LocationType.CITY, 6.7, 8.9));
        System.out.println(p1.addLocation("Galati", LocationType.CITY, 6.7, 8.9));
        System.out.println(p1.addLocation("Braila", LocationType.VILLAGE, 5.5, 6.6));
        System.out.println(p1.addLocation("Constanta", LocationType.CITY, 8.8, 3.4));
        System.out.println(p1.addLocation("PECO", LocationType.GAS_STATION, 10.11, 1.1));
        System.out.println(p1.addLocation("Petrom", LocationType.GAS_STATION, 6.0, 7.0));
        System.out.println(p1.addLocation("Aeroport", LocationType.AIR_PORT, 7.7, 7.7));
        System.out.println(p1.addLocation("Cluj", LocationType.CITY, 0.0, 0.0));
        System.out.println(p1.addRoad("Pod Galati-Braila", RoadType.HIGHWAY, 1, 2, 20, 60));
        System.out.println(p1.addRoad("DN21", RoadType.HIGHWAY, 2, 3, 200, 80));
        System.out.println(p1.addRoad("Strada Izvor", RoadType.HIGHWAY, 3, 4, 5, 60));
        System.out.println(p1.addRoad("Strada Martisor", RoadType.HIGHWAY, 2, 5, 10, 60));
        System.out.println(p1.addRoad("Strada Otelarilor", RoadType.HIGHWAY, 1, 5, 10, 60));
        System.out.println(p1.addRoad("DN26", RoadType.HIGHWAY, 5, 6, 20, 60));

        p1.setLocation1("Iasi");
        p1.setLocation2("Constanta");
        if (p1.ValidInstance() == true)
            System.out.println("The problem's instance is valid.");
        else System.out.println("The problem's instance is invalid.");
        p1.setLocation1("Aeroport");
        System.out.println(p1.pathExistance());
    }
}