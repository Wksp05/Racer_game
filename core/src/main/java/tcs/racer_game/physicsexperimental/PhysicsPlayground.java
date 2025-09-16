package tcs.racer_game.physicsexperimental;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import tcs.racer_game.board.Board;
import tcs.racer_game.car.NotPhysicalCar;

import java.util.ArrayList;
import java.util.List;


public class PhysicsPlayground implements Board {

    NotPhysicalCar car = new NotPhysicalCar() {};
    final SpriteBatch batch;
    final Camera camera;
    final World world;
    final List<Rectangle> squareList = new ArrayList<>();

    public PhysicsPlayground(SpriteBatch batch, Camera camera) {
        this.batch = batch;
        this.camera = camera;
        this.world = new World(Vector2.Zero, true);
        Vector2 size = new Vector2(50, 50);
        squareList.add(new Rectangle(world, new Vector2(80, 70), new Vector2(80, 80)));
        for(int i=0; i<5; i++) {
            Vector2 p = new Vector2(-180, -225 + i*100);
            squareList.add(new Rectangle(world, p, size));
            p.add(50, 0);
            squareList.add(new Rectangle(world, p, size));
            p.add(0, 50);
            squareList.add(new Rectangle(world, p, size));
            p.add(-50, 0);
            squareList.add(new Rectangle(world, p, size));
            p.add(100, -50);
            squareList.add(new Rectangle(world, p, size));
            p.add(50, 0);
            squareList.add(new Rectangle(world, p, size));
            p.add(0, 50);
            squareList.add(new Rectangle(world, p, size));
            p.add(-50, 0);
            squareList.add(new Rectangle(world, p, size));
        }
        squareList.get(0).body.setLinearVelocity(-120, 0);
    }

    @Override
    public NotPhysicalCar getMainPlayer() {
        return car;
    }

    @Override
    public void start() {

    }

    @Override
    public void input(float delta) {

    }

    @Override
    public void logic(float delta) {
        world.step(delta, 6, 2); //i have no clue what these constants do
    }

    @Override
    public void render(float delta) {
        squareList.forEach(square -> square.render(batch));
    }
}

