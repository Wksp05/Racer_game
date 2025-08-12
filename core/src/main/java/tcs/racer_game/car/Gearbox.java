package tcs.racer_game.car;

public interface Gearbox {

    ///  value is in percent (%)
    void setBrake(State state, float value);

    void setGas(State state, float value);

    void setTurn(State state, Direction direction, float value);


}
