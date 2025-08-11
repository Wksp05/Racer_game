package tcs.racer_game.car.carv2.simplecar;

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
        car.speed = car.speed + car.acceleration * delta;
        Vector2 change = car.carAngle.asVector2(car.speed * delta);
        car.carPosition.x += change.x;
        car.carPosition.y += change.y;
        System.out.println("Logic Done" + car.speed);
    }
}
