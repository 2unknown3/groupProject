package com.example.harta;

public class Person {

    private String avgBpm;
    private String maxBpm;
    private String minBpm;
    private String dateBpm;

    public Person(String avgBpm, String maxBpm, String minBpm, String dateBpm){
        this.avgBpm = avgBpm;
        this.maxBpm = maxBpm;
        this.minBpm = minBpm;
        this.dateBpm = dateBpm;
    }

    public String getAvgBpm() {
        return avgBpm;
    }

    public void setAvgBpm(String avgBpm) {
        this.avgBpm = avgBpm;
    }

    public String getMaxBpm() {
        return maxBpm;
    }

    public void setMaxBpm(String maxBpm) {
        this.maxBpm = maxBpm;
    }

    public String getMinBpm() {
        return minBpm;
    }

    public void setMinBpm(String minBpm) {
        this.minBpm = minBpm;
    }

    public String getDateBpm() {
        return dateBpm;
    }

    public void setDateBpm(String dateBpm) {
        this.dateBpm = dateBpm;
    }
}
