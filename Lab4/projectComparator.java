package org.example;
import java.util.Comparator;
public class projectComparator implements Comparator<Project>
{
    public int compare(Project p1, Project p2)
    {
        return p1.getName().compareTo(p2.getName());
    }
}