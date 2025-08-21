package tcs.racer_game.car.carv2;

import com.badlogic.gdx.math.Vector2;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.Engine;
import tcs.racer_game.math.Angle;

public class CarV2Engine implements Engine {
    Car car;

    float predictedAcceleration = 0;
    float predictedSpeed = 0;
    Vector2 predictedPosition = new Vector2(0, 0);
    Angle predictedAngle = new Angle();

    CarV2Engine(Car car){
        this.car = car;
    }

    @Override
    public void makePrediction(float delta) {
        predictedAcceleration = car.acceleration + car.carGearbox.getAccelaration(delta);
        predictedSpeed = car.speed + predictedAcceleration * delta;
        if(predictedSpeed < 0){
            predictedSpeed = 0;
            delta = car.speed / predictedAcceleration;
        }
        predictedAngle = new Angle(car.carAngle);
        predictedAngle.rotateDegrees(car.carGearbox.getTurnNormalized());
        float distance = car.speed * delta + predictedAcceleration * delta * delta / 2;
        Vector2 predictedDistance = predictedAngle.asVector2(distance);
        predictedPosition.x = car.carPosition.x + predictedDistance.x;
        predictedPosition.y = car.carPosition.y + predictedDistance.y;
        if(predictedSpeed <= 0 && predictedAcceleration < 0){
            predictedAcceleration = 0;
        }
    }

    @Override
    public float getPredictedSpeed() {
        return predictedSpeed;
    }

    @Override
    public Vector2 getPredictedPosition() {
        return new Vector2(predictedPosition);
    }

    @Override
    public Angle getPredictedAngle() {
        return new Angle(predictedAngle);
    }
}
