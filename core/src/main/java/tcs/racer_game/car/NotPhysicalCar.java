package tcs.racer_game.car;

import com.badlogic.gdx.math.Vector2;
import tcs.racer_game.math.Angle;

/// I don't feel there is a need to make an interface at this point
public abstract class NotPhysicalCar extends AbstractCar {
    public Vector2 carPosition;
    public Angle carAngle = new Angle();

    /// Some stats, that should be in car (?), because where else
    public float speed = 0;
    public float acceleration = 0;

    public Engine carEngine;

    protected NotPhysicalCar() {
        carPosition = new Vector2();
    }

    @Override
    public float speed() {
        return speed;
    }

    @Override
    public Vector2 position() {
        return carPosition;
    }

    @Override
    public float acceleration() {
        return acceleration;
    }

    @Override
    public Angle angle() {
        return carAngle;
    }
}