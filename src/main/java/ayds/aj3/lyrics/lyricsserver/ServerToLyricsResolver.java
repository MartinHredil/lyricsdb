package com.example.external.lyricsserver;

import com.example.external.Lyrics;

public interface ServerToLyricsResolver {

    Lyrics getLyricsFromExternalData(String serviceData) throws Exception;
}
