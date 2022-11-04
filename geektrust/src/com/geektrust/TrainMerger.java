package com.geektrust;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


class TrainMerger{
    HashMap<String,Integer> stationsAfterHYB = new HashMap<>();
    List<Station> trainADepartures = new ArrayList<>();
    List<Station> trainBDepartures = new ArrayList<>();
    TrainMerger() {
        this.stationsAfterHYB.put("HYB",0);
        this.stationsAfterHYB.put("NGP",400);
        this.stationsAfterHYB.put("ITJ",700);
        this.stationsAfterHYB.put("BPL",800);
        this.stationsAfterHYB.put("AGA",2500);
        this.stationsAfterHYB.put("NDL",2700);
        this.stationsAfterHYB.put("PTA",3800);
        this.stationsAfterHYB.put("NJP",4200);
        this.stationsAfterHYB.put("GHY",4700);
    }  

    public void processIndividualArrivals(String [] input){
        StringBuffer sb = new StringBuffer("ARRIVAL " + input[0] + " ENGINE");
        List<Station> result = new ArrayList<>();
        for(int i=2;i<input.length;i++){
            if(this.stationsAfterHYB.containsKey(input[i].trim())){
                sb.append(" "+input[i]);
                Station currentStation = new Station(input[i].trim(), this.stationsAfterHYB.get(input[i].trim()));
                result.add(currentStation);    
            }
        }
        String currentTrainArrivals = sb.toString();
        System.out.println(currentTrainArrivals.trim());
        if(input[0].equals("TRAIN_A"))
            this.trainADepartures = result;
        else
            this.trainBDepartures = result;
    }

    public void processMergedDeparture(){
        List<Station> mergedDepartures = new ArrayList<>();
        mergedDepartures.addAll(this.trainADepartures);
        mergedDepartures.addAll(this.trainBDepartures);
        Collections.sort(mergedDepartures);
        StringBuffer sb = new StringBuffer("DEPARTURE TRAIN_AB ENGINE ENGINE");
        if(mergedDepartures.size()!=0){
            for (Station mergedDeparture : mergedDepartures) {
                if (mergedDeparture.distance!= 0) {
                    sb.append(" "+mergedDeparture.name);
                }
            }
        }
        else{
            sb.append(" JOURNEY_ENDED");
        }
        String result = sb.toString().replace("HYB","");
        System.out.println(result.trim());
    }
}