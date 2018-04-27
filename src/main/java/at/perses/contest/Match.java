package at.perses.contest;

import java.util.ArrayList;
import java.util.List;

public class Match {


    public int matchCount = 0;
    public int firstOccurence = 0;
    public int lastOccurence = 0;
//    public List<Integer> matchTimestamps = new ArrayList<>();
    public int timeDiff = 0;

    public Match(Image image) {
        matchCount = 1;
        lastOccurence = image.timestamp;
        firstOccurence = image.timestamp;
//        matchTimestamps.add(image.timestamp);
    }
}
