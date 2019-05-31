package ayds.aj3.lyrics;

import ayds.aj3.lyrics.lyricsserver.ExternalLyricsServiceModule;

public class ExternalLyricsModule {

    private static ExternalLyricsModule instance;

    private ExternalLyricsModule() {}

    public static ExternalLyricsModule getInstance() {
        if (instance == null) {
            instance = new ExternalLyricsModule();
        }
        return instance;
    }

    public ExternalLyricsService getExternalLyricsService() {
        return ExternalLyricsServiceModule.getInstance().getExternalLyricsService();
    }
}
