package tcs.racer_game.math;

import com.badlogic.gdx.math.Vector2;

public class Angle {
    // I used degree, for convenient. Later it changed locally to radians.
    float angle;

    public Angle(){
        angle = 0;
    }
    public Angle(float angle){
        this.angle = angle;
    }

    public Vector2 distribute(float number){
        double x = 0, y = 0;

        // Simple question, Can it be simplified or not? (I have a filling, that yes, but I am not sure, and you are better at Math)
        if(angle == 0){
            x = 0;
            y = number;
        } else if (angle < 90) {
            x =        number / Math.sin(Math.toRadians(angle));
            y =        number / Math.cos(Math.toRadians(angle));
        } else if (angle == 90) {
            x = number;
            y = 0;
        } else if (angle < 180) {
            x =        number / Math.cos(Math.toRadians(angle - 90));
            y = (-1) * number / Math.sin(Math.toRadians(angle - 90));
        } else if (angle == 180) {
            x = 0;
            y = number * (-1);
        } else if (angle < 270) {
            x = (-1) * number / Math.sin(Math.toRadians(angle - 180));
            y = (-1) * number / Math.cos(Math.toRadians(angle - 180));
        } else if (angle == 270) {
            x = number * (-1);
            y = 0;
        } else {
            x = (-1) * number / Math.cos(Math.toRadians(angle - 270));
            y =        number / Math.sin(Math.toRadians(angle - 270));
        }
        return new Vector2((float) x,(float) y);
    }

    public void moveAngle(float change){
        if(change > 360){
            change = change%360;
        }
        if(change < -360){
            // TODO replace it with some better version, witch fix problem
            throw new IllegalArgumentException("Angle has to much value on minus");
        }
        angle = angle + change;
        if(angle >= 360){
            angle -= 360;
        }
        if(angle < 0){
            angle += 360;
        }
    }

}
