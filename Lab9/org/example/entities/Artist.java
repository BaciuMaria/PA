package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "artists")
@NamedQueries({@NamedQuery(name = "Artist.findAll",query = "select e from artist e order by e.name"),})
public class Artist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
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
