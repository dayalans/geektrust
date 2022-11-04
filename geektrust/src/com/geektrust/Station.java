package com.geektrust;


class Station implements Comparable<Station>{
    String name;
    Integer distance;
    Station(String name, Integer distance){
        this.name = name;
        this.distance = distance;
    }
    public String getName() {
        return name;
    }
    public Integer getDistance() {
        return distance;
    }
    @Override
    public int compareTo(Station s) {
        return s.getDistance().compareTo(getDistance());
    }
}