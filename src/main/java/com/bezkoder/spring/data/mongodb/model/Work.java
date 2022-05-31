package com.bezkoder.spring.data.mongodb.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Job")

public class Work {
    @Id
    private String id;
    private String name;
    private String content;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date start_time;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date end_time;
    private int progress;
    private String status;
    private Team team;

    public Work(){}
    public Work(String id, String name, String content, Date start_time, Date end_time, int progress, String status, Team team){
        this.id = id; this.name = name; this.content = content;
        this.start_time = start_time;
        this.end_time = end_time;

        this.progress = progress; this.status = status;
    }
    public void setID(String id){
        this.id = id;
    }
    public String getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getContent(){
        return this.content;
    }
    public Date getStart_time(){
        return this.start_time;
    }
    public Date getEnd_time(){
        return this.end_time;
    }
    public int getProgress(){
        return this.progress;
    }
    public String getStatus(){
        return this.status;
    }
    public Team getTeam(){
        return this.team;
    }


}
