package com.moozemobile.mobilemuseum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MuseumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);
        // Action bar back shift
        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button30 = (Button) findViewById(R.id.button30);
        Button button31 = (Button) findViewById(R.id.button31);
        Button button32 = (Button) findViewById(R.id.button32);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MuseumActivity.this,M1Activity.class);
                startActivity(intent);
                return;
            }
        });
        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MuseumActivity.this,UpdateActivity.class);
                startActivity(intent);
                return;
            }
        });
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MuseumActivity.this,UpdateActivity.class);
                startActivity(intent);
                return;
            }
        });
        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MuseumActivity.this,UpdateActivity.class);
                startActivity(intent);
                return;
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            MuseumActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        //menu.add("Action1");
        //menu.add("Action2");
        //SubMenu subMenu = menu.addSubMenu("Action3");
        //subMenu.add("action1");
        //subMenu.add("action2");
        return super.onCreateOptionsMenu(menu);
    }

}
