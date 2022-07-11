package jinny.study.utils;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @Test
    public void convertDateToTimestamp() {
        String dateString = "2022-03-26T23:00:46.256";

        LocalDateTime ldt = LocalDateTime.parse(dateString);
        System.out.println(ldt);
        long timestamp = Timestamp.valueOf(ldt).getTime();

        System.out.println("timestamp : " + timestamp);
    }

    @Test
    public void convertDateToZoneDateTime() {
        String dateString = "2022-03-26T23:00:46.256";
        LocalDateTime ldt = LocalDateTime.parse(dateString);
        System.out.println(DateUtil.localDateTimeToLongTime(ldt));
        System.out.println(DateUtil.localDateTimeToUtcLongTime(ldt));
    }
}