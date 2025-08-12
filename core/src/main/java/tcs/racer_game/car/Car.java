package tcs.racer_game.car;

import com.badlogic.gdx.math.Vector2;
import tcs.racer_game.math.Angle;

/// I don't feel there is a need to make an interface at this point
public abstract class Car {
    public final Vector2 carPosition;
    /// currently unused, angle of the car (in radians?)
    /// it might make sense to use normalized Vector2 instead (?)
    public Angle carAngle = new Angle();

    /// Some stats, that should be in car (?), because where else
    public float speed = 0;
    public float acceleration = 0;

    public Gearbox carGearbox;

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