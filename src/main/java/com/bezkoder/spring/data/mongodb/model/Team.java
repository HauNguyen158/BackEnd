package com.bezkoder.spring.data.mongodb.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Team")

public class Team {
    private String id;
    private String name;
    private String leader;
    private List<String> member;

    public Team(String id, String name, String leader, List<String> member){
        this.id = id; this.name = name; this.leader = leader;
        this.member = member;
    }
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getLeader(){
        return this.leader;
    }
    public List<String> getMember(){
        return this.member;
    }
}
