package org.example;
import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;
    private String title;
    private String location;
    private Map<String, String> tags = new HashMap<>();
    public Document(){}
    public Document(String title, String id, String location){
        this.title=title;
        this.id=id;
        this.location=location;
    }
    public void addTag(String key, String obj) {
        tags.put(key, obj);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }
}
