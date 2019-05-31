package ayds.aj3.lyrics.lyricsserver;

import ayds.aj3.lyrics.ExternalLyricsService;

import ayds.aj3.lyrics.Lyrics;
import ayds.aj3.lyrics.LyricsSong;
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
