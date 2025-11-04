package uz.ssh.springboottesting.service.adapter;

/**
 * @author Shokhimardon
 * @since 11/4/25
 */
public class AdapterDemo {
    public static void main(String[] args) {
        AudioPlayerWithAdapter player = new AudioPlayerWithAdapter();
        player.play("mp3", "song.mp3");
        player.play("mp4", "movie.mp4");
        player.play("vlc", "video.vlc");
    }

    static class MediaAdapter implements MediaPlayer {
        AdvancedMediaPlayer advancedMusicPlayer;

        public MediaAdapter(String audioType) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMusicPlayer = new VlcPlayer();
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMusicPlayer = new Mp4Player();
            }
        }

        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMusicPlayer.playVlc(fileName);
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMusicPlayer.playMp4(fileName);
            }
        }
    }
}
