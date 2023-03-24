package org.example;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    Map<Student, List<Project>> prefMap = new HashMap<>();
    List<Student> students = new ArrayList<>();
    TreeSet<Project> projects = new TreeSet<>(new projectComparator());
    public Problem() {}
    public Problem(List<Student> listOfStudents, TreeSet<Project> listOfProjects) {
        this.students = new ArrayList<>(listOfStudents);
        this.projects = (TreeSet) listOfProjects.clone();
    }
    public void addStudentsList(Student student, List<Project> projects) {
        prefMap.put(student,projects);
    }
    public List getProjects(Student s){
        return prefMap.get(s);
    }
    public List getStudents(Project p){

        List<Student> students= new ArrayList();

        for(Student s : prefMap.keySet())
            if(prefMap.get(s).contains(p))
               students.add(s);
        return students;
    }
    @Override
    public String toString() {
        return "Problem{" +
                "prefMap=" + prefMap +
                '}';
    }
    public double getAverage(){
        double average=0;
        for(Student s : prefMap.keySet())
            average= average + prefMap.get(s).size();
        return average / prefMap.values().size();
    }
    public void studentsBelowAverage (){
         students.stream()
                .filter(s -> prefMap.get(s).size() < getAverage())
                .forEach(System.out::println);
    }
    public void greedy() {

        TreeSet<Project> unassigned_projects = new TreeSet<>(projects);

        List<Student> free_students = new ArrayList<>(students);

        for (Student s : prefMap.keySet()) {
            for (Project p : prefMap.get(s)) {
                if (unassigned_projects.contains(p) && free_students.contains(s)) {
                    unassigned_projects.remove(p);
                    free_students.remove(s);
                    System.out.println(s.getName() + " - " + p.getName());
                }
            }
            if (free_students.contains(s)) {
                System.out.println(s.getName() + " - " + unassigned_projects.first());
                unassigned_projects.remove(unassigned_projects.first());
                free_students.remove(s);
            }
        }
    }
}
