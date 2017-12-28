package Server.Controller;

import Server.Model.School;


import java.io.*;


public class Main {





    public void functosaveSchool(School school) {
       String nameOfSchool=school.getName();


        try {
            FileOutputStream fileOut =
                    new FileOutputStream(nameOfSchool+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(school);
            out.close();
            fileOut.close();
        } catch (IOException i) {

        }
    }

    public School functoLoadSchool(String schoolToLoad){

        School newSchool=null;



        //nu är det dags att ta upp object från hårdisk
        try {
            FileInputStream fileIn = new FileInputStream(schoolToLoad+".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            newSchool = (School) in.readObject();
            in.close();
            fileIn.close();




        } catch (IOException i) {

        } catch (ClassNotFoundException c) {}
        return newSchool;


    }








}
