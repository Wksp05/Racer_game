package tcs.racer_game.board;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.carv2.CarV2;

public class SimpleBoard implements Board{

    Car playerCar;
    SpriteBatch batch;

    public SimpleBoard(SpriteBatch batch){
        playerCar = new CarV2(batch);
        this.batch = batch;
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
    }

}
