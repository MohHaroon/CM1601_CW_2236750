package com.example.cm1601_cw_2236750;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

// Used to simulate a race
public class Races {

    // returns all the drivers that exist
    public List<String> getDriver(){
        List<String> driverList = new ArrayList<String>();
        try {
            BufferedReader driverInfo = new BufferedReader(new FileReader("Racing.txt"));
            String line;
            while((line = driverInfo.readLine()) != null) {
                driverList.add(line.substring(0,20));
            }
            driverInfo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return driverList;
    }

    // returns a list of points, of the drivers
    public List<String> driverInfoRace(List <String> drivers){
        List<String> pointsList = new ArrayList<String>();
        for (int position = 0; position < drivers.size(); position++){
            try {
                BufferedReader driverInfo = new BufferedReader(new FileReader("Racing.txt"));
                String line;
                while((line = driverInfo.readLine()) != null) {
                    if (drivers.get(position).equals(line.substring(0,20))){
                        pointsList.add(line.substring(64,79));
                    }
                }
                driverInfo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return pointsList;
    }

    // Simulates the race.
    public void simulateRace(){
        String [] locations = {"Nyirad","Holjes","Montalegre","Barcelona","Riga","Norway"};

        // Instance to get random integers for the date
        Random raceInfo = new Random();
        int date = raceInfo.nextInt(1,28);
        int month = raceInfo.nextInt(1,12);
        int year = raceInfo.nextInt(2023,2024);
        int locationCode = raceInfo.nextInt(0, locations.length);

        LocalDate dateRace = LocalDate.of(year,month,date);


        List <String> drivers = getDriver(); // getting the existing drivers list
        Collections.shuffle(drivers); // shuffling drivers list
        List <String> driverPoints = driverInfoRace(drivers); // getting the existing drivers' points list

        // Initializing variables to update the points of the top 3 drivers
        String position1points = driverPoints.get(0);
        String position2points = driverPoints.get(1);
        String position3points = driverPoints.get(2);

        // Initializing the new points of the top 3 drivers
        int position1 = Integer.parseInt(position1points.trim()) + 10;
        int position2 = Integer.parseInt(position2points.trim()) + 7;
        int position3 = Integer.parseInt(position3points.trim()) + 5;

        // Replacing the new points in the first 3 positions of the driver points list
        driverPoints.set(0, String.valueOf(position1));
        driverPoints.set(1, String.valueOf(position2));
        driverPoints.set(2, String.valueOf(position3));

        // Updating the points of the top 3 drivers in the text file
        for (int position = 0; position < 3;position++){
            Driver updateDriverPoints = new Driver("Racing.txt",drivers.get(position));
            updateDriverPoints.updateDriverData("driverCurrentPointsUpdate",driverPoints.get(position)
                    ,drivers.get(position));
        }

        // "writeToFile" is used to store the data that needs to be returned
        String writeToFile = "Date" + "              " + "Location"+"\n";
        writeToFile += dateRace + "        " + locations[locationCode]+"\n";
        writeToFile += "Driver Name" + "     " + "Current Points"+ "        " + "Position\n";

        int pos = 1;
        for (int positionCount = 0; positionCount < drivers.size();positionCount++){
            String currentPoints = String.format("%-15s",driverPoints.get(positionCount));
            writeToFile += drivers.get(positionCount) + currentPoints + "      " +pos+"\n";
            pos++;
        }

        // Data is added to a text file, which stores data about races.
        CreateFile racesSummary = new CreateFile("RaceSummary.txt",writeToFile);
        racesSummary.createAndWrite();

    }
}