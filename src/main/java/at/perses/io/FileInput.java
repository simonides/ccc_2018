package at.perses.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * Created by Paradies on 18.04.2015.
 */
public class FileInput implements AutoCloseable {
    private static final Logger logger = LogManager.getLogger(FileInput.class.getName());

    BufferedReader bufferedReader;

    /**
     * @param filePath
     * @throws FileNotFoundException
     */
    public FileInput(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        this.bufferedReader = new BufferedReader(new InputStreamReader(fis));
    }

    /**
     * @return
     * @throws IOException
     */
    public String readLine() {


        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.trace(line);
        return line;
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
