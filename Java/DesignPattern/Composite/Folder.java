import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Folder implements Path{    //Composite

    private Set<Path> set = new HashSet<>();
    private String name;

    public Folder(String name){this.name = name;}

    public void add(Path component){
        set.add(component);
    }

    public void remove(Path component){
        set.remove(component);
    }

    @Override
    public void search(String filename){
        System.out.println("Searching file " + filename + " in folder " + name);
        for(Path path : set)
            path.search(filename);
    }
}