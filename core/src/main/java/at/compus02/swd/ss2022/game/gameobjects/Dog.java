package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class Dog extends Player {

    public Dog() {
        image = new Texture("dog.png");
        sprite = new Sprite(image);
    }

    public void bark() {
        try (AudioInputStream ais = AudioSystem.getAudioInputStream(new File("woof.wav"))) {
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
