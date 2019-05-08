package com.srslycpp.moviecatalogservice.models;

public class Movie {

    private String name;
    private String desc;

    public Movie() {
    }

    public Movie(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
