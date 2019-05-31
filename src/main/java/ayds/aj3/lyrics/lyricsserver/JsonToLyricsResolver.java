package com.example.external.lyricsserver;

import com.example.external.Lyrics;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


class JsonToLyricsResolver implements ServerToLyricsResolver {
    private final Gson gson = new Gson();

    public Lyrics getLyricsFromExternalData(String serviceData) throws Exception {
        try{
            JsonObject jobj = gson.fromJson(serviceData, JsonObject.class);
            JsonObject result = jobj.get("result").getAsJsonObject();
            JsonObject track = result.get("track").getAsJsonObject();
            JsonObject artist = result.get("artist").getAsJsonObject();

            JsonElement textExtract = track.get("text");
            JsonElement nameExtract = track.get("name");
            JsonElement artistExtract = artist.get("name");

            String text =textExtract.getAsString();
            String artistName = artistExtract.getAsString();
            String songName = nameExtract.getAsString();
            String path = "https://source.unsplash.com/random/300x300/?" + artistName.replace(" ", "%20") +",music";

            return new Lyrics(songName,text,path);
        } catch (Exception e) {
            throw new Exception("No results");
        }
    }
}
