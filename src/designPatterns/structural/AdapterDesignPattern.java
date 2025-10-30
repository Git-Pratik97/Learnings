package designPatterns.structural;

//Adapter design pattern is a structural design pattern that allows
// incompatible interfaces to work together by acting as a bridge between them.

import javax.print.attribute.standard.Media;

public class AdapterDesignPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "movie.mp4");
        audioPlayer.play("vlc", "video.vlc");
        audioPlayer.play("avi", "clip.avi");    // Unsupported Format
    }
}

//Target interface that Client Expects
interface MediaPlayer{
    void play(String audio, String fileName);
}

//Existing class that can play only Mp3
class MP3Player implements MediaPlayer{
    @Override
    public void play(String audioType, String fileName){
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing Mp3 files : " + fileName);
        }else{
            System.out.println("Invalid media type: " + audioType);
        }
    }
}

//Adaptee interface (New Functionality that needs to be adapted)
interface AdvancedMediaPlayer{
    void playMP4(String fileName);
    void playVLC(String fileName);
}

//Concrete Class implementing new functionality
class MP4Player implements AdvancedMediaPlayer{

    /**
     * @param fileName
     */
    @Override
    public void playMP4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }

    /**
     * @param fileName
     */
    @Override
    public void playVLC(String fileName) {
        //Do Nothing, as this Player only supports MP4
    }
}

class VLCPlayer implements AdvancedMediaPlayer {

    /**
     * @param fileName
     */
    @Override
    public void playMP4(String fileName) {
        //Do Nothing, as this player only supports VLC
    }

    /**
     * @param fileName
     */
    @Override
    public void playVLC(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}

//Adapter class that converts AdvancedMediaPlayer to MediaPlayer
class MediaAdapter implements MediaPlayer{
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new MP4Player();
        }else if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new VLCPlayer();
        }
    }

    /**
     * @param audioType
     * @param fileName
     */
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMP4("mp4");
        }else if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVLC(fileName);
        }
    }
}

//Client code using the adapter pattern
class AudioPlayer implements MediaPlayer{
    private MediaAdapter mediaAdapter;


    /**
     * @param audioType
     * @param fileName
     */
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing Mp3 file: " + fileName);
        }else if(audioType.equalsIgnoreCase("mp4") ||
                audioType.equalsIgnoreCase("vlc")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }else {
            System.out.println("Invalid media format: " + audioType);
        }
    }
}
