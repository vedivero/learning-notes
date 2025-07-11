package time;

import java.time.LocalDate;

public class LocalDateMain {
    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2023, 11, 22);
        System.out.println("오늘 날짜 : " + nowDate);
        System.out.println("지정 날짜 : " + ofDate);

        //계산(불변)
        //ofDate.plusDays(10); // 불변이기에 값을 복사할 변수가 필요
        ofDate = ofDate.plusDays(10);
        System.out.println("지정 날짜 : " + ofDate);
    }
}
