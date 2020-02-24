import org.apache.commons.lang3.time.DateFormatUtils;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author hgh
 * @since 2020-02-17 15:08
 */
public class DateTest {
    public static void main(String[] args) {
        System.out.println(DateFormatUtils.format(new Date(), "yyyyMMddHHmm"));
        System.out.println(getTimeStamp());
    }

    /**
     * 用yyyymmddHHMM格式的时间值。
     */
    public static String getTimeStamp() {
        DateFormatUtils.format(new Date(), "yyyymmddHHMM");
        String year = String.valueOf(LocalDateTime.now().getYear());
        String month = String.valueOf(LocalDateTime.now().getMonth().getValue());
        if (month.length() == 1) {
            month = "0" + month;
        }
        String day = String.valueOf(LocalDateTime.now().getDayOfMonth());
        if (day.length() == 1) {
            day = "0" + day;
        }
        String hour = String.valueOf(LocalDateTime.now().getHour());
        if (hour.length() == 1) {
            hour = "0" + hour;
        }
        String minute = String.valueOf(LocalDateTime.now().getMinute());
        if (minute.length() == 1) {
            minute = "0" + minute;
        }
        return year + month + day + hour + minute;
    }
}
