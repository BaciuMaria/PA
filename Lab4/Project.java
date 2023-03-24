package org.example;

public class Project {
    public String name;
    public Project(){}
    public Project(String name)
    {this.name= name;}
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public int compareTo(Project other) {
        return this.name.compareTo(other.name);
    }
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}
