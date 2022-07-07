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




        /*int keyCode = gameInput.getKeycode();

        if (keyCode == 21)
            System.out.println("Bingo moved left");
        if (keyCode == 22)
            System.out.println("Bingo moved right");
        if (keyCode == 19)
            System.out.println("Bingo moved up");
        if (keyCode == 20)
            System.out.println("Bingo moved down");
        if (keyCode == 62)
            System.out.println("Bingo barked");*/


    }
}
