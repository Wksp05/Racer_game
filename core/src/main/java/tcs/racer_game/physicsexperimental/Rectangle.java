package tcs.racer_game.physicsexperimental;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

class Rectangle {
    final Body body;

    final Texture squareTexture;
    final Sprite squareSprite;

    Rectangle(World world, Vector2 position, Vector2 dimensions) {
        body = createBody(world, position, dimensions);
        squareTexture = createSquareTexture((int) dimensions.x, (int) dimensions.y);
        squareSprite = new Sprite(squareTexture);
        squareSprite.setPosition(body.getPosition().x, body.getPosition().y);
    }

    void render(SpriteBatch batch) {
        squareSprite.setPosition(body.getPosition().x, body.getPosition().y);
        squareSprite.setRotation(body.getAngle());
        squareSprite.draw(batch);
    }

    private Body createBody(World world, Vector2 position, Vector2 dimensions) {
        // Tworzenie ciała kwadratu
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position); // Pozycja w metrach

        Body squareBody = world.createBody(bodyDef);

        // Tworzenie kształtu kwadratu
        PolygonShape squareShape = new PolygonShape();
        squareShape.setAsBox(dimensions.x / 2, dimensions.y / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = squareShape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.5f;
        squareBody.createFixture(fixtureDef);

        squareShape.dispose();
        return squareBody;
    }

    private Texture createSquareTexture(int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(0.8f, 0.8f, 0.8f, 1);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }
}
