package tcs.racer_game.board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.carv2.CarV2;

public class ComplexBoard implements Board{

    final Car playerCar;
    final SpriteBatch batch;
    final World world;
    final Camera camera;
    public Body body;
    Texture squareTexture;
    Sprite squareSprite;

    public ComplexBoard(SpriteBatch batch, Camera camera){
        playerCar = new CarV2(batch);
        this.batch = batch;
        this.camera = camera;
        world = new World(Vector2.Zero, true);
        createSquare();
        squareTexture = createSquareTexture(100, 100);
        squareSprite = new Sprite(squareTexture);
    }

    private void createSquare() {
        // Tworzenie ciała kwadratu
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(Gdx.graphics.getWidth() / 2 / 10f, Gdx.graphics.getHeight() / 2 / 100f); // Pozycja w metrach

        Body squareBody = world.createBody(bodyDef);

        // Tworzenie kształtu kwadratu
        PolygonShape squareShape = new PolygonShape();
        squareShape.setAsBox(50 / 100f, 50 / 100f); // Rozmiar w metrach

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = squareShape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.5f;
        squareBody.createFixture(fixtureDef);

        squareShape.dispose();
    }


    private Texture createSquareTexture(int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(1, 0, 0, 1); // Ustaw kolor (czerwony)
        pixmap.fill(); // Wypełnij kwadrat kolorem
        Texture texture = new Texture(pixmap);
        pixmap.dispose(); // Zwolnij pamięć
        return texture;
    }

    @Override
    public Car getMainPlayer(){
        return playerCar;
    }

    @Override
    public void start(){

    }

    @Override
    public void input(float delta){
        playerCar.input(delta);
    }

    @Override
    public void logic(float delta){
        playerCar.logic(delta);
    }

    @Override
    public void render(float delta){
        playerCar.draw(delta);

        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
        squareSprite.draw(batch);
    }

}
