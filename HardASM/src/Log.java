import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * <h3></h3>
 * Created by root on 2016/11/9.
 */
public class Log {

    public static void setLevel(String level){
        Level.toLevel(level);
    }

    public static void d(Class clazz, String message){
        getLogger(clazz).debug(message);
    }

    public static void i(Class clazz, String message){
        getLogger(clazz).info(message);
    }

    public static void w(Class clazz, String message){
        getLogger(clazz).warn(message);
    }

    public static void e(Class clazz, String message){
        getLogger(clazz).error(message);
    }

    public static void f(Class clazz, String message){
        getLogger(clazz).fatal(message);
    }

    private static Logger getLogger(Class clazz){
        BasicConfigurator.configure();
        return Logger.getLogger(clazz);
    }
}
