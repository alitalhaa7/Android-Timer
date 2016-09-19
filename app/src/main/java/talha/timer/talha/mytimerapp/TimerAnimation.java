package talha.timer.talha.mytimerapp;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Talha on 2016-07-12.
 */
public class TimerAnimation extends Animation {

    private TimerDraw circle;

    private float oldAngle;
    private float newAngle;
    public TimerAnimation(TimerDraw circle, int newAngle) {
        this.oldAngle = circle.getAngle();
        this.newAngle = newAngle;
        this.circle = circle;

    }
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        float angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);
        circle.setAngle(angle);
        circle.requestLayout();
        circle.invalidate();

    }




}
