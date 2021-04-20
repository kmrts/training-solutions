package week05d05.senior;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Song> songList= new ArrayList<>();

    public Playlist(List<Song> songList) {
        this.songList = songList;
    }

    public List<Song> findByLengthGreaterThan(int mins){
        List<Song> greaters= new ArrayList<>();
        long toSec= mins* 60;
        for(Song song: songList){
            if(song.getLengthInSeconds()> toSec){
                greaters.add(song);
            }
        }
        return greaters;
    }

    @Override
    public String toString() {
        return "Playlist= " + songList;
    }
}
