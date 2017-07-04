package co.jurvis.customlistview.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jurvistan on 9/5/17.
 */

public class Song {
    private String title, artist;
    @SerializedName("album_url")
    private String albumArtURL;
    private long duration;

    public Song(String title, String artist, String albumArtURL, long duration) {
        this.title = title;
        this.artist = artist;
        this.albumArtURL = albumArtURL;
        this.duration = duration;
    }

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbumArtURL() {
        return albumArtURL;
    }

    public long getDuration() {
        return duration;
    }
}
