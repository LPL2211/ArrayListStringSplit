

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class StringDB {

    public static void main(String[] args) {

        StringDB executor = new StringDB();

        ArrayList<String> db = new ArrayList();
        db.add("SELECT * FROM courses ;");
        db.add("DROP TABLE students ;");
        db.add("CREATE TABLE teachers ( name varchar , username varchar ) ;");
        db.add("INSERT INTO teachers VALUES ( 'name' , 'initial' ) ;");
        db.add("SELECT name AS alias , username AS secret_email INTO superheroes FROM teachers ;");
        db.add("SELECT * INTO joined FROM orders INNER JOIN customers ON CustomerID = ID ;");
       

        for (String curVal : db) {

            executor.execute(curVal);

        }


    }

    public void execute(String command) {

        ArrayList<String> splitted = new ArrayList<>();

        Collections.addAll(splitted, command.split(" "));



        for(String string: splitted){
            if(string.matches(",")){
                string.length();
                System.out.println(string.length());
            }
        }

        int commas = Collections.frequency(splitted, ',');

        if (splitted.get(0).contains("SELECT") && splitted.get(2).contains("FROM")) {
            System.out.println("It prints everything from the table called" + " " + splitted.get(3));

        } else if (splitted.get(0).contains("DROP")) {
            System.out.println("It completely removes the table called " + splitted.get(2) + "... be careful");

        } else if (splitted.get(0).contains("CREATE") && commas > 1){
            // int comma = Collections.frequency(splitted, ',') ;
            // int commas = comma + 1;

            //if (comma > 1) {
            // System.out.println(comma);
            System.out.println("It creates a new table called " + splitted.get(2));
            System.out.println(" The table has " + commas + " columns, called:");
            System.out.println("[" + splitted.get(4) + "," + splitted.get(7) + "]");
            System.out.println(commas);

        } else if (splitted.get(0).contains("CREATE") && commas ==1) {
            // int comma = Collections.frequency(splitted, ',') ;
            // int commas = comma + 1;
            System.out.println("It creates a new table called " + splitted.get(2));
            System.out.println(" The table has " + commas +" columns, called:");
            System.out.println("[" + splitted.get(4)+"]");


        } else if (splitted.get(0).contains("INSERT")) {
            System.out.println("It inserts a new row into the table called " + splitted.get(2) + " The row has the 2 values:");
            System.out.println("[" + splitted.get(5).replaceAll("[']","") +  "," +  splitted.get(7).replaceAll("[']", "") + "]");

        }

    }

}



