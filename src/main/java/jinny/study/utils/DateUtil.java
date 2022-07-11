package jinny.study.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateUtil {


    public static long localDateTimeToLongTime(LocalDateTime ldt) {
        return Timestamp.valueOf(ldt).getTime();
    }

    public static long localDateTimeToUtcLongTime (LocalDateTime ldt) {
        ZonedDateTime zdt = ldt.atZone(ZoneOffset.UTC);
        return Timestamp.from(zdt.toInstant()).getTime();
    }

}
