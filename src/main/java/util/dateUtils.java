package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class dateUtils {
    public static String getSystemDate(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        return currentDate.format(formatter);

    }
}
