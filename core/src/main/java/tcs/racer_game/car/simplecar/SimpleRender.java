package tcs.racer_game.car.simplecar;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.CarRender;

public class SimpleRender implements CarRender {
    final Car car;
    final Texture texture;
    final SpriteBatch batch;

    public SimpleRender(Car car, SpriteBatch batch) {
        this.car = car;
        this.batch = batch;
        texture = new Texture("pixelOrangeCar.png");
    }

    @Override
    public void render(float delta) {
        batch.draw(texture, car.carPosition.x, car.carPosition.y);
    }
}
