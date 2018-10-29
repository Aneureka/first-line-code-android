package cn.aneureka.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button toastButton = findViewById(R.id.button_toast);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "I am your first activity!", Toast.LENGTH_SHORT).show();
            }
        });

        Button destroyButton = findViewById(R.id.button_destroy);
        destroyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button toSecondButton = findViewById(R.id.button_to_second);
        toSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSecondIntent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(toSecondIntent);
            }
        });

        Button toSecond2Button = findViewById(R.id.button_to_second_2);
        toSecond2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSecondImplicitlyIntent = new Intent("cn.aneureka.firstapplication.ACTION_START");
                toSecondImplicitlyIntent.addCategory("cn.aneureka.firstapplication.MY_CATEGORY");
                startActivity(toSecondImplicitlyIntent);
            }
        });

        Button openBrowserButton = findViewById(R.id.button_open_browser);
        openBrowserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openBrowserIntent = new Intent(Intent.ACTION_VIEW);
                openBrowserIntent.setData(Uri.parse("https://www.google.com"));
                startActivity(openBrowserIntent);
            }
        });

        Button dialButton = findViewById(R.id.button_dial);
        dialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:10086"));
                startActivity(dialIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You click Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You click Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
