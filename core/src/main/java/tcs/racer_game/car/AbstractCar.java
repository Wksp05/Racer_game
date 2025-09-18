package tcs.racer_game.car;

import tcs.racer_game.core.AbstractEmitter;
import tcs.racer_game.core.Emitter;
import tcs.racer_game.core.Observer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCar implements Car{

    protected CarInput carInput;
    protected CarLogic carLogic;
    protected CarRender carRender;
    protected InputData carInputData;

    Map<String, Emitter> emitterMap;

    AbstractCar() {
        emitterMap = new HashMap<>();
        emitterMap.put("beforeInput", new AbstractEmitter() {});
        emitterMap.put("afterInput", new AbstractEmitter() {});
        emitterMap.put("beforeLogic", new AbstractEmitter() {});
        emitterMap.put("afterLogic", new AbstractEmitter() {});
        emitterMap.put("beforeDraw", new AbstractEmitter() {});
        emitterMap.put("afterDraw", new AbstractEmitter() {});
    }

    @Override
    public void input(float delta) {
        emitterMap.get("beforeInput").emit(delta);
        carInput.input(delta);
        emitterMap.get("afterInput").emit(delta);
    }

    @Override
    public void logic(float delta) {
        emitterMap.get("beforeLogic").emit(delta);
        carLogic.logic(delta);
        emitterMap.get("afterLogic").emit(delta);
    }

    @Override
    public void draw(float delta) {
        emitterMap.get("beforeDraw").emit(delta);
        carRender.render(delta);
        emitterMap.get("afterDraw").emit(delta);
    }

    @Override
    public InputData inputData() {
        return carInputData;
    }

    @Override
    public boolean registerForEventNoThrow(Observer observer, String event) {
        if(!emitterMap.containsKey(event))
            return false;
        emitterMap.get(event).subscribe(observer);
        return true;
    }

}
