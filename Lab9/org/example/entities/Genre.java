package org.example.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "genres")
@NamedQueries({@NamedQuery(name = "Genre.findAll",query = "select e from genres e order by e.id"),})
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
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
