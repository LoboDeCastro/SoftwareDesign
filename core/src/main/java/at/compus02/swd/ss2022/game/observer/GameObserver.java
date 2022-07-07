package at.compus02.swd.ss2022.game.observer;

@FunctionalInterface
public interface GameObserver {
    void update(float x, float y);
}
