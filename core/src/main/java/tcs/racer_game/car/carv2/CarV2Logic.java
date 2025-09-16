package tcs.racer_game.car.carv2;

import tcs.racer_game.car.NotPhysicalCar;
import tcs.racer_game.car.CarLogic;

public class CarV2Logic implements CarLogic {
    NotPhysicalCar car;

    CarV2Logic(NotPhysicalCar car){
        this.car = car;
    }

    @Override
    public void logic(float delta) {
        car.carEngine.makePrediction(delta);
        car.speed = car.carEngine.getPredictedSpeed();
        car.carPosition = car.carEngine.getPredictedPosition();
        car.carAngle.angle = car.carEngine.getPredictedAngle().angle;
        car.gearbox().updateTurnDrop(delta);
        System.out.println("Logic Done" + car.speed + " Angle: " + car.carAngle.angle);

    }
}
