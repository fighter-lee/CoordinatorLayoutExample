package top.fighter_lee.coordinatorlayoutexample.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * @author fighter_lee
 * @date 2017/11/13
 */
public class UCTitleBehavior extends CoordinatorLayout.Behavior<TextView> {
    private static final String TAG = "UCTitleBehavior";
    private float startY;
    private int title_height;

    public UCTitleBehavior(Context context, AttributeSet set) {
        super(context, set);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        if (startY == 0) {
            startY = dependency.getY();
        }
        if (title_height == 0) {
            title_height = child.getHeight();
            Log.d(TAG, "onDependentViewChanged: "+title_height+","+child.getY());
        }
        float percent = dependency.getY() / startY;
        Log.d(TAG, "onDependentViewChanged: " + percent);
        child.setTranslationY(title_height*(percent-1));
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
