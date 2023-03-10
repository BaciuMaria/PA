import java.util.Arrays;
import java.util.Objects;

public class Problem {
    private Location[] locations = new Location[100];
    private Road[] roads = new Road[100];
    public String location1;
    public int loc1;
    public String location2;
    public int loc2;
    public int nr_locations = 0;
    public int nr_roads = 0;
    public boolean[] visited = new boolean[100];
    public Problem() {
    }
    public String addLocation(String name, LocationType type, double x, double y) {
        locations[this.nr_locations++] = new Location(name, type, x, y);
        if (this.nr_locations > 1) {
            for (int i = 0; i < this.nr_locations - 1; i++)
                if (locations[i].equals(locations[this.nr_locations - 1])) {
                    this.nr_locations--;
                    return "The location already exists.";
                }
        }
        return "Valid location.";
    }

    public String addRoad(String name, RoadType type, int location1, int location2, int length, int speed_limit) {
        roads[this.nr_roads++] = new Road(name, type, locations[location1-1], locations[location2-1], length, speed_limit);
        if (this.nr_roads > 1) {
            for (int i = 0; i < this.nr_roads - 1; i++)
                if (roads[i].equals(roads[this.nr_roads])) {
                    this.nr_roads--;
                    return "The road already exists.";
                }
        }
        return "Valid road.";
    }
    public void setLocation1(String name) {
        this.location1 = name;
    }

    public void setLocation2(String name) {
        this.location2 = name;
    }

    public int getNr_Locations() {
        return nr_locations;
    }

    public int getNr_Roads() {
        return nr_roads;
    }

    public String getLocation(int number_location) {
        if (number_location > nr_locations)
            return "This location doesn't exist.";
        return locations[number_location].toString();
    }

    public String getRoad(int number_road) {
        if (number_road > nr_roads)
            return "This road doesn't exist.";
        return roads[number_road - 1].toString();
    }

    public boolean ValidInstance() {

        if (this.location1 == this.location2)
            return false;
        for (int i = 0; i < this.nr_locations; i++)
            if (locations[i].getName() == location1)
                for (int j = 0; j < this.nr_locations; j++)
                    if (locations[j].getName() == location2) {
                        this.loc1 = i;
                        this.loc2 = j;
                        return true;
                    }
        return false;
    }

    public int getLocationNumber(Location a) {
        for (int i = 0; i < nr_locations; i++)
            if (locations[i] == a)
                return i;
        return -1;
    }
    public void booleanFill(){
        for(int i=0; i< nr_locations; i++)
            visited[i]=false;
    }
    public String pathExistance() {
        booleanFill();
        if (visitLocations(this.loc1, this.loc2))
            return "Path exists.";
        else return "Path doesn't exists.";
    }
    public boolean visitLocations(int source, int destination){
        if (locations[source].equals(locations[destination]))
            return true;
        visited[source] = true;
        for (int i = 0; i < nr_roads; i++){
            if (locations[source].equals(roads[i].getLocationA())) {
                int new_source = getLocationNumber(roads[i].getLocationB());
                if (!visited[new_source])
                    visitLocations(new_source, destination);
            }
            if (locations[source].equals(roads[i].getLocationB())) {
                int new_source = getLocationNumber(roads[i].getLocationA());
                if (!visited[new_source])
                    visitLocations(new_source, destination);
            }
        }
        return false;
    }
}