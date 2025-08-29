package tcs.racer_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Main extends Game {

    // Test - to destroy
    @Override
    public void create() {
        try {
//            this.setScreen(new MainMenuScreen());
            this.setScreen(new SimpleScreen(this));
        }catch (Exception ex){
            System.out.println(ex.toString());
        }

    }
}