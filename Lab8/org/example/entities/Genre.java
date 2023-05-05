package org.example.entities;

public class Genre extends Entity{
    private int id;
    private String name;

    public Genre(int id,String name) {
        this.id = id;
        this.name=name;
    }
    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
