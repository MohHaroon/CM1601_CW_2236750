package com.example.cm1601_cw_2236750;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DriverTableDisplay {
    public String fileName;
    DriverTableDisplay(String fileName){
        this.fileName = fileName;
    }

    public String driverSort(){
        String ndn = "";
        try {
            BufferedReader readFile = new BufferedReader(new FileReader("Racing.txt"));
            String line;
            int position = 0;
            while((line = readFile.readLine()) != null) {
                String name = String.format("%.20s", line);
                String age = line.substring(20,24);
                String teamName = line.substring(24,44);
                String carType = line.substring(44,64);
                String currentPoints = line.substring(64,79);
                position++;
                ndn = ndn + "\n" + name.trim() + " | " + age.trim() + " | " + teamName.trim() + " | "
                        + carType.trim() + " | " + currentPoints.trim() + " | " + position +"\n";
            }
            readFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ndn;
    }
}
