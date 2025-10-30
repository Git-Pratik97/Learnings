package designPatterns.creational.singleton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Logger {
    private static Logger logger;

    private Logger() {}

    public static synchronized Logger getLogger(){
        if(logger == null){
            logger = new Logger();
        }
        return logger;
    }

    public void log(String type, String message){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(String.format("%s [%s] : %s", timeStamp, type, message));
    }

    public void info(String message){
        log("INFO", message);
    }

    public void error(String message){
        log("ERROR", message);
    }

    public void warn(String message){
        log("WARN", message);
    }
}


class TestingLogger{
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an info message");
        String infoMessage = sc.nextLine();
        logger.info(infoMessage);

        System.out.println("Enter an Error message");
        String errorMessage = sc.nextLine();
        logger.error(errorMessage);

        System.out.println("Enter a warning message");
        String warningMessage = sc.nextLine();
        logger.warn(warningMessage);


        sc.close();
    }
}
