package at.compus02.swd.ss2022.game.observer;


public class PositionObserver implements GameObserver {
    float x;
    float y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public void update(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
