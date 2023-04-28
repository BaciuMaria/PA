package org.example;
import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Token> nrList;
    public Cell(){
        this.nrList = new ArrayList<>();
    }
    public void setNrList(List<Token> nrList){
        this.nrList=nrList;
    }
    public List<Token> getNrList(){
        return nrList;
    }
    @Override
    public String toString() {
        return "Cell{" +
                "nrList=" + nrList +
                '}';
    }
}
