package com.kodilla.exception.index;

import java.util.ArrayList;
import java.util.List;

public class VideoCollector {
    public List<String> getCollection() {
        ArrayList<String> videos = new ArrayList<>();
        videos.add("Extra Movie 1");
        videos.add("Extra Movie 2");
        videos.add("Extra Movie 3");
        return videos;
    }
}
