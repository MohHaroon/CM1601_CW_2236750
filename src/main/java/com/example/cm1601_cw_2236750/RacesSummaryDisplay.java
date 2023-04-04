package com.example.cm1601_cw_2236750;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Used to display the races summary
public class RacesSummaryDisplay {
    private final String fileName; // file name

    // Constructor to initialize the fileName
    RacesSummaryDisplay(String fileName){
        this.fileName = fileName;
    }

    // sorts the races and returns a string to append to the text area
    public String raceSort(){

        String displayRaces = "";
        String racesData ="";
        List <String> raceDetails = new ArrayList<String>();
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = readFile.readLine()) != null){
                if (!line.isEmpty()){
                    racesData = racesData + line;
                    racesData += "\n";
                } else {
                    raceDetails.add(racesData);
                    racesData = "";
                }
            }

            readFile.close();

            List <LocalDate> raceDates = new ArrayList<LocalDate>();
            for (String raceDetail : raceDetails) {

                String dateString = raceDetail.trim().substring(26, 37);

                LocalDate date = LocalDate.parse(dateString.trim());
                raceDates.add(date);
            }

            dateSort(raceDates); // sorts the dates list

            // Data passed to the displayRaces variable in the order of the date
            for (int count = 0; count < raceDetails.size();count++){
                for(int item = 0; item < raceDetails.size();item++){
                    if (raceDetails.get(item).contains(String.valueOf(raceDates.get(count)))){
                        String raceDetailsU =
                                raceDetails.get(item).replaceAll(" {2,}(?!\\n)", "   |   ") + "\n";
                        displayRaces += raceDetailsU +"\n";

                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return displayRaces;
    }

    // uses bubble sort to sort the dates
    public void dateSort(List <LocalDate> dateList){
        for (int i =0; i < dateList.size();i++) {
            for (int z = i + 1; z < dateList.size(); z++) {
                LocalDate tempI = dateList.get(i);
                LocalDate tempZ = dateList.get(z);

                // if the tempI is before than tempZ, then Z and I is swapped in the list
                if (tempI.isBefore(tempZ)) {

                    LocalDate tmp = dateList.get(i);
                    dateList.set(i, dateList.get(z));
                    dateList.set(z, tmp);
                }
            }
        }
    }
}
