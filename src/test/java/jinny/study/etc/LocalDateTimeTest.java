package jinny.study.etc;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
        long systemTimeMills = 1670231770000L;      // 2022-12-05 09:16:10.0 KST
        LocalDateTime localDtForUTC = LocalDateTime.ofInstant(Instant.ofEpochMilli(systemTimeMills), ZoneId.of("UTC"));      // UTC 시간으로 변환
        System.out.println("localDtForUTC : " + localDtForUTC); // 2022-12-05T09:16:10

        LocalDateTime localDtForSystem = LocalDateTime.ofInstant(Instant.ofEpochMilli(systemTimeMills), TimeZone.getDefault().toZoneId());
        System.out.println("localDtForSystem : " + localDtForSystem);   // 2022-12-05T18:16:10
    }

}
