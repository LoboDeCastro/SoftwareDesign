package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Player implements GameObject, Movable {
    protected Texture image;
    protected Sprite sprite;
    private float xCoordinate;
    private float yCoordinate;


    @Override
    public void act(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
        xCoordinate = x;
        yCoordinate = y;
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public float getX() {
        return xCoordinate;
    }

    public float getY() {
        return yCoordinate;
    }

    @Override
    public void moveUp() { this.setPosition(this.getX(), this.getY() + 30);}

    @Override
    public void moveDown() {
        this.setPosition(this.getX(), this.getY() - 30);
    }

    @Override
    public void moveRight() {
        this.setPosition(this.getX() + 30, this.getY());
    }

    @Override
    public void moveLeft() {
        this.setPosition(this.getX() - 30, this.getY());
    }
}
