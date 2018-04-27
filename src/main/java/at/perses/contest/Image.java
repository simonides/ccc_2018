package at.perses.contest;

import at.perses.io.FileInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Image {


    public int timestamp;
    public int rowCount;
    public int colCount;


//    public boolean hasAsteroid = false;

    public List<List<Integer>> pixels;


    public Image clip() {
        Image image = clipRows().clipCols();
        return image;
    }

    public boolean hasAsteroid(){
        return ((rowCount > 0) && (colCount > 0));
    }


    public boolean compareMono(Image other) {
        if (rowCount != other.rowCount) {
            return false;
        }
        if (colCount != other.colCount) {
            return false;
        }

        for (int y = 0; y < rowCount; y++) {
            for (int x = 0; x < colCount; x++) {
                if(pixels.get(y).get(x) == 0 && other.pixels.get(y).get(x) == 0){
                    continue;
                }
                if(pixels.get(y).get(x) == 0 || other.pixels.get(y).get(x) == 0){
                    return false;
                }
            }
        }
        return true;
    }

    //
//    public int getNumRowsWithAsteroids() {
//        int rows = 0;
//        for (int y = 0; y < rowCount; y++) {
//            if (rowHasAsteroid(y)) {
//                ++rows;
//            }
//        }
//        return rows;
//    }
//
//    public int getNumColsWithAsteroids() {
//        int cols = 0;
//        for (int x = 0; x < colCount; x++) {
//            if (colHasAsteroid(x)) {
//                ++cols;
//            }
//        }
//        return cols;
//    }
//
    public boolean colHasAsteroid(int x) {
        for (int y = 0; y < rowCount; y++) {
            if (pixels.get(y).get(x) > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean rowHasAsteroid(int y) {
        for (int x = 0; x < colCount; x++) {
            if (pixels.get(y).get(x) > 0) {
                return true;
            }
        }
        return false;
    }


    private Image clipRows() {
        Image img = new Image(this);
        img.pixels = new ArrayList<>();


        img.rowCount = 0;
        for (int y = 0; y < rowCount; y++) {
            if (rowHasAsteroid(y)) {
                img.pixels.add(pixels.get(y));
                img.rowCount++;
            }
        }
        return img;
    }

    private Image clipCols() {
        Image img = new Image(this);
        img.pixels = new ArrayList<>();

        img.colCount = 0;
        for (int y = 0; y < rowCount; y++) {
            img.colCount = 0;
            List<Integer> row = new ArrayList<>();

            for (int x = 0; x < colCount; x++) {
                if (colHasAsteroid(x)) {
                    row.add(pixels.get(y).get(x));
                    img.colCount++;
                }
            }
            img.pixels.add(row);
        }
        return img;
    }

    private Image(Image img) {
        rowCount = img.rowCount;
        colCount = img.colCount;
        timestamp = img.timestamp;

    }

    public Image(FileInput input) {


        String firstLine = input.readLine();
        String[] strings = firstLine.split(" ");
        timestamp = Integer.parseInt(strings[0]);
        rowCount = Integer.parseInt(strings[1]);
        colCount = Integer.parseInt(strings[2]);

        pixels = new ArrayList<>();

        for (int y = 0; y < rowCount; y++) {
            String pixelRow = input.readLine();

            List<Integer> pixels_ = Arrays.stream(pixelRow.split(" ")).map(Integer::parseInt).collect(
                    Collectors.toList()
            );
            pixels.add(pixels_);


//            for (int x = 0; x < pixels_.size(); x++) {
//                if (pixels_.get(x) > 0) {
//                    hasAsteroid = true;
//                }
//            }
//            for (int x = 0; x < pixels_.size(); x++) {
//                pixels[y][x] = pixels_.get(x);
//            }
        }
//        System.out.println("asdf");
    }


}
