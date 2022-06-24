package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.gameobjects.Dog;
import at.compus02.swd.ss2022.game.observer.GameObservable;
import at.compus02.swd.ss2022.game.observer.GameObserver;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameInput extends InputAdapter implements GameObservable {

    Dog dog;
    int keycode;
    List<GameObserver> observers = new ArrayList<>();

    public int getKeycode() {
        return keycode;
    }

    public void getDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public boolean keyDown(int keycode) {

        this.keycode = keycode;
        this.notifyObservers();

        if (keycode == Input.Keys.LEFT && dog.getX() != -240) {
            dog.moveLeft();
        }
        if (keycode == Input.Keys.RIGHT && dog.getX() != 210) {
            dog.moveRight();
        }
        if (keycode == Input.Keys.UP && dog.getY() != 210) {
            dog.moveUp();
        }
        if (keycode == Input.Keys.DOWN && dog.getY() != -240) {
            dog.moveDown();
        }
        if (keycode == Input.Keys.SPACE) {
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

    @Override
    public void registerObserver(GameObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(GameObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update();
        }
    }
}
