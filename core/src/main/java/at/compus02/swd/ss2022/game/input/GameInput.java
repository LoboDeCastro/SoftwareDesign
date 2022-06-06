package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.gameobjects.Dog;
import at.compus02.swd.ss2022.game.observer.Observer;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameInput extends InputAdapter {

    Dog dog;

    public void getDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public boolean keyDown(int keycode) {
        //System.out.println(keycode);
        new Observer().observe(keycode);
        if(keycode == Input.Keys.LEFT) {
            // Move left
            dog.setPosition(dog.getX() - 30, dog.getY());
        }
        if(keycode == Input.Keys.RIGHT) {
            // Move Right
            dog.setPosition(dog.getX() + 30, dog.getY());
        }
        if(keycode == Input.Keys.UP) {
            // Move Up
            dog.setPosition(dog.getX(), dog.getY() + 30);
        }
        if(keycode == Input.Keys.DOWN) {
            // Move Down
            dog.setPosition(dog.getX(), dog.getY() - 30);
        }
        if(keycode == Input.Keys.SPACE) {
                dog.bark();
        }
        return true;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int key;
            while ((key = br.read()) != -1) {
                this.keyDown(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
