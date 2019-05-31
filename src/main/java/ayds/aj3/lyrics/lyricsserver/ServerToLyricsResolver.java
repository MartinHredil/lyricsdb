package ayds.aj3.lyrics.lyricsserver;

import ayds.aj3.lyrics.Lyrics;

public interface ServerToLyricsResolver {

    Lyrics getLyricsFromExternalData(String serviceData) throws Exception;
}
