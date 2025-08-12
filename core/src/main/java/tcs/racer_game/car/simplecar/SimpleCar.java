package tcs.racer_game.car.simplecar;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.CarTextureRender;

public class SimpleCar extends Car {
    public SimpleCar(SpriteBatch batch) {
        super();
        carRender = new CarTextureRender(this, batch, new Texture("pixelOrangeCar.png"));
        carInput = new SimpleSteering(this);
        /// no logic
        carLogic = delta -> {};
    }
}
