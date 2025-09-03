package tcs.racer_game.car;

import com.badlogic.gdx.math.Vector2;
import tcs.racer_game.math.Angle;

/// I don't feel there is a need to make an interface at this point
public abstract class Car {
    public Vector2 carPosition;
    public Angle carAngle = new Angle();

    /// Some stats, that should be in car (?), because where else
    public float speed = 0;
    public float acceleration = 0;

    public Gearbox carGearbox;
    public Engine carEngine;

    // they cannot be final
    // (https://stackoverflow.com/questions/59809617/using-this-keyword-in-super-constructor)
    protected CarInput carInput;
    protected CarLogic carLogic;
    protected CarRender carRender;

    protected Car() {
        carPosition = new Vector2();
    }

    public void input(float delta) {
        carInput.input(delta);
    }

    public void logic(float delta) {
        carLogic.logic(delta);
    }

    public void draw(float delta) {
        carRender.render(delta);
    }
}