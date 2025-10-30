package designPatterns.structural;

public class BridgeDesignPattern {
    public static void main(String[] args) {
        MediaPlayerImplementation audioImpl = new AudioPlayerImplementation();
        MediaPlayerImplementation videoImpl = new VideoPlayerImplementation();

        MediaPlayerBridge basicAudioPlayer = new BasicPlayer(audioImpl);
        MediaPlayerBridge advancedVideoPlayer = new AdvancedPlayer(videoImpl);

        basicAudioPlayer.play("song.mp3");
        advancedVideoPlayer.play("movie.mp4");
    }
}

//Implementor Interface
interface MediaPlayerImplementation {
    void playFile(String fileName);
}

//concrete Implementor 1
class AudioPlayerImplementation implements MediaPlayerImplementation {
    public void playFile(String fileName) {
        System.out.println("Playing audio file: " + fileName);
    }
}

//concrete Implementor 2
class VideoPlayerImplementation implements MediaPlayerImplementation {
    public void playFile(String fileName){
        System.out.println("Playing video file: " + fileName);
    }
}

//Abstraction
abstract class MediaPlayerBridge {
    protected MediaPlayerImplementation implementation;

    public MediaPlayerBridge(MediaPlayerImplementation implementation){
        this.implementation = implementation;
    }

    public abstract void play(String fileName);
}

//Refined Abstraction
class BasicPlayer extends MediaPlayerBridge{
    public BasicPlayer(MediaPlayerImplementation implementation){
        super(implementation);
    }

    public void play(String fileName){
        System.out.println("Basic Player Delegating...");
        implementation.playFile(fileName);
    }
}

class AdvancedPlayer extends MediaPlayerBridge {
    public AdvancedPlayer(MediaPlayerImplementation implementation){
        super(implementation);
    }

    public void play(String fileName){
        System.out.println("Advanced Player with equalizer and Subtitles...");
        implementation.playFile(fileName);
    }
}
