package uz.ssh.springboottesting.service.adapter;

/**
 * @author Shokhimardon
 * @since 11/4/25
 */
public class AudioPlayerWithAdapter implements MediaPlayer {
    AdapterDemo.MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new AdapterDemo.MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media: " + audioType);
        }
    }
}
