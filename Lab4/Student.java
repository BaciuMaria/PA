package org.example;

public class Student {
    public String name;
    public Student() {}
    public Student(String name) {
        this.name = name;
    }
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
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
