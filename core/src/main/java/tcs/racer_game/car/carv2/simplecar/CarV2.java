package tcs.racer_game.car.carv2.simplecar;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tcs.racer_game.car.Car;

public class CarV2 extends Car {
    public CarV2(SpriteBatch batch) {
        super();
        painter = new CarV2Render(this, batch);
        carInput = new CarV2Steering(this);
        /// no logic
        carLogic = delta -> {};
    }
}
