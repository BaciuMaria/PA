import java.util.Objects;

public class Location {
    private String name;
    private LocationType type;
    public double X;
    public double Y;

    public Location() {
    }

    public Location(String name, LocationType type, double x, double y) {
        this.name = name;
        this.type = type;
        this.X = x;
        this.Y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public void setX(double x) {
        this.X = x;
    }

    public void setY(double y) {
        this.Y = y;
    }

    public String getName() {
        return name;
    }

    public LocationType getType() {
        return type;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", X=" + X +
                ", Y=" + Y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Double.compare(location.X, X) == 0 && Double.compare(location.Y, Y) == 0 && Objects.equals(name, location.name) && type == location.type;
    }
}