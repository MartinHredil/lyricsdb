package com.example.external;

public class Lyrics {

    private String text;
    private String path;
    private String songName;


    public Lyrics(String songName, String text, String path){
        this.text = text;
        this.path = path;
        this.songName = songName;
    }

    public String getPath(){
        return path;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getSongName(){ return songName;}
}
