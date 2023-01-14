package jinny.study.etc;

import jinny.study.utils.DateUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

public class LocalDateTimeTest {

    @Test
    public void basicTest() {
        // 구역(Zone) 구분이 없는 지역날짜로 now()나 of()로 생성한다.
        LocalDateTime nowDateTime = LocalDateTime.now();        // 2022-12-05T18:01:54.471

        System.out.println("현재시각 : " + nowDateTime); // 2022-12-05T18:01:54.471
        System.out.println("현재시각 + 1시간 : " + nowDateTime.plusHours(1L)); // 2022-12-05T19:03:13.547
        System.out.println("현재시각에서 시간만 3 : " + nowDateTime.withHour(3)); // 2022-12-05T03:03:13.547
    }


    @Test
    public void convertTimetampToLocalDateTimeWithZone() {
        long systemTimeMills = 1670245200000L;      // 2022-12-05 13:00 UTC

        LocalDateTime localDtForUTC = DateUtil.convertTimestampToLocalDateTimeWithZone(systemTimeMills, ZoneId.of("UTC"));
        Assertions.assertThat(localDtForUTC.toString()).isEqualTo("2022-12-05T13:00");

        LocalDateTime localDtForSystemTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(systemTimeMills), TimeZone.getDefault().toZoneId());
        Assertions.assertThat(localDtForSystemTime.toString()).isEqualTo("2022-12-05T22:00");
    }

    @Test
    public void localDateTimeNowTest() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getSecond());
        System.out.println(now.getSecond()%3==0);

        System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());
    }

}
