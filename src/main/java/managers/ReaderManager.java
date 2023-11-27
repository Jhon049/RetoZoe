package managers;

import dataProviders.ConfigFileReader;

public class ReaderManager {
    private static ReaderManager readerManager = new ReaderManager();
    private static ConfigFileReader configFileReader;

    private ReaderManager() {
    }

    public static ReaderManager getInstance( ) {
        return readerManager;
    }

    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }
}