package jinny.study.etc;

import com.google.gson.Gson;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import lombok.Builder;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.IntStream;

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

    @Test
    public void dateFormatTest() {
        long timestamp = System.currentTimeMillis();
        LocalDateTime day = Instant.ofEpochMilli(timestamp).atZone(ZoneId.of("UTC")).toLocalDateTime();
        int mm = Integer.valueOf(day.format(DateTimeFormatter.ofPattern("mm")));
        String mmStr = mm >= 30 ? "30" : "00";

        String result = day.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:"+mmStr));

        System.out.println(result);
    }

    @Test
    public void testDateList() {
        List<EloDailyRatingModel> ratingsFrom = new ArrayList<>();
        HashMap minutes = new HashMap();
        minutes.put(0, "00");
        minutes.put(1, "30");

        LocalDateTimeUtil localDateTimeUtil = new LocalDateTimeUtil();
        IntStream.range(0, 10)
                .forEach(i -> {
                    IntStream.range(0, 2).forEach(
                            m -> ratingsFrom.add(EloDailyRatingModel.fromDay(localDateTimeUtil.getLocalDateTimeWithMinusHours(i)
                                    .format(DateTimeFormatter.ofPattern(localDateTimeUtil.PATTERN + minutes.get(m)))))
                    );
                });
        Gson gson = new Gson();
        System.out.println(gson.toJson(ratingsFrom));
    }

    public static class EloDailyRatingModel {

        private String day;
        private Integer highest;
        private Integer end;

        public static EloDailyRatingModel fromDay(String day) {
            return EloDailyRatingModel.builder()
                    .day(day)
                    .build();
        }

        @Builder
        private EloDailyRatingModel(String day, Integer highest, Integer end) {
            this.day = day;
            this.highest = highest;
            this.end = end;
        }


    }

    public class LocalDateTimeUtil {

        public static final String PATTERN = "yyyy-MM-dd HH:";

        public String getLocalDateNowString () {
            return LocalDate.now(ZoneId.of("UTC")).format(DateTimeFormatter.ofPattern(PATTERN));
        }

        public LocalDate getLocalDateNow () {
            return LocalDate.now(ZoneId.of("UTC"));
        }

        public LocalDateTime getLocalDateTimeWithMinusHours (long hours) {
            return LocalDateTime.now(ZoneId.of("UTC")).minusHours(hours);
        }

    }
}
