package Olympians;
//package edu.marist.cmpt220l.olympians;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Main.Sex;

/**
 * The olympian manager manages instances of olympians
 */
public class OlympianManager {
    private Olympian[] olympians;

    /**
     * Construct a new olympian manager
     *
     * @param filePath The path to an lgoo file
     */
    public OlympianManager(String filePath)
    {
        //make sure the filepath ends with the proper extension
        if(!filePath.endsWith(".lgoo"))
        {
            System.out.println("Invalid file extension, must be lgoo");
            return;
        }
        try {
            //open the file
            BufferedReader input = new BufferedReader(new FileReader(filePath));
            String line;
            ArrayList olympianArrayList = new ArrayList();

            //read the first line, which must be "LGOO"
            line = input.readLine();
            if(line == null || !line.equals("LGOO"))
            {
                System.out.println("Invalid olympian file: first line must be 'LGOO'");
                return;
            }

            //read lines until the end of file, each line represents an olympian. It has the format
            //       <name>,<sex>,<age>
            while((line = input.readLine()) != null) {
                String[] tokens = line.split(",");
                if(tokens.length != 3)
                {
                    System.out.println("Invalid olympian line: " + line);
                    return;
                }

                Sex sex;
                if(tokens[1].trim().equals("M") || tokens[1].trim().equals("MALE"))
                    sex = Sex.MALE;
                else if(tokens[1].trim().equals("F") || tokens[1].trim().equals("FEMALE"))
                    sex = Sex.FEMALE;
                else
                {
                    System.out.println("Invalid olympian file, bad sex token: " + tokens[1]);
                    return;
                }

                int age;
                try {
                    age = Integer.parseInt(tokens[2]);
                }
                catch(NumberFormatException nfe)
                {
                    System.out.println("Invalid olympian file, bad age token: " + tokens[2]);
                    return;
                }
                //add the new olympian to our internal list
                olympianArrayList.add(new Olympian(tokens[0], sex, age));
            }

            //create the instance array, based on how many olympians were added to our internal list
            olympians = new Olympian[olympianArrayList.size()];
            for(int i=0; i < olympians.length; i++)
                olympians[i] = (Olympian)olympianArrayList.get(i);

        } catch(FileNotFoundException fnfe) {
            System.out.println("File " + filePath + " was not found, specify a valid file");
        } catch(IOException ioe) {
            System.out.println("Error trying to read file " + filePath);
        }
    }

    /**
     * Retrieve the list of olympians
     *
     * @return an array of olympians
     */
    public Olympian[] getOlympians() {
        return olympians;
    }
}
