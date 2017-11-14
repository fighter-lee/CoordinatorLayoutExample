package top.fighter_lee.coordinatorlayoutexample;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author fighter_lee
 * @date 2017/11/13
 */
public class ViewLearnActivity extends AppCompatActivity {
    private static final String TAG = "ViewLearnActivity";
    private Button button;
    private Button button2;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlearn);
        button = findViewById(R.id.view_bt);
        button2 = findViewById(R.id.view_bt2);
        textView = findViewById(R.id.view_tv);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: height:"+button.getHeight());
                Log.d(TAG, "run: top bt1:"+button.getTop()+",bottom:"+button.getBottom());
                Log.d(TAG, "run: getX bt1:"+button.getX()+",getY:"+button.getY());

                Log.d(TAG, "run: top bt2:"+button2.getTop()+",bottom:"+button2.getBottom());
                Log.d(TAG, "run: getX bt2:"+button2.getX()+",getY:"+button2.getY());
            }
        },2000);

    }
}
