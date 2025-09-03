package tcs.racer_game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import tcs.racer_game.Main;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class SimpleScreen implements Screen {
    final Main game;
    final Texture texture;
    final SpriteBatch batch;
    final Viewport viewport;
    final Sprite logo;
    final Vector2 velocity;
    final Vector2 imageSize;
    final BitmapFont font;

    public SimpleScreen(Main game) {
        this.game = game;

        batch = new SpriteBatch();
        viewport = new FitViewport(800, 600);
        texture = new Texture("libgdx.png");
        logo = new Sprite(texture);
        velocity = new Vector2(80, 80);
        imageSize = new Vector2(378, 63);
        font = new BitmapFont();
        font.getData().setScale(3.0f);
    }

    @Override
    public void show() {

    }

    void move(float delta) {
        logo.translateX(velocity.x * delta);
        logo.translateY(velocity.y * delta);
        while(logo.getX() < 0 || logo.getX() + imageSize.x > viewport.getWorldWidth()) {
            if(logo.getX() < 0) {
                logo.setX(-logo.getX());
            } else {
                logo.setX((viewport.getWorldWidth() - imageSize.x) * 2 - logo.getX());
            }
            velocity.x = -velocity.x;
        }

        while(logo.getY() < 0 || logo.getY() + imageSize.y > viewport.getWorldHeight()) {
            if(logo.getY() < 0) {
                logo.setY(-logo.getY());
            } else {
                logo.setY((viewport.getWorldHeight() - imageSize.y) * 2 - logo.getY());
            }
            velocity.y = -velocity.y;
        }
    }

    @Override
    public void render(float delta) {
        move(delta);
        if(Gdx.input.isTouched()) {
            game.setScreen(new NotSoSimpleScreen(game));
            return;
        }
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        logo.draw(batch);
        font.draw(batch, "Tap anywhere to begin", 170, 150);
        //We need some better font
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
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
        batch.dispose();
        texture.dispose();
        font.dispose();
    }
}
