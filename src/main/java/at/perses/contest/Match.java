package at.perses.contest;

public class Match {


    public int matchCount = 0;
    public int firstOccurence = 0;
    public int lastOccurence = 0;

    public Match(Image image) {
        matchCount = 1;
        lastOccurence = image.timestamp;
        firstOccurence = image.timestamp;
    }
//    public Image image;
}
