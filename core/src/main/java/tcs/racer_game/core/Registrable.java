package tcs.racer_game.core;

public interface Registrable {
    boolean registerForEventNoThrow(Observer observer, String event);
    default void registerForEvent(Observer observer, String event) {
        if(!registerForEventNoThrow(observer, event)) {
            throw new RuntimeException();
        }
    }
}
