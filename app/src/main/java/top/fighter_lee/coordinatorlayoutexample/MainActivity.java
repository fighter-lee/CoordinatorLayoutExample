package top.fighter_lee.coordinatorlayoutexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bt_type1(View view) {
        startActivity(new Intent(this,ScrollingActivity.class));
    }

    public void bt_type2(View view) {
        startActivity(new Intent(this,ScrollingActivity2.class));
    }

    public void bt_type3(View view) {
        startActivity(new Intent(this,ScrollingActivity3.class));
    }

    public void bt_test1(View view) {
        startActivity(new Intent(this,ButtonTextActivity.class));
    }

    public void bt_test2(View view) {
        startActivity(new Intent(this,UCActivity.class));
    }

    public void bt_test3(View view) {
        startActivity(new Intent(this,ViewLearnActivity.class));
    }
}
