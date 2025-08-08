package tcs.racer_game.car.simplecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.CarInput;

public class SimpleSteering implements CarInput {
    final Car car;
    final float HALF_SQRT2 = (float) Math.sqrt(2) / 2;

    public SimpleSteering(Car car) {
        this.car = car;
    }

    @Override
    public void input(float delta) {
        float dx = 0;
        float dy = 0;
        float speed = 250;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            dx -= speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            dx += speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            dy -= speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            dy += speed;
        }
        if(dx != 0 && dy != 0) {
            dx *= HALF_SQRT2;
            dy *= HALF_SQRT2;
        }
        car.carPosition.add(dx * delta, dy * delta);

    }
}
