package tcs.racer_game.car;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CarTextureRender implements CarRender {
    Car car;
    SpriteBatch batch;
    Sprite sprite;

    public CarTextureRender(Car car, SpriteBatch batch, Texture texture) {
        this.car = car;
        this.batch = batch;
        this.sprite = new Sprite(texture);
    }

    @Override
    public void render(float delta) {
        sprite.setPosition(car.getX(), car.getY());
        sprite.setRotation(car.angle().angle);
        sprite.draw(batch);
    }
}
