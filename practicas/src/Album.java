import java.lang.reflect.Array;
import java.util.ArrayList;

public class Album {
    private String Name;
    private String Artist;
    private String Year;
    private ArrayList<Song> songs = new ArrayList();

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public class Song {
        String Title;
        String duration;
        String singer;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getSinger() {
            return singer;
        }

        public void setSinger(String singer) {
            this.singer = singer;
        }

        public String getAuthor() {
            return Author;
        }

        public void setAuthor(String author) {
            Author = author;
        }

        public int getReplays() {
            return replays;
        }

        public void setReplays(int replays) {
            this.replays = replays;
        }

        String Author;
        int replays;
    }
}
