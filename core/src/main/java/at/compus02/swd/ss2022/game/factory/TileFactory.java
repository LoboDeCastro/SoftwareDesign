package at.compus02.swd.ss2022.game.factory;

import at.compus02.swd.ss2022.game.gameobjects.*;
import com.badlogic.gdx.utils.Array;

public class TileFactory extends Factory {


    @Override
    public GameObject create(String object) {
        switch (object) {
            case "gras":
                return new Gras();
            case "water":
                return new Water();
            case "gravel":
                return new Gravel();
            case "bush":
                return new Bush();
            default:
                return null;
        }
    }


    public void setBackground(Array<GameObject> gameObjects, String tile) {
        int x = -240, y = 210, counter = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                gameObjects.add(create(tile));
                gameObjects.get(counter).setPosition(x, y);
                x += 30;
                counter++;
            }
            x = -240;
            y -= 30;
        }
    }

}
