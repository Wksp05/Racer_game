package tcs.racer_game.core;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEmitter implements Emitter {

    final protected List<Observer> observerList;

    public AbstractEmitter() {
        observerList = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void emit(float delta) {
        observerList.forEach(observer -> observer.handle(delta));
    }
}
