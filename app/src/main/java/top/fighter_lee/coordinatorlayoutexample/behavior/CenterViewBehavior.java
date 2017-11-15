package top.fighter_lee.coordinatorlayoutexample.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import top.fighter_lee.coordinatorlayoutexample.App;
import top.fighter_lee.coordinatorlayoutexample.utils.Utils;

/**
 * @author fighter_lee
 * @date 2017/11/14
 */
public class CenterViewBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
    private static final String TAG = "CenterViewBehavior";
    private float startY;
    private float childStartY;
    private float childStartX;
    private float dinstance;

    public CenterViewBehavior(Context context, AttributeSet set) {
        super(context, set);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        Log.d(TAG, "onDependentViewChanged: "+dependency.toString());
        if (startY == 0) {
            startY = dependency.getY();
            dinstance = startY - Utils.dp2px(50, App.context);
        }
        if (childStartY == 0) {
            childStartY = child.getY();
            childStartX = child.getX();
        }
//        Log.d(TAG, "onDependentViewChanged: "+dependency.getY() + ","+startY);
        float move = dependency.getY() - startY;
        float percent = Math.abs(move) / dinstance;
        child.setX(childStartX * (1-percent));
        child.setScaleX(0.5F*(1F+(1-percent)));
        child.setScaleY(0.5F*(1F+(1-percent)));
        Log.d(TAG, "onDependentViewChanged: " + percent);
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
