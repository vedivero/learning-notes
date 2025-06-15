package oop;

public class MusicPlayerMain2 {
    public static void main(String[] args) {

        MusicPlayerData data = new MusicPlayerData();

        data.isOn = true;

        System.out.println("음악 플레이어를 시작합니다.");

        data.volume++;
        System.out.println("musicPlayerData.Volume Up! 현재 볼륨 :" + data.volume);

        data.volume++;
        System.out.println("musicPlayerData.Volume Up! 현재 볼륨 :" + data.volume);

        data.volume--;
        System.out.println("musicPlayerData.Volume Down! 현재 볼륨 :" + data.volume);

        System.out.print("음악 플레이어 현재 상태 : ");

        if (data.isOn) {
            System.out.println("음악 플레이어 재생 중...");
        } else {
            System.out.println("음악 플레이어 정지");
        }

        data.isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }
}
