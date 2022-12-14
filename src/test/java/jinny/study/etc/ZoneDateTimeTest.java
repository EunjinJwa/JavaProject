package jinny.study.etc;

import jinny.study.utils.DateUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.*;
import java.util.Set;

public class ZoneDateTimeTest {

    /**
     * ZoneDateTime : LocalDateTime에서 시간대(Time Zone) 개념
     */

    @Test
    public void getZoneId() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds(); // 이용할 수 있는 모든 시간대를 얻는다.
        for(String str : availableZoneIds){
            System.out.println(str); // Asia/Aden, America/Chicago, Europe/Luxembourg, Etc/GMT+9, Asia/Seoul
        }
    }

    @Test
    public void basicTest() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);          // 2022-12-05T18:06:51.921+09:00[Asia/Seoul]
        System.out.println(now.getZone());

        ZonedDateTime utcNow = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("utcNow : " + utcNow);   // 2022-12-05T09:08:01.668Z[UTC]


        LocalDateTime loc = LocalDateTime.now();
        System.out.println(loc);
        ZonedDateTime zdt = loc.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zdt);                        // 2022-12-05T23:33:51.130+09:00[Asia/Seoul]
        System.out.println(zdt.getOffset());            // +09:00
        System.out.println(zdt.getZone());              // Asia/Seoul
        System.out.println(zdt.toOffsetDateTime());     // 2022-12-05T23:33:51.130+09:00
    }

    @Test
    public void offsetDateTime() {
        OffsetDateTime odt = OffsetDateTime.now();
        System.out.println(odt);

        String strOdt = "2022-12-05T23:28:00.000Z";
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(strOdt);
        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime.toLocalDateTime());

        LocalDateTime localDateTime = LocalDateTime.ofInstant(offsetDateTime.toInstant(), ZoneId.of("Asia/Seoul"));
        System.out.println(localDateTime);

        System.out.println(Timestamp.from(offsetDateTime.toInstant()).getTime());

        long time = DateUtil.convertOffsetDtStringToTime(strOdt);
        Assertions.assertThat(time).isEqualTo(1670282880000L);


        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(1670282880000L), ZoneId.of("UTC"));
        System.out.println(localDateTime1);
        OffsetDateTime offsetDateTime1 = localDateTime1.atOffset(ZoneOffset.UTC);
        System.out.println(offsetDateTime1);
    }

    @Test
    public void convert() {
        long timestamp = 1670282880000L;

        OffsetDateTime offsetDt = DateUtil.convertTimestampToOffsetDt(timestamp);
        Assertions.assertThat(offsetDt.toString()).isEqualTo("2022-12-05T23:28Z");

    }





}
