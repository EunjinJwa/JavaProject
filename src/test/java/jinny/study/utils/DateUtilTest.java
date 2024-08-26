package jinny.study.utils;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    @Test
    public void zoneDateStringTest() {
        String dateString = "2022-03-26T23:00:46.256Z";

        ZonedDateTime parse = ZonedDateTime.parse(dateString);
        Timestamp.from(parse.toInstant());
        System.out.println(parse);
        System.out.println(parse.toString());
        System.out.println(parse.toLocalDateTime());
        System.out.println(parse.toLocalDateTime());
    }
}