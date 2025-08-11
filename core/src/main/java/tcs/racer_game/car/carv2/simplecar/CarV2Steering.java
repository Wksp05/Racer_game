package tcs.racer_game.car.carv2.simplecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.CarInput;

public class CarV2Steering implements CarInput {
    final Car car;
    final float HALF_SQRT2 = (float) Math.sqrt(2) / 2;

    public CarV2Steering(Car car) {
        this.car = car;
    }

    @Override
    public void input(float delta) {

        ///  Turn (Left and Right)
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            car.carAngle.rotateDegrees(90 * delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            car.carAngle.rotateDegrees(-90 * delta);
        }
        ///  Brake
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            car.speed = 0;
            car.acceleration = 0;
        }
        ///  Gas pedal
        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            car.acceleration += 100 * delta;
            System.out.println("Gas pressed");
        }else{
            car.acceleration = 0;
        }
    }
}
