package jinny.study.etc;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

class DateTestTest {

    @Test
    public void timeZoneTest() {

        String dateTime = "";


        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("LocalDataTime : " + ldt);

        ZonedDateTime zdt = ldt.atZone(ZoneOffset.UTC);
        System.out.println("ZonedDateTime : " + zdt);


        Timestamp from = Timestamp.from(zdt.toInstant());
        System.out.println(from);

    }


}