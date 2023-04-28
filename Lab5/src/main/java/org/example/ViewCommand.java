package org.example;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
public class ViewCommand implements Commands{
    private String path;
    public ViewCommand(String path){
        this.path=path;
    }
    @Override
    public void execute()
        throws IOException{
           // Desktop.open(new File(path));
    }
}
