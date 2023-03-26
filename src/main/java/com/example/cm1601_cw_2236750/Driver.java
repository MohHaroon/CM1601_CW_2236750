package com.example.cm1601_cw_2236750;

import java.io.*;
import java.util.Scanner;

public class Driver {
    public String fileName;
    public String driverNameFind;
    Driver(String fileName, String driverName){
       this.fileName = fileName;
       this.driverNameFind = driverName;
    }

    public boolean driverExists(){
        File file = new File(fileName);
        Boolean found = false;
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

    public void updateDriverData(String dataFieldName, String newData, String updateName) {
//        if (dataFieldName.equals("driverNameUpdate")) {
//
////            try {
//////                CreateFile tempFile = new CreateFile("TempFile","");
//////                FileReader readFile = new FileReader("D:\\A1  sem2\\programming cw\\CM1601_CW_2236750\\src\\main\\java\\com\\example\\cm1601_cw_2236750\\Racing.txt");
//////                FileWriter writeFile = new FileWriter("D:\\A1  sem2\\programming cw\\CM1601_CW_2236750\\src\\main\\java\\com\\example\\cm1601_cw_2236750\\TempFile.txt");
//////                //now read the file line by line...
////                int lineNum;
////                String fileData = "";
//////                while ((lineNum = readFile.read()) != -1) {
//////                    String name = String.format("%.20s", (char)lineNum);
//////                    String []line = (char)lineNum;
//////                    if (name.equals(driverNameFind)){
//////                        (char)lineNum[0:20]
//////                    }
//////                    // Storing every character in the string
//////                    fileData += (char)lineNum;
//////                }
//////                writeFile.write(fileData);
//////                readFile.close();
//////                writeFile.close();
//////                while (scanner.hasNextLine()) {
//////                    String line = scanner.nextLine();
//////                    lineNum++;
//////                    String name = String.format("%.20s", line);
//////                    if (name.equals(driverNameFind)) {
//////                        line.replace(driverNameFind,newData);
//////                        file.
//////                    }
//////                }
////
//////            }catch(FileNotFoundException e) {
//////                        //handle this
//////
//////            } catch (IOException e) {
//////                throw new RuntimeException(e);
//////            }
////        }
        if (dataFieldName.equals("driverNameUpdate")){
            try {
                BufferedReader readFile = new BufferedReader(new FileReader("Racing.txt"));
                BufferedWriter writerFile = new BufferedWriter(new FileWriter("TempFile.txt"));
                String line;
                while((line = readFile.readLine()) != null) {
                    String name = String.format("%.20s", line);
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

            try {
                BufferedReader readFile = new BufferedReader(new FileReader("TempFile.txt"));
                BufferedWriter writerFile = new BufferedWriter(new FileWriter("Racing.txt"));
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

            try {
                BufferedReader readFile = new BufferedReader(new FileReader("TempFile.txt"));
                BufferedWriter writerFile = new BufferedWriter(new FileWriter("Racing.txt"));
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

            try {
                BufferedReader readFile = new BufferedReader(new FileReader("TempFile.txt"));
                BufferedWriter writerFile = new BufferedWriter(new FileWriter("Racing.txt"));
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

            try {
                BufferedReader readFile = new BufferedReader(new FileReader("TempFile.txt"));
                BufferedWriter writerFile = new BufferedWriter(new FileWriter("Racing.txt"));
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

            try {
                BufferedReader readFile = new BufferedReader(new FileReader("TempFile.txt"));
                BufferedWriter writerFile = new BufferedWriter(new FileWriter("Racing.txt"));
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

    public void deleteDriver(){
        try {
            BufferedReader readFile = new BufferedReader(new FileReader("Racing.txt"));
            BufferedWriter writerFile = new BufferedWriter(new FileWriter("TempFile.txt"));
            String line;
            while((line = readFile.readLine()) != null) {
                String name = String.format("%.20s", line);
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

        try {
            BufferedReader readFile = new BufferedReader(new FileReader("TempFile.txt"));
            BufferedWriter writerFile = new BufferedWriter(new FileWriter("Racing.txt"));
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
