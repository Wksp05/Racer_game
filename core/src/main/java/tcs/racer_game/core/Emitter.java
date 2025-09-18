package tcs.racer_game.core;

public interface Emitter {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void emit(float delta);
}
