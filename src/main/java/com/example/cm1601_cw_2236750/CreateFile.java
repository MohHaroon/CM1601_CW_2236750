package com.example.cm1601_cw_2236750;
import java.io.*;

public class CreateFile {

    public String fileName;
    public String driverData;

    CreateFile(String fileName,String driverData){
        this.fileName = fileName;
        this.driverData = driverData;
    }
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
    public void saveToFile(){
        try {
            BufferedReader readFile = new BufferedReader(new FileReader("Racing.txt"));
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
