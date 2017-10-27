package com.moozemobile.mobilemuseum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class M1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1);
        // Action bar back shift
        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Button button2 = (Button) findViewById(R.id.button2);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button36 = (Button) findViewById(R.id.button36);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(M1Activity.this,ShenaseActivity.class);
                startActivity(intent);
                return;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(M1Activity.this,UpdateActivity.class);
                startActivity(intent);
                return;
            }
            });

        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(M1Activity.this,UpdateActivity.class);
                startActivity(intent);
                return;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            M1Activity.this.finish();
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
