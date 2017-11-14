package top.fighter_lee.coordinatorlayoutexample.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author fighter_lee
 * @date 2017/11/14
 */
public class CenterViewBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

    private float startY;
    private float childStartY;

    public CenterViewBehavior(Context context, AttributeSet set) {
        super(context, set);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        if (startY == 0) {
            startY = dependency.getY();
        }
        if (childStartY == 0) {
            childStartY = child.getY();
        }
        float percent = dependency.getY() / startY;
        child.setY(childStartY * percent);
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
