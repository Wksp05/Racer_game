package tcs.racer_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.*;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.Direction;
import tcs.racer_game.car.carv2.CarV2;

public class NotSoSimpleScreen implements Screen {
    final Main game;
    final SpriteBatch batch;
    final Viewport viewport;
    final Texture texture;
    final Sprite logo;
    final Camera camera;
    final Car car;

    NotSoSimpleScreen(Main game) {
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(720, 720, camera);
        texture = new Texture("libgdx.png");
        logo = new Sprite(texture);
        logo.setSize(720, 720);
        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);
        camera.update();
        car = new CarV2(batch);
//        car = new SimpleCar(batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        car.input(delta);
        car.logic(delta);
        ScreenUtils.clear(Color.BLUE);
        viewport.apply();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        logo.draw(batch);
        car.draw(delta);
        batch.end();

        camera.position.set(car.carPosition.x, car.carPosition.y, 0);

    }

    @Override
    public void resize(int width, int height) {
        // Online tutorials failed to provide better solution to center ExtendViewport
        // Feel free to refactor it
        viewport.update(width, height);

        /// It appiers, if we centered camera on car, this is unnecesery,
        /*
        float xPos = -((float) (viewport.getScreenWidth() - viewport.getScreenHeight()) / 2
                * viewport.getWorldWidth() / viewport.getScreenWidth());
        float yPos = xPos > 0 ? -xPos : 0;
        xPos = xPos > 0 ? 0 : xPos;
        camera.position.set(viewport.getWorldWidth() / 2 + xPos, viewport.getWorldHeight() / 2 + yPos, 0); // Ustawienie kamery na środek
        camera.update();
        */
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
