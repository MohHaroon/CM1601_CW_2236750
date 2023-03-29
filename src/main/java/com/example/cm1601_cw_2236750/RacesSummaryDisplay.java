package com.example.cm1601_cw_2236750;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RacesSummaryDisplay {
    public String fileName;

    RacesSummaryDisplay(String fileName){
        this.fileName = fileName;
    }

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
            System.out.println(raceDetails);
            readFile.close();

            List <LocalDate> raceDates = new ArrayList<LocalDate>();
            for (String raceDetail : raceDetails) {


                String dateString = raceDetail.trim().substring(26, 37);

                LocalDate date = LocalDate.parse(dateString.trim());
                raceDates.add(date);
            }
            System.out.println(raceDates);
            dateSort(raceDates);
            System.out.println(raceDates);


            for (int count = 0; count < raceDetails.size();count++){
                for(int item = 0; item < raceDetails.size();item++){
//                    if (String.valueOf(raceDates.get(count)).contains(raceDetails.get(item).substring(26,37))){
                    if (raceDetails.get(item).contains(String.valueOf(raceDates.get(count)))){
                        System.out.println(raceDetails.get(item) +"\n\n");
                        displayRaces += raceDetails.get(item) +"\n";

                    }
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return displayRaces;
    }

    public void dateSort(List <LocalDate> dateList){
        for (int i =0; i < dateList.size();i++) {
            for (int z = i + 1; z < dateList.size(); z++) {
                LocalDate tempI = dateList.get(i);
                LocalDate tempZ = dateList.get(z);

                if (tempI.isBefore(tempZ)) {

                    LocalDate tmp = dateList.get(i);
                    dateList.set(i, dateList.get(z));
                    dateList.set(z, tmp);
                }
            }
        }
    }
}
