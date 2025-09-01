package tcs.racer_game.board;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tcs.racer_game.car.Car;
import tcs.racer_game.car.carv2.CarV2;

///  Make interface Board (?)
public class GameBoard {

    Car playerCar;
    SpriteBatch batch;

    public GameBoard(SpriteBatch batch){
        playerCar = new CarV2(batch);
        this.batch = batch;
    }


    public Car getMainPlayer(){
        return playerCar;
    }

    public void start(){

    }

    public void input(float delta){
        playerCar.input(delta);
    }

    public void logic(float delta){
        playerCar.logic(delta);
    }

    public void render(float delta){
        playerCar.draw(delta);
    }

}
