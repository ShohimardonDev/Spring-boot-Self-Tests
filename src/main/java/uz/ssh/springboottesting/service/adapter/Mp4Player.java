package uz.ssh.springboottesting.service.adapter;

/**
 * @author Shokhimardon
 * @since 11/4/25
 */
public class Mp4Player implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
    } // not supported

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}
