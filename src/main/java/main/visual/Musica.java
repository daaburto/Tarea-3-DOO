package main.visual;
import java.io.File;
import javax.sound.sampled.*;

/**
 * La clase Musica añade métodos para reproducir varios efectos de sonido y música de fondo
 * @author Daniel Aburto
 */
public class Musica {
    /**
     * Clip de audio que puede ser reproducido, pausado o detenido.
     */
    private Clip clip;

    /**
     * Singleton de la clase Musica
     */
    public static Musica music = new Musica();

    /**
     * Reproduce musica en bucle.
     */
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

    /**
     * Reproduce un sonido al presionar los productos en el expendedor
     */
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

    /**
     * Reproduce un sonido al presionar el botón PAY
     */
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

    /**
     * Reproduce un sonido al presionar las monedas
     */
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

    /**
     * Reproduce un sonido al presionar el botón PUSH
     */
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