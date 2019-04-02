package com.diagens.two;

/**
 * @author ZNJ
 * @create 2019-03-15 11:18
 */
public enum  OzWitch {
    WEST("Miss Gulch,aka the Wicked Witch of the West"),
    NORTH("Glinda,the Good Witch of the NORTH"),
    EAST("Wicked Witch of the East,wearer of the Ruby Slippers,crushed by Dorothy's house"),
    SOUTH("Good by inference,but missing");

    private String description;

    private OzWitch(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String [] args){
        for(OzWitch ozWitch:OzWitch.values()){
            System.out.println(ozWitch+":"+ozWitch.getDescription());
        }
    }
}
