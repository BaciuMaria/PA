package org.example.entities;

public class Artist extends Entity{
    private int id;
    private String name;

    public Artist(int id,String name) {
        this.id=id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
