package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Singleton {
    private static Singleton singleton=null;

    private List<Map<String,String>> lines;

    public Singleton getSingleton() {
        if (null==singleton) singleton = new Singleton();
        return singleton;
    }

    public List<Map<String, String>> getLines() {
        return lines;
    }

    public void setLines(List<Map<String, String>> lines) {
        this.lines = lines;
    }

    private Singleton() {
        this.lines = new ArrayList<>();
    }
}
