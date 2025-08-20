package tcs.racer_game.car.carv2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.CarTextureRender;

public class CarV2 extends Car {
    public CarV2(SpriteBatch batch) {
        super();
        carAngle.rotateDegrees(90);
        carRender = new CarTextureRender(this, batch, new Texture("pixelOrangeCar.png"));
        carInput = new CarV2Steering(this);
        carLogic = new CarV2Logic(this);
        carGearbox = new CarV2Gearbox();
    }
}
