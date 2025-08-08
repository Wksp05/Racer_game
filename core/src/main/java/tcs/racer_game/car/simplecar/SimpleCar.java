package tcs.racer_game.car.simplecar;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.CarLogic;

public class SimpleCar extends Car {
    public SimpleCar(SpriteBatch batch) {
        super();
        painter = new SimplePainter(this, batch);
        carInput = new SimpleSteering(this);
        /// no logic
        carLogic = delta -> {};
    }
}
