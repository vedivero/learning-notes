package oop;

public class MusicPlayer {
    int volume;
    boolean isOn;

    void on() {
        isOn = true;
        System.out.println("음악 플레이어 전원 ON");
    }

    void off() {
        isOn = false;
        System.out.println("음악 플레이어 전원 OFF");
    }

    void volumeUp() {
        volume++;
        System.out.println("볼륨 증가 : " + volume);
    }
    void volumeDown() {
        volume--;
        System.out.println("볼륨 감소 : " + volume);
    }

    void showStatus() {
        System.out.print("음악 플레이어 현재 상태 : ");
        if (isOn) {
            System.out.println("전원 ON , 볼륨 : " + volume);
        } else {
            System.out.println("전원 OFF");
        }
    }

}
