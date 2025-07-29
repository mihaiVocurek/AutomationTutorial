package loggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private static Logger logger = LogManager.getLogger();

    //start test
    public static void startTest(String testName){
        logger.info("===== Execution started: " + testName + " =====");
    }

    //info step
    public static void infoLog(String message){
        logger.info(message);
    }

    //error step
    public static void errorLog(String message){
        logger.error(message);
    }

    //finish test
    public static void finishTest(String testName){
        logger.info("===== Execution finished: " + testName + " =====");
    }
}
