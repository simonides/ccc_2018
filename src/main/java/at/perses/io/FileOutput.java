package at.perses.io;

import java.io.*;
import java.util.Optional;

/**
 * Created by Paradies on 18.04.2015.
 */
public class FileOutput implements AutoCloseable{

    BufferedWriter bufferedWriter;

    /**
     *
     * @param filepath
     * @throws FileNotFoundException
     */
    public FileOutput(String filepath) throws FileNotFoundException {
        File file = new File(filepath);
        FileOutputStream fos = new FileOutputStream(file);
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos));
    }

    /**
     *
     * @param line
     * @throws IOException
     */
    public void writeLine(String line) throws IOException {
        bufferedWriter.write(line);
        bufferedWriter.newLine();
    }

    public void write(String var) throws IOException {
        bufferedWriter.write(var);
    }
    public void newLine() throws IOException {
        bufferedWriter.newLine();
    }

    public void close() throws IOException {
        bufferedWriter.close();
    }
}
