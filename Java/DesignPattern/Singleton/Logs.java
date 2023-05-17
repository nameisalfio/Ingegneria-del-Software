package Java.Singleton;

import java.util.ArrayList;
import java.util.List;

//Logs è un Singleton 

public class Logs
{
    //Tutti gli attributi statici 

    private static Logs uniqueIstance;    //unica istanza 
    private List<String> list;

    private Logs()  //viene eseguito quando viene creata l'unica istanza della classe
    {
        list = new ArrayList<>();
    }

    public static Logs getIstance()
    {
        if(null == uniqueIstance)
        {
            uniqueIstance = new Logs();
            return uniqueIstance;
        }
        return null;
    }

    public void insert(String val)
    {
        list.add(val);
    }

    public String  getLast()
    {
        return list.get(list.size()-1);
    }

    public String getAll()  //enhanced for
    {
        String toReturn = "";
        for(String str : list)
            toReturn = toReturn.concat(str).concat(" -- ");
        return toReturn;
    }

    public void empty()
    {
        list = new ArrayList<>();
    }

}
