package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Player implements GameObject, Movable {
    protected Texture image;
    protected Sprite sprite;


    @Override
    public void act(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    @Override
    public void moveUp() {
        if (this.getY() <= 180)
        this.setPosition(this.getX(), this.getY() + 30);
    }

    @Override
    public void moveDown() {
        if (this.getY() >= -210)
            this.setPosition(this.getX(), this.getY() - 30);
    }

    @Override
    public void moveRight() {
        if (this.getX() <= 180)
            this.setPosition(this.getX() + 30, this.getY());
    }

    @Override
    public void moveLeft() {
        if (this.getX() >= -210)
            this.setPosition(this.getX() - 30, this.getY());
    }
}
