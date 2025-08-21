package tcs.racer_game.math;

import com.badlogic.gdx.math.Vector2;

public class Angle {
    /// angle in degrees
    public float angle;

    public Angle(){
        angle = 0;
    }

    public Angle(float angle){
        this.angle = bound360(angle);
    }

    public Angle(Angle oldAngle){
        angle = oldAngle.angle;
    }

    public Vector2 asVector2(){
        double angleRadians = Math.toRadians(angle);
        return new Vector2((float) Math.cos(angleRadians),
                (float) Math.sin(angleRadians));
    }

    public Vector2 asVector2(float number){
        return asVector2().scl(number);
    }

    public void rotateDegrees(float change){
        angle = angle + change;
        angle = bound360(angle);
    }

    /// returns angle in range 0 inclusive to 360 exclusive
    private float bound360(float value) {
        return  ((value % 360) + 360) % 360;
    }
}
