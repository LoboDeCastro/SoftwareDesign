package at.compus02.swd.ss2022.game.factory;

import at.compus02.swd.ss2022.game.gameobjects.*;

public class PlayerFactory extends Factory{
    @Override
    public GameObject create(String object) {
        switch (object) {
            case "dog":
                return new Dog();
            default:
                return null;
        }
    }
}
