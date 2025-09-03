package tcs.racer_game.ui;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

//it's not a record, records are not supported in java 8
public class ButtonWrapper {
    final Button button;
    final Vector2 relativePosition;

    public ButtonWrapper(Button button, Vector2 relativePosition) {
        this.button = button;
        this.relativePosition = relativePosition;
    }

    public Button button() {
        return button;
    }

    public Vector2 relativePosition() {
        return relativePosition;
    }
}