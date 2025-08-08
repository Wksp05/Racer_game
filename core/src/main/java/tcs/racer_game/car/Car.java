package tcs.racer_game.car;

import com.badlogic.gdx.math.Vector2;

/// I don't feel there is a need to make an interface at this point
public abstract class Car {
    public final Vector2 carPosition;
    /// currently unused, angle of the car (in radians?)
    /// it might make sense to use normalized Vector2 instead (?)
    public float carAngle;
    // they cannot be final
    // (https://stackoverflow.com/questions/59809617/using-this-keyword-in-super-constructor)
    protected CarInput carInput;
    protected CarLogic carLogic;
    protected CarPainter painter;

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
        painter.draw(delta);
    }
}