import java.util.Objects;

public class Road {
    private String name;
    private RoadType type;
    private Location A;
    private Location B;
    private int length;
    private int speed_limit;

    public Road() {}
    public Road(String name, RoadType type, Location a, Location b, int length, int speed_limit) {
        this.name = name;
        this.type = type;
        this.A = a;
        this.B = b;
        this.length = length;
        this.speed_limit = speed_limit;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(RoadType type) {
        this.type = type;
    }
    public void setLocationA(Location a) {
        this.A = a;
    }
    public void setLocationB(Location b) {
        this.B = b;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setSpeedLimit(int speed_limit) {
        this.speed_limit = speed_limit ;
    }
    public String getName() {
        return name;
    }
    public RoadType getType() {
        return type;
    }
    public Location getLocationA() {
        return A;
    }
    public Location getLocationB() {
        return B;
    }
    public int getLength() {
        return length;
    }
    public int getSpeedLimit() {
        return speed_limit;
    }

    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", A=" + A +
                ", B=" + B +
                ", length=" + length +
                ", speed_limit=" + speed_limit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road road)) return false;
        return length == road.length && speed_limit == road.speed_limit && Objects.equals(name, road.name) && type == road.type && Objects.equals(A, road.A) && Objects.equals(B, road.B);
    }
}