package tcs.racer_game.ui;


import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import tcs.racer_game.Main;
import tcs.racer_game.board.Board;
import tcs.racer_game.physicsexperimental.PhysicsPlayground;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.carv2.CarV2;

public class StupidWithPhysicsScreen implements Screen {
    final Main game;
    final Camera camera;
    final SpriteBatch batch;
    final Viewport viewport;
    final Car car;
    final Board gameBoard;

    StupidWithPhysicsScreen(Main game){
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(720, 720, camera);
        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);
        camera.update();
        car = new CarV2(batch);
//        gameBoard = new ComplexBoard(batch, camera);
        gameBoard = new PhysicsPlayground(batch, camera);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gameBoard.input(delta);
        gameBoard.logic(delta);
        ScreenUtils.clear(Color.valueOf("00c2e0"));
        camera.position.set(gameBoard.getMainPlayer().carPosition.x, gameBoard.getMainPlayer().carPosition.y, 0);
        viewport.apply();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        gameBoard.render(delta);
        batch.end();


    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
