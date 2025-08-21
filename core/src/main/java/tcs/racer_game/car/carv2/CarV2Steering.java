package tcs.racer_game.car.carv2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.CarInput;
import tcs.racer_game.car.Direction;
import tcs.racer_game.car.State;

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
//            car.carAngle.rotateDegrees(90 * delta);
            car.carGearbox.setTurn(State.ON, Direction.left, 90 * delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
//            car.carAngle.rotateDegrees(-90 * delta);
            car.carGearbox.setTurn(State.ON, Direction.right, 90 * delta);
        }
        ///  Brake
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
//            car.speed = 0;
//            car.acceleration = 0;
            car.carGearbox.setBrake(State.ON, 100);
        }else{
            car.carGearbox.setBrake(State.OFF, 0);
        }
        ///  Gas pedal
        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
//            car.acceleration += 100 * delta;
            System.out.println("Gas pressed");
            car.carGearbox.setGas(State.ON, 50);
        }else{
            car.acceleration = 0;
            car.carGearbox.setGas(State.OFF, 0);
        }

        /// Gear change
        if(Gdx.input.isKeyPressed(Input.Keys.R)){
            car.carGearbox.setGear(Direction.front);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.F)){
            car.carGearbox.setGear(Direction.back);
        }

    }
}
