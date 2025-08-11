package tcs.racer_game.car.simplecar;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tcs.racer_game.car.Car;

public class SimpleCar extends Car {
    public SimpleCar(SpriteBatch batch) {
        super();
        painter = new SimpleRender(this, batch);
        carInput = new SimpleSteering(this);
        /// no logic
        carLogic = delta -> {};
    }
}
