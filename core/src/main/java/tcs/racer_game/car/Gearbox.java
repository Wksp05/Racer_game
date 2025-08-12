package tcs.racer_game.car;

public interface Gearbox {

    ///  value is in percent (%)
    void setBrake(State state, int value);

    void setGas(State state, int value);

    void setTurn(State state, Direction direction, int value);


}
