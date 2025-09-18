package tcs.racer_game.car.carv2;

import tcs.racer_game.car.Car;
import tcs.racer_game.car.Direction;
import tcs.racer_game.car.InputData;
import tcs.racer_game.car.State;
import tcs.racer_game.core.Observer;

import static java.lang.Float.min;

public class CarV2InputData implements InputData {
    Car car;

    State stateBrake = State.OFF;
    float valueBrake = 0;
    State stateGas = State.OFF;
    float valueGas = 0;
    State stateTurn = State.OFF;
    Direction turnDirection = Direction.none;
    float valueTurn = 0;
    Direction changeGear = Direction.none;
    Observer turnUpdater;

    CarV2InputData(Car car){
        this.car = car;
        turnUpdater = this::updateTurnDrop;
        car.registerForEventNoThrow(turnUpdater, "beforeLogic");
    }

    @Override
    public void setBrake(State state, float value) {
        if(value < 0 || value > 100){
            throw new IllegalArgumentException("value less then zero in InputData");
        }
        stateBrake = state;
        if(state == State.ON){
            valueBrake = value;
        }else{
            valueBrake = 0;
        }
    }

    @Override
    public void setGas(State state, float value) {
        if(value < 0 || value > 100){
            throw new IllegalArgumentException("value less then zero in InputData");
        }
        stateGas = state;
        if(state == State.ON){
            valueGas = value;
        }else{
            valueGas = 0;
        }
    }

    @Override
    public void setTurn(State state, Direction direction, float value) {
        if(value < 0){
            throw new IllegalArgumentException("value lesser then zero in InputData");
        }
        if(state == State.OFF){
            turnDirection = Direction.none;
            valueTurn = 0;
            stateTurn = State.OFF;
            return;
        }else{
            stateTurn = State.ON;
        }
        if(direction == Direction.left){
            if(turnDirection == Direction.left){
                valueTurn += value;
                if(valueTurn < 0){
                    valueTurn *= -1;
                    turnDirection = Direction.right;
                }
            } else if (turnDirection == Direction.right) {
                valueTurn -= value;
                if(valueTurn < 0){
                    valueTurn *= -1;
                    turnDirection = Direction.left;
                }
            }else{
                turnDirection = Direction.left;
                valueTurn = value;
            }
        }
        if(direction == Direction.right){
            if(turnDirection == Direction.right){
                valueTurn += value;
                if(valueTurn < 0){
                    valueTurn *= -1;
                    turnDirection = Direction.left;
                }
            } else if (turnDirection == Direction.left) {
                valueTurn -= value;
                if(valueTurn < 0){
                    valueTurn *= -1;
                    turnDirection = Direction.right;
                }
            }else{
                turnDirection = Direction.right;
                valueTurn = value;
            }
        }
        valueTurn = min(valueTurn, CarV2Const.MAX_TURN);
    }

    @Override
    public void setGear(Direction direction) {
        if(direction == Direction.left || direction == Direction.right){
            throw new IllegalArgumentException("setGear in gearbox get wrong direction change");
        }
        changeGear = direction;
    }

    @Override
    public boolean brakePressed() {
        return stateBrake == State.ON;
    }

    @Override
    public boolean gasPressed() {
        return stateGas == State.ON;
    }

    @Override
    public boolean turnPressed() {
        return stateTurn == State.ON;
    }

    @Override
    public boolean gearPressed() {
        return changeGear != Direction.none;
    }

    @Override
    public float getBrake() {
        return valueBrake;
    }

    @Override
    public float getGas() {
        return valueGas;
    }

    @Override
    public float getTurnNormalized() {
        if(turnDirection == Direction.left){
            return valueTurn;
        } else if (turnDirection == Direction.right) {
            return valueTurn * -1;
        }
        return 0;
    }

    void updateTurnDrop(float delta) {
        valueTurn = valueTurn - CarV2Const.TURN_DROP * delta;
        if(valueTurn <= 0){
            valueTurn = 0;
            turnDirection = Direction.none;

        }
    }
}
