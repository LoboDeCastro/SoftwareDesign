package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.behavior.RightLeftBehavior;
import at.compus02.swd.ss2022.game.behavior.UpDownBehavior;
import at.compus02.swd.ss2022.game.factory.PlayerFactory;
import at.compus02.swd.ss2022.game.factory.TileFactory;
import at.compus02.swd.ss2022.game.gameobjects.Dog;
import at.compus02.swd.ss2022.game.gameobjects.Flea;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Water;
import at.compus02.swd.ss2022.game.input.GameInput;
import at.compus02.swd.ss2022.game.observer.PositionObserver;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;



/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private SpriteBatch batch;

	private ExtendViewport viewport = new ExtendViewport(480.0f, 480.0f, 480.0f, 480.0f);
	private GameInput gameInput = new GameInput();

	private Array<GameObject> gameObjects = new Array<>();

	private final float updatesPerSecond = 4; // original value == 60
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	private BitmapFont font;



	@Override
	public void create() {
		batch = new SpriteBatch();
		TileFactory tileFactory = new TileFactory();
		PlayerFactory playerFactory = new PlayerFactory();

		tileFactory.setBackground(gameObjects, "gras");
		for (int i = 0; i < 16; i++) {
			tileFactory.drawOneElement(gameObjects, new Water(), 3, i);
		}

		Dog bingo = new Dog();
		PositionObserver dogObserver = new PositionObserver();

		gameInput.takeGameObjects(gameObjects);
		gameObjects.add(bingo);
		gameInput.takeDog(bingo);
		gameInput.registerObserver(dogObserver);
		gameInput.run();

		Flea flea1 = new Flea();
		playerFactory.drawOneElement(gameObjects, flea1, 5, 7);
		flea1.setBehavior(new UpDownBehavior(dogObserver));
		gameInput.takeFlea(flea1);

		Flea flea2 = new Flea();
		playerFactory.drawOneElement(gameObjects, flea2, 10, 10);
		flea2.setBehavior(new RightLeftBehavior(dogObserver));
		gameInput.takeFlea(flea2);

		font = new BitmapFont();
		font.setColor(Color.WHITE);
		Gdx.input.setInputProcessor(this.gameInput);
	}

	private void act(float delta) {
		for(GameObject gameObject : gameObjects) {
			gameObject.act(delta);
		}
	}

	private void draw() {
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();
		for(GameObject gameObject : gameObjects) {
			gameObject.draw(batch);
		}
		font.draw(batch, "points: " + gameInput.getPoints(), -220, -220);
		batch.end();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();
		deltaAccumulator += delta;
		while(deltaAccumulator > logicFrameTime) {
			deltaAccumulator -= logicFrameTime;
			act(logicFrameTime);
		}
		draw();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void resize(int width, int height){
		viewport.update(width,height);
	}
}