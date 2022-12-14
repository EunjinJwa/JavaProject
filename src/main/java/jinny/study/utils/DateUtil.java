package jinny.study.utils;

import lombok.Builder;

import java.sql.Timestamp;
import java.time.*;

public class DateUtil {


    public static long localDateTimeToLongTime(LocalDateTime ldt) {
        return Timestamp.valueOf(ldt).getTime();
    }

    public static long localDateTimeToUtcLongTime (LocalDateTime ldt) {
        ZonedDateTime zdt = ldt.atZone(ZoneOffset.UTC);
        return Timestamp.from(zdt.toInstant()).getTime();
    }

    public static LocalDateTime convertTimestampToLocalDateTimeWithZone(long systemTimeMills, ZoneId zoneId) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(systemTimeMills), zoneId);
    }

    public static long convertOffsetDtStringToTime(String strOdt) {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(strOdt);
        return Timestamp.from(offsetDateTime.toInstant()).getTime();
    }

    public static OffsetDateTime convertTimestampToOffsetDt(long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("UTC"));;
        return localDateTime.atOffset(ZoneOffset.UTC);

    }
}
