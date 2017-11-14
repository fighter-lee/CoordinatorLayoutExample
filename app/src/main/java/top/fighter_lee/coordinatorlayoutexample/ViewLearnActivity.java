package top.fighter_lee.coordinatorlayoutexample;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;

import top.fighter_lee.coordinatorlayoutexample.utils.Utils;

/**
 * @author fighter_lee
 * @date 2017/11/13
 */
public class ViewLearnActivity extends AppCompatActivity {
    private static final String TAG = "ViewLearnActivity";
    private Button button;
    private Button button2;
    private TextView textView;
    private Context context = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlearn);
        button = findViewById(R.id.view_bt);
        button2 = findViewById(R.id.view_bt2);
        textView = findViewById(R.id.view_tv);

        final ViewTreeObserver observer = button.getViewTreeObserver();
        Log.d(TAG, "onCreate: "+(observer.isAlive()));
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.d(TAG, "onGlobalLayout: "+(observer.isAlive()));
                if (observer.isAlive()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        observer.removeOnGlobalLayoutListener(this);
                    } else {
                        observer.removeGlobalOnLayoutListener(this);
                    }

                }
                Log.d(TAG, "run: height:" + button.getHeight());
                Log.d(TAG, "run: top bt1:" + Utils.px2dp(button.getTop(),context) + ",bottom:" + Utils.px2dp(button.getBottom(),context));
                Log.d(TAG, "run: getX bt1:" + Utils.px2dp(button.getX(),context) + ",getY:" + Utils.px2dp(button.getY(),context));

                Log.d(TAG, "run: top bt2:" + Utils.px2dp(button2.getTop(),context) + ",bottom:" + Utils.px2dp(button2.getBottom(),context));
                Log.d(TAG, "run: getX bt2:" + Utils.px2dp(button2.getX(),context) + ",getY:" + Utils.px2dp(button2.getY(),context));
            }

        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


    }
}
