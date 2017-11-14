package top.fighter_lee.coordinatorlayoutexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author fighter_lee
 * @date 2017/11/7
 */
public class ButtonTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttontext);

        findViewById(R.id.bt).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setX(motionEvent.getRawX()-view.getWidth()/2);
                view.setY(motionEvent.getRawY()-view.getHeight()/2);
                return false;
            }
        });
    }
}
