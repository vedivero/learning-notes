package access;

public class Speaker {
    private int volume;

    Speaker(int volume) {
        this.volume = volume;
        System.out.println("현재 볼륨 : " + volume);
    }

    void volumeUp() {
        if (volume >= 100) {
            System.out.println("최대 음량입니다.");
        } else {
            volume += 10;
            System.out.println("음량을 10 증가합니다.");
        }
    }

    void volumeDown() {
        volume -= 10;
        System.out.println("volumeDown 호출");
    }

    void showVolume() {
        System.out.println("현재 볼륨 : " + volume);
    }
}
