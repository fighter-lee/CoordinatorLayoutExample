package top.fighter_lee.coordinatorlayoutexample;

import android.app.Application;
import android.content.Context;

/**
 * @author fighter_lee
 * @date 2017/11/15
 */
public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
