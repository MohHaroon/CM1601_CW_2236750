package com.example.cm1601_cw_2236750;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Usd to sort the drivers according to the points
public class DriverTableDisplay {
    private final String fileName; // File name

    // Constructor to initialize the fileName
    DriverTableDisplay(String fileName){
        this.fileName = fileName;
    }

    // sorts the drivers and stores in a string variable, to be returned
    public String driverSort(){

        // used to store driver data in an order
        String driverData = "";

        List<Integer> orderedPoints = new ArrayList<>(); // Used to store driver points
        List<String> orderedPointsDriver = new ArrayList<>(); // Used to store the driver name
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(fileName));
            String line;

            while((line = readFile.readLine()) != null) {

                String currentPoints = line.substring(64,79);
                String driverName = line.substring(0,20);
                orderedPoints.add(Integer.parseInt(currentPoints.trim()));
                orderedPointsDriver.add(driverName);

            }
            sortPoints(orderedPoints,orderedPointsDriver); // using sortPoints to order the data in both the lists
            readFile.close();
            for (int x =0;x < orderedPoints.size(); x++){
                BufferedReader readFileFind = new BufferedReader(new FileReader(fileName));
                String lineNum;
                while((lineNum = readFileFind.readLine()) != null) {
                    String name = lineNum.substring(0,20);
                    String age = lineNum.substring(20,24);
                    String teamName = lineNum.substring(24,44);
                    String carType = lineNum.substring(44,64);
                    String currentPoints = lineNum.substring(64,79);
                    int currentPoint = orderedPoints.get(x);
                    String currentDriver = orderedPointsDriver.get(x);

                    // Driver details if found, is passed to the variable
                    if ((String.valueOf(currentPoint)).equals(currentPoints.trim()) && (currentDriver.equals(name))){
                        driverData = driverData + "\n" + name.trim() + "  |  " + age.trim() + "  |  " + teamName.trim()
                                + "  |  " + carType.trim() + "  |  " + currentPoints.trim() + "\n";
                    }
                }
            }
            readFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return driverData;
    }

    //sorting the points using bubble-sort
    public void sortPoints(List <Integer> orderedPoints, List <String> orderedPointsDriver){
            for (int i =0; i < orderedPoints.size();i++){
                for (int z = i +1; z < orderedPoints.size();z++){
                    int tempI = orderedPoints.get(i);
                    int tempZ = orderedPoints.get(z);

                    // if the tempI is smaller than tempZ, then Z and I is swapped in both the lists.
                    if (tempI  < tempZ){

                        int tmp = orderedPoints.get(i);
                        String temp = orderedPointsDriver.get(i);
                        orderedPoints.set(i,orderedPoints.get(z));
                        orderedPoints.set(z,tmp);
                        orderedPointsDriver.set(i, orderedPointsDriver.get(z));
                        orderedPointsDriver.set(z,temp);
                    }
                }
            }
    }
}
