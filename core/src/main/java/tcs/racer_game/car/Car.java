package tcs.racer_game.car;

import com.badlogic.gdx.math.Vector2;
import tcs.racer_game.core.Observer;
import tcs.racer_game.core.Registrable;
import tcs.racer_game.math.Angle;

public interface Car extends Registrable {
    void input(float delta);
    void logic(float delta);
    void draw(float delta);
    float speed();
    float acceleration();
    InputData inputData();
    Vector2 position();
    default float getX() {
        return position().x;
    }
    default float getY() {
        return position().y;
    }
    Angle angle();
}
