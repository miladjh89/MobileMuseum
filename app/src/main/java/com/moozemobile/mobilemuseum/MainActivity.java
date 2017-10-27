package com.moozemobile.mobilemuseum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Animation
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setAlpha(0f);
        animate(imageView2);
        Button button = (Button) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MenuMainActivity.class);
                startActivity(intent);
            }
        });

    }
    //Animation
    public void animate(View v){
        imageView2.animate().alpha(1f).setDuration(4000);
    }
}
