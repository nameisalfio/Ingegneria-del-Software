public class File implements Path{  //Leaf

    private String name;

    public File(String name){this.name = name;}

    @Override
    public void search(String filename){
        if(name.equals(filename))
            System.out.println("Found file " + name);
        /*else
            System.out.println("File " + name + " not found");*/
    }
}