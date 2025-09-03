package tcs.racer_game.board;

import tcs.racer_game.car.Car;

public interface Board {
    Car getMainPlayer();
    void start();
    void input(float delta);
    void logic(float delta);
    void render(float delta);
}
