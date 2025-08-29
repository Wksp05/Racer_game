package tcs.racer_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.stream.Stream;

public class MainMenuScreen implements Screen {

    final private Stage stage;
    final private Skin skin;
    final private java.util.List<Button> buttonList = new ArrayList<>();
    MainMenuScreen() {
        skin = new Skin(Gdx.files.internal("ui/simpleButton.json"));
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        for(int i=0; i<2; i++) {
            buttonList.add(new Button(skin));
        }

        int offset = 0;
        for (Button button : buttonList) {
            button.setHeight(75);
            button.setWidth(300);

            button.setPosition(Gdx.graphics.getWidth() / 2 - button.getWidth() / 2,
                    Gdx.graphics.getHeight() / 2 - button.getHeight() / 2 - offset);

            offset += 85;
            stage.addActor(button);
        }

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        stage.getViewport().apply();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        int offset = 0;
        for (Button button : buttonList) {
            button.setPosition(Gdx.graphics.getWidth() / 2 - button.getWidth() / 2,
                    Gdx.graphics.getHeight() / 2 - button.getHeight() / 2 - offset);
            offset += 85;
        }
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
