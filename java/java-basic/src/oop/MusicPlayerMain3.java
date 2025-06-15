package oop;

public class MusicPlayerMain3 {
    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();

        on(data);
        volumeUp(data);
        volumeUp(data);
        volumeUp(data);
        volumnDown(data);
        off(data);
    }

    static void on(MusicPlayerData data) {
        data.isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");
    }

    static void off(MusicPlayerData data) {
        data.isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }

    static void volumeUp(MusicPlayerData data) {
        data.volume++;
        System.out.println("Volume Up! 현재 볼륨 :" + data.volume);
    }

    static void volumnDown(MusicPlayerData data) {
        data.volume--;
        System.out.println("Volume Down! 현재 볼륨 :" + data.volume);
    }


}
