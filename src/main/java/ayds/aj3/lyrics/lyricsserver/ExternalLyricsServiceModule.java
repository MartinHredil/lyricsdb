package com.example.external.lyricsserver;

import com.example.external.ExternalLyricsService;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ExternalLyricsServiceModule {

    private static ExternalLyricsServiceModule instance;

    private final ExternalLyricsService externalLyricsService;

    private ExternalLyricsServiceModule() {
        ServerToLyricsResolver serverToLyricsResolver = new JsonToLyricsResolver();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://orion.apiseeds.com/api/music/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        LyricsAPI lyricsAPI = retrofit.create(LyricsAPI.class);
        externalLyricsService = new ExternalLyricsServiceImp(serverToLyricsResolver,lyricsAPI);
    }

    public static ExternalLyricsServiceModule getInstance() {
        if (instance == null) {
            instance = new ExternalLyricsServiceModule();
        }
        return instance;
    }

    public ExternalLyricsService getExternalLyricsService() {
        return externalLyricsService;
    }
}
