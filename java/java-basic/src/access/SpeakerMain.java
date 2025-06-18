package access;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(90);

        speaker.volumeUp();
        speaker.showVolume();

        speaker.volumeUp();
        speaker.showVolume();

        System.out.println("volume필드 직접 접근하도록 수정");
        // speaker.volume = 200;
        speaker.showVolume();
    }
}