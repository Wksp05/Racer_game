package tcs.racer_game.car;

import com.badlogic.gdx.math.Vector2;
import tcs.racer_game.math.Angle;

public interface Engine {
    void makePrediction(float delta);
    float getPredictedSpeed();
    Vector2 getPredictedPosition();
    Angle getPredictedAngle();
}
