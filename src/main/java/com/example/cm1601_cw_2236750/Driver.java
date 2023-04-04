package com.example.cm1601_cw_2236750;

import java.io.*;
import java.util.Scanner;

// Used to update, delete a driver and check whether a driver already exists
public class Driver {
    public String fileName; // Name of the file
    public String driverNameFind; // Name of the driver

    // Constructor to initialize the fileName and driverName
    Driver(String fileName, String driverName){
       this.fileName = fileName;
       this.driverNameFind = driverName;
    }

    // Used to check whether driver already exists
    public boolean driverExists(){
        File file = new File(fileName);
        boolean found = false;
        try {
            Scanner scanner = new Scanner(file);

            //now read the file line by line...
            int lineNum = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNum++;
                String name = String.format("%.20s", line);
                if(name.equals(driverNameFind)) {
                    found = true;

                }
            }
        } catch(FileNotFoundException e) {
            //handle this
            found = false;
        }
        return found;
    }

    // used to read from a file and write to another file
    public void updateFile(){
        try {
            BufferedReader readFile = new BufferedReader(new FileReader("TempFile.txt"));
            BufferedWriter writerFile = new BufferedWriter(new FileWriter("Racing.txt"));
            String line;

            // reading file line by line and writing the current line that is read to the other file
            while((line = readFile.readLine()) != null) {
                writerFile.write(line+"\n");
            }
            readFile.close();
            writerFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // used to update driver data
    public void updateDriverData(String dataFieldName, String newData, String updateName) {

        // if driver detail that needs to be updated is driver name
        if (dataFieldName.equals("driverNameUpdate")){
            try {
                BufferedReader readFile = new BufferedReader(new FileReader("Racing.txt"));
                BufferedWriter writerFile = new BufferedWriter(new FileWriter("TempFile.txt"));
                String line;

                // reading file line by line
                while((line = readFile.readLine()) != null) {
                    String name = String.format("%.20s", line);

                    // if name stores is equal to the driver that is needed to be updated, data is replaced
                    if (name.equals(updateName)){
                        line = line.replace(updateName,newData);
                        writerFile.write(line+"\n");
                    } else {
                        writerFile.write(line+"\n");
                    }
                }
                readFile.close();
                writerFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            updateFile();
        }

        // if driver detail that needs to be updated is driver age
        else if (dataFieldName.equals("driverAgeUpdate")){
            try {
                BufferedReader readFile = new BufferedReader(new FileReader("Racing.txt"));
                BufferedWriter writerFile = new BufferedWriter(new FileWriter("TempFile.txt"));
                String line;
                while((line = readFile.readLine()) != null) {
                    String name = String.format("%.20s", line);
                    if (name.equals(updateName)){
                        String age = line.substring(20,24);
                        line = line.replace(age,String.format("%-4s",newData));
                        writerFile.write(line+"\n");
                    } else {
                        writerFile.write(line+"\n");
                    }
                }
                readFile.close();
                writerFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            updateFile();
        }

        // if driver detail that needs to be updated is driver team name
        else if (dataFieldName.equals("driverTeamNameUpdate")) {
            try {
                BufferedReader readFile = new BufferedReader(new FileReader("Racing.txt"));
                BufferedWriter writerFile = new BufferedWriter(new FileWriter("TempFile.txt"));
                String line;
                while((line = readFile.readLine()) != null) {
                    String name = String.format("%.20s", line);
                    if (name.equals(updateName)){
                        String teamName = line.substring(24,44);
                        line = line.replace(teamName,String.format("%-20s",newData));
                        writerFile.write(line+"\n");
                    } else {
                        writerFile.write(line+"\n");
                    }
                }
                readFile.close();
                writerFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            updateFile();
        }

        // if driver detail that needs to be updated is driver car type
        else if (dataFieldName.equals("driverCarTypeUpdate")){
            try {
                BufferedReader readFile = new BufferedReader(new FileReader("Racing.txt"));
                BufferedWriter writerFile = new BufferedWriter(new FileWriter("TempFile.txt"));
                String line;
                while((line = readFile.readLine()) != null) {
                    String name = String.format("%.20s", line);
                    if (name.equals(updateName)){
                        String carType = line.substring(44,64);
                        line = line.replace(carType,String.format("%-20s",newData));
                        writerFile.write(line+"\n");
                    } else {
                        writerFile.write(line+"\n");
                    }
                }
                readFile.close();
                writerFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            updateFile();
        }

        // if driver detail that needs to be updated is driver points
        else if (dataFieldName.equals("driverCurrentPointsUpdate")){
            try {
                BufferedReader readFile = new BufferedReader(new FileReader("Racing.txt"));
                BufferedWriter writerFile = new BufferedWriter(new FileWriter("TempFile.txt"));
                String line;
                while((line = readFile.readLine()) != null) {
                    String name = String.format("%.20s", line);
                    if (name.equals(updateName)){
                        String currentPoints = line.substring(64,79);
                        line = line.replace(currentPoints,String.format("%-20s",newData));
                        writerFile.write(line+"\n");
                    } else {
                        writerFile.write(line+"\n");
                    }
                }
                readFile.close();
                writerFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            updateFile();
        }
    }

    // used to delete a driver
    public void deleteDriver(){
        try {
            BufferedReader readFile = new BufferedReader(new FileReader("Racing.txt"));
            BufferedWriter writerFile = new BufferedWriter(new FileWriter("TempFile.txt"));
            String line;
            while((line = readFile.readLine()) != null) {
                String name = String.format("%.20s", line);

                // if driver that needs to be deleted is found, that line is not written. Thus deleting the driver

                if (name.equals(driverNameFind)){
                    continue;
                } else {
                    writerFile.write(line+"\n");
                }
            }
            readFile.close();
            writerFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        updateFile();
    }
}