package com.example.cm1601_cw_2236750;
import java.io.*;

// used to create,add data to a file, and save data to a file
public class CreateFile {

    public String fileName; // Name of the file
    public String driverData; // Data to be written

    // Constructor to initialize the fileName and driverData
    CreateFile(String fileName,String driverData){
        this.fileName = fileName;
        this.driverData = driverData;
    }

    // appends data to a file
    // uses built-in functions like FileWriter and PrintWriter
    public void createAndWrite(){
        try {
            FileWriter writer = new FileWriter(fileName,true);
            PrintWriter writeFile = new PrintWriter(writer);
            writeFile.println(driverData);
            writeFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // reads from one file and writes to another file.
    public void saveToFile(){
        try {

            // file that is read.
            BufferedReader readFile = new BufferedReader(new FileReader("Racing.txt"));

            // file that is written to
            BufferedWriter writerFile = new BufferedWriter(new FileWriter(fileName));

            String line;
            while((line = readFile.readLine()) != null) {
                writerFile.write(line+"\n");
            }
            readFile.close();
            writerFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
