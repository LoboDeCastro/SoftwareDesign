package at.compus02.swd.ss2022.game.factory;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.utils.Array;

public abstract class Factory {

    public abstract GameObject create(String object);

    public int calculatePosition(int coordinate) {
        return -240 + 30 * coordinate;
    }

    public void drawOneElement(Array<GameObject> gameObjects, GameObject object,  int x, int y) {
        gameObjects.add(object);
        gameObjects.get(gameObjects.size - 1).setPosition(calculatePosition(x), calculatePosition(y));
    }
}
