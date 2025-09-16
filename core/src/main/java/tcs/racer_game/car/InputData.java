package tcs.racer_game.car;

public interface InputData {

    ///  value is in percent (%)
    void setBrake(State state, float value);

    void setGas(State state, float value);

    void setTurn(State state, Direction direction, float value);

    void setGear(Direction direction);

    boolean brakePressed();

    boolean gasPressed();

    boolean turnPressed();

    boolean gearPressed();

    float getBrake();

    float getGas();

    float getTurnNormalized();

    //TODO: get rid of this
    float getAcceleration(float delta);

    //TODO: get rid of this (or just rename)
    void updateTurnDrop(float delta);
}
