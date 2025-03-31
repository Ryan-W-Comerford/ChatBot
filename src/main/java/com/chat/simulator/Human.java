package com.chat.simulator;
import java.util.*;

class Human implements User {
    private String name;
    public List<String> humanHistory = new ArrayList<>();

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String sendChat(String msg){
        System.out.println("Human: " + msg);
        humanHistory.add(msg);
        return msg;
    }
}