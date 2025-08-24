package tcs.racer_game.car.carv2;

import com.badlogic.gdx.math.Vector2;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.CarLogic;

public class CarV2Logic implements CarLogic {
    Car car;

    CarV2Logic(Car car){
        this.car = car;
    }

    @Override
    public void logic(float delta) {
        car.carEngine.makePrediction(delta);
        car.speed = car.carEngine.getPredictedSpeed();
        car.carPosition = car.carEngine.getPredictedPosition();
        car.carAngle.angle = car.carEngine.getPredictedAngle().angle;
        System.out.println("Logic Done" + car.speed + " Angle: " + car.carAngle.angle);

    }
}
