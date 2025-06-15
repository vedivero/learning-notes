package oop;

public class MusicPlayerMain1 {
    public static void main(String[] args) {
        int volume = 0;
        boolean isOn = false;

        isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");

        volume++;
        System.out.println("Volume Up! 현재 볼륨 :" + volume);

        volume++;
        System.out.println("Volume Up! 현재 볼륨 :" + volume);

        volume--;
        System.out.println("Volume Down! 현재 볼륨 :" + volume);

        System.out.print("음악 플레이어 현재 상태 : ");

        if (isOn) {
            System.out.println("음악 플레이어 재생 중...");
        } else {
            System.out.println("음악 플레이어 정지");
        }

        isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }
}
