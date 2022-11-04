package com.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrainMerger tm = new TrainMerger();
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); 
            while (sc.hasNextLine()) {
               String [] input = sc.nextLine().split(" ");
               tm.processIndividualArrivals(input);
            }
            sc.close();
            tm.processMergedDeparture();
        } catch (IOException e) {
        }
        
    }
}