package top.fighter_lee.coordinatorlayoutexample.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author fighter_lee
 * @date 2017/11/7
 */
public class TextviewBehavior extends CoordinatorLayout.Behavior<TextView> {

    public TextviewBehavior (Context context, AttributeSet set) {
        super(context,set);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Button;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        child.setX(dependency.getX()+200);
        child.setY(dependency.getY()+200);
        child.setText(dependency.getX()+","+dependency.getY());
        return true;
    }
}
