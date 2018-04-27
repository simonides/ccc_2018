package at.perses.contest;

import at.perses.io.FileInput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Image {


    public int timestamp;
    public int rowCount;
    public int colCount;

    public boolean hasAsteroid = false;

    public int pixels[][];

    public Image(FileInput input) {


        String firstLine = input.readLine();
        String[] strings = firstLine.split(" ");
        timestamp = Integer.parseInt(strings[0]);
        rowCount = Integer.parseInt(strings[1]);
        colCount = Integer.parseInt(strings[2]);

        pixels = new int[colCount][rowCount];

        for (int y = 0; y < rowCount; y++) {
            String pixelRow = input.readLine();

            List<Integer> pixels_ = Arrays.stream(pixelRow.split(" ")).map(Integer::parseInt).collect(
                    Collectors.toList()
            );

            for (int x = 0; x < pixels_.size(); x++) {
                if (pixels_.get(x) > 0){
                    hasAsteroid = true;
                }
            }
//            for (int x = 0; x < pixels_.size(); x++) {
//                pixels[x][y] = pixels_.get(x);
//            }
        }
        System.out.println("asdf");
    }


}
