package tcs.racer_game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import tcs.racer_game.Main;

import java.util.ArrayList;

public class MainMenuScreen implements Screen {

    final private Main game;
    final private Stage stage;
    final private Skin skin;
    final private java.util.List<ButtonWrapper> buttonList = new ArrayList<>();

    private void addButton(ClickListener listener) {
        final float buttonHeight = 75;
        final float buttonWidth = 300;
        final float buttonPadding = 10;
        Button button = new Button(skin);
        button.setHeight(buttonHeight);
        button.setWidth(buttonWidth);
        button.addListener(listener);
        buttonList.add(new ButtonWrapper(button
                , new Vector2(-buttonWidth / 2, -buttonList.size() * (buttonHeight + buttonPadding))));
    }

    public MainMenuScreen(Main game) {
        this.game = game;

        skin = new Skin(Gdx.files.internal("ui/simpleButton.json"));
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        addButton(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new NotSoSimpleScreen(game));
            }
        });

        addButton(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new StupidWithPhysicsScreen(game));
            }
        });

        for (ButtonWrapper buttonWrapper : buttonList) {
            Button button = buttonWrapper.button();
            Vector2 relativePosition = buttonWrapper.relativePosition();

            button.setPosition((float) Gdx.graphics.getWidth() / 2 + relativePosition.x
                    , (float) Gdx.graphics.getHeight() / 2 + relativePosition.y);

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
        for (ButtonWrapper buttonWrapper : buttonList) {
            Button button = buttonWrapper.button();
            Vector2 relativePosition = buttonWrapper.relativePosition();
            button.setPosition((float) Gdx.graphics.getWidth() / 2 + relativePosition.x
                    , (float) Gdx.graphics.getHeight() / 2 + relativePosition.y);
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
