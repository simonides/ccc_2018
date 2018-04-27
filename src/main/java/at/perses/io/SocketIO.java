package at.perses.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Optional;

/**
 * Created by Paradies on 18.04.2015.
 */
public class SocketIO {
    private static final Logger logger = LogManager.getLogger(SocketIO.class.getName());

    private String host;
    private int port;

    private Socket connection;
    private DataOutputStream writer;
    private BufferedReader reader;

    public SocketIO(){
        this.host = "localhost";
        this.port = 7000;
    }

    public void connect() throws IOException {
        logger.info("Connecting to " + host + " on port " + port + "...");


            connection = new Socket(host, port);
            logger.info("Connected to " + connection.getRemoteSocketAddress());

            OutputStream outToServer = connection.getOutputStream();
            writer = new DataOutputStream(outToServer);

            InputStream inFromServer = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader( inFromServer ));
    }


    /**
     *
     * @return
     * @throws IOException
     */
    public String readLine() throws IOException {
        String line = reader.readLine();
        logger.trace(line);
        return line;
    }


    /**
     *
     * @param line
     * @throws IOException
     */
    public void writeLine(String line) throws IOException {
//        logger.debug(line);
        writer.writeBytes(line + "\n");
    }

    public void write(String str) throws IOException {
        writer.writeBytes(str);
    }
    public void newLine() throws IOException {
        writer.writeBytes("\n");
    }
}
