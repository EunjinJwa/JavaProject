package jinny.study.etc;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZoneDateTimeTest {

    /**
     * ZoneDateTime : LocalDateTime에서 시간대(Time Zone) 개념
     */

    @Test
    public void getZoneId() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds(); // 이용할 수 있는 모든 시간대를 얻는다.
        for(String str : availableZoneIds){
            System.out.println(str); // Asia/Aden, America/Chicago, Europe/Luxembourg ...
        }
    }

    @Test
    public void basicTest() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);          // 2022-12-05T18:06:51.921+09:00[Asia/Seoul]

        ZonedDateTime utcNow = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("utcNow : " + utcNow);   // 2022-12-05T09:08:01.668Z[UTC]
    }


}
