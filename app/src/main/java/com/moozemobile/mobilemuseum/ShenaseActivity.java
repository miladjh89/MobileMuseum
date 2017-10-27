package com.moozemobile.mobilemuseum;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShenaseActivity extends AppCompatActivity {
Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shenase);
        // Action bar back shift
        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        Button button3 = (Button) findViewById(R.id.button3);
                button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog pdialog = new ProgressDialog(ShenaseActivity.this);
                pdialog.show();
                pdialog.setCancelable(false);
                pdialog.setMessage("Please wait ...");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pdialog.dismiss();
                    }
                }, 2000L);
                    Intent intent = new Intent(ShenaseActivity.this, DataActivity.class);
                    startActivity(intent);
                    return;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            ShenaseActivity.this.finish();
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
