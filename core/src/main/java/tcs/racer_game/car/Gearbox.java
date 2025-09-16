package tcs.racer_game.car;

public interface Gearbox {

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

    float getAcceleration(float delta);

    void updateTurnDrop(float delta);
}
