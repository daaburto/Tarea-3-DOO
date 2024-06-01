package main.visual;

import java.io.File;
import javax.sound.sampled.*;
public class Musica {
    private Clip clip;
    public static Musica music = new Musica();
    public void playMusic() {
        try {
            File musicPath = new File("src/main/resources/How_much.wav");
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ButtonExpendedor() {
        try {
            File musicPath = new File("src/main/resources/ButtonSound_Exp.wav");
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ButtonPay() {
        try {
            File musicPath = new File("src/main/resources/ButtonSound_Pay.wav");
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ButtonMoneda() {
        try {
            File musicPath = new File("src/main/resources/ButtonSound_Moneda.wav");
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ButtonPush() {
        try {
            File musicPath = new File("src/main/resources/ButtonSound_Push.wav");
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}