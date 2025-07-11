package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(2016, 8, 16, 8, 10, 1);

        System.out.println("현재 날짜 : " + now);
        System.out.println("지정 날짜 : " + localDateTime);

        //날짜, 시간 분리
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);

        //날짜 시간 연결
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime1 = " + localDateTime1);

        //계산
        LocalDateTime localDateTime2 = localDateTime.plusDays(1000);
        System.out.println("지정 날짜시간 + 1000days = " + localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.plusYears(3);
        System.out.println("지정 날짜 + 3 year = " + localDateTime3);

        //비교
        System.out.println("현재 날짜, 시간이 지정 날짜,시간보다 이전인가? : " + now.isBefore(localDateTime));
        System.out.println("현재 날짜, 시간이 지정 날짜,시간보다 이후인가? : " + now.isAfter(localDateTime));
        System.out.println("현재 날짜, 시간이 지정 날짜,시간과 같은가? : " + now.isEqual(localDateTime));
    }
}
