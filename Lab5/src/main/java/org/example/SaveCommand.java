package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class SaveCommand implements Commands {
    private Catalog catalog;
    private String path;
    public SaveCommand(Catalog catalog, String path){
        this.catalog=catalog;
        this.path=path;
    }
    @Override
    public void execute()
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(path + "\\catalog.json");
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.writeValue(
                file ,
                catalog);
    }
}
