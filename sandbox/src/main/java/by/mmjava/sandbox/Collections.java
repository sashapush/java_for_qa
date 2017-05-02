package by.mmjava.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 5/2/2017.
 */
public class Collections {
    public static void main(String[] args) {
        String[] lang = {"java","c#","python","php"};
        List  languages = Arrays.asList("java","c#","python","php"); //new ArrayList<String>(); // List - interface; ArrayList - class which implements this interface
                for (Object l:languages){
            System.out.println("i want to learn " + l);
        }

    }

}
