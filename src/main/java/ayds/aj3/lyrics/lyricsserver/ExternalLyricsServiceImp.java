package com.example.external.lyricsserver;

import com.example.external.ExternalLyricsService;

import com.example.external.Lyrics;
import com.example.external.LyricsSong;
import retrofit2.Response;

class ExternalLyricsServiceImp implements ExternalLyricsService {

    private LyricsAPI lyricsAPI;
    private ServerToLyricsResolver serverToLyricsResolver;


    ExternalLyricsServiceImp(ServerToLyricsResolver serverToLyricsResolver,LyricsAPI lyricsAPI){
        this.serverToLyricsResolver=serverToLyricsResolver;
        this.lyricsAPI=lyricsAPI;
    }

    public Lyrics getLyrics(LyricsSong song) throws Exception {
        Response<String> callResponse = getLyricsFromService(song);
        return serverToLyricsResolver.getLyricsFromExternalData(callResponse.body());
    }

    private Response<String> getLyricsFromService(LyricsSong song) throws Exception{
        return lyricsAPI.getLyrics(song.getArtistName(), song.getSongName()).execute();
    }
}
