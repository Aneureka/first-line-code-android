package cn.aneureka.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class HelloWorldActivity extends AppCompatActivity {

    // use "logt" and [Tab] to create this line
    private static final String TAG = "HelloWorldActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // use "logd" to create this line
        Log.d(TAG, "onCreate: invoked");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
    }
}
