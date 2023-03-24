package org.example;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class Lab4 {
    public static void main(String[] args) {
        Lab4 lab4= new Lab4();
        lab4.compulsory();
        lab4.homework();
    }
    void compulsory() {
        List<Student> students = new LinkedList<>();
        TreeSet<Project> listOfProjects = new TreeSet<>(new projectComparator());

        Student s0 = new Student("S2");
        Student s1 = new Student("S0");
        Student s2 = new Student("S1");

        Project p0 = new Project("P2");
        Project p1 = new Project("P1");
        Project p2 = new Project("P0");

        students.add(s0);
        students.add(s1);
        students.add(s2);

        listOfProjects.add(p0);
        listOfProjects.add(p1);
        listOfProjects.add(p2);

        List<Student> listOfStudents = students.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());

        listOfStudents
                .stream()
                .forEach(i -> System.out.println(i.getName()));
        listOfProjects
                .stream()
                .forEach(i -> System.out.println(i.getName()));
    }
    void homework() {

        Faker faker = new Faker();
        List<Student> students = new LinkedList<>();
        TreeSet<Project> listOfProjects = new TreeSet<>(new projectComparator());

        Student s0 = new Student(faker.name().fullName());
        Student s1 = new Student(faker.name().fullName());
        Student s2 = new Student(faker.name().fullName());
        Student s3 = new Student(faker.name().fullName());
        Student s4 = new Student(faker.name().fullName());

        Project p0 = new Project(faker.app().name());
        Project p1 = new Project(faker.app().name());
        Project p2 = new Project(faker.app().name());
        Project p3 = new Project(faker.app().name());
        Project p4 = new Project(faker.app().name());

        students.add(s0);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        listOfProjects.add(p0);
        listOfProjects.add(p1);
        listOfProjects.add(p2);
        listOfProjects.add(p3);
        listOfProjects.add(p4);

        List<Student> listOfStudents = students.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());

        Problem problem = new Problem(listOfStudents,listOfProjects);

        problem.addStudentsList(s0, Arrays.asList( p0, p1, p2, p3, p4));
        problem.addStudentsList(s1, Arrays.asList( p1, p3, p4));
        problem.addStudentsList(s2, Arrays.asList( p3 ));
        problem.addStudentsList(s3, Arrays.asList( p2, p3, p4));
        problem.addStudentsList(s4, Arrays.asList( p0, p2 ));
        System.out.println(problem);

        System.out.println("Average number of preferences: " + problem.getAverage());
        System.out.println("All the students that have a number of preferences lower than the average number of preferences: ");
        problem.studentsBelowAverage();
        problem.greedy();
    }
}