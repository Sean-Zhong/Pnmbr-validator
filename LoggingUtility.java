import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingUtility {
    private static final Logger logger = Logger.getLogger(LoggingUtility.class.getName());
    private static FileHandler fileHandler;

    public static void initializeLogger() {
        try {
            fileHandler = new FileHandler("log.xml");
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error occurred while adding FileHandler", e);
        }
    }

    public static Logger getLogger() {
        return logger;
    }

    public static FileHandler getFileHandler() {
        return fileHandler;
    }
}