package tcs.racer_game.car.carv2.simplecar;

import tcs.racer_game.car.Direction;
import tcs.racer_game.car.Gearbox;
import tcs.racer_game.car.State;

public class CarV2Gearbox implements Gearbox {

    State stateBrake = State.OFF;
    int valueBrake = 0;
    State stateGas = State.OFF;
    int valueGas = 0;
    State stateTurn = State.OFF;
    Direction turnDirection = Direction.none;
    int valueTurn = 0;


    @Override
    public void setBrake(State state, int value) {
        if(value < 0 || value > 100){
            throw new IllegalArgumentException("value lesser then zero in Gearbox");
        }
        stateBrake = state;
        if(state == State.ON){
            valueBrake = value;
        }else{
            valueBrake = 0;
        }
    }

    @Override
    public void setGas(State state, int value) {
        if(value < 0 || value > 100){
            throw new IllegalArgumentException("value lesser then zero in Gearbox");
        }
        stateGas = state;
        if(state == State.ON){
            valueGas = value;
        }else{
            valueGas = 0;
        }
    }

    @Override
    public void setTurn(State state, Direction direction, int value) {
        if(value < 0){
            throw new IllegalArgumentException("value lesser then zero in Gearbox");
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
                valueTurn = value;
            }
        }


    }
}
