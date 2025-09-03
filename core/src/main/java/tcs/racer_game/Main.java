package tcs.racer_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import tcs.racer_game.ui.MainMenuScreen;
import tcs.racer_game.ui.SimpleScreen;

public class Main extends Game {

    // Test - to destroy
    @Override
    public void create() {
        try {
            this.setScreen(new MainMenuScreen(this));
//            this.setScreen(new SimpleScreen(this));
        }catch (Exception ex){
            System.out.println(ex.toString());
        }

    }
}