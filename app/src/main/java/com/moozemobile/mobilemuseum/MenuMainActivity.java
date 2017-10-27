package com.moozemobile.mobilemuseum;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);
        ImageView imageView13 = (ImageView) findViewById(R.id.imageView13);
        ImageView imageView14 = (ImageView) findViewById(R.id.imageView14);
        ImageView imageView15 = (ImageView) findViewById(R.id.imageView15);
        ImageView imageView16 = (ImageView) findViewById(R.id.imageView16);
        ImageButton imageButton17 = (ImageButton) findViewById(R.id.imageButton17);
        ImageButton imageButton18 = (ImageButton) findViewById(R.id.imageButton18);
        ImageButton imageButton19 = (ImageButton) findViewById(R.id.imageButton19);
        ImageButton imageButton20 = (ImageButton) findViewById(R.id.imageButton20);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        TextView txtusername = (TextView) findViewById(R.id.txtusername);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String username="";
            if (extras.containsKey("username")){
                username = extras.getString("username");
            }
            txtusername.setText("" + username);

        }

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        imageButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intemt = new Intent(MenuMainActivity.this,MuseumActivity.class);
                startActivity(intemt);
                return;
            }
        });
        imageButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intemt = new Intent(MenuMainActivity.this,UpdateActivity.class);
                startActivity(intemt);
                return;
            }
        });
        imageButton19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intemt = new Intent(MenuMainActivity.this,UpdateActivity.class);
                startActivity(intemt);
                return;
            }
        });
        imageButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intemt = new Intent(MenuMainActivity.this,UpdateActivity.class);
                startActivity(intemt);
                return;
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://t.me/moze_mobile"));
                startActivity(intent);
                return;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        menu.add("Sign in").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(MenuMainActivity.this,Sign_in.class);
                startActivity(intent);

                return false;
            }
        });
        menu.add("Exit").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuMainActivity.this);
                builder.setTitle("Exit");
                builder.setMessage("Do you sure?");
                builder.setCancelable(false);
                builder.setIcon(android.R.drawable.ic_menu_close_clear_cancel);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       Toast.makeText(MenuMainActivity.this,"Exit",Toast.LENGTH_SHORT).show();
                        finishAffinity();
                    }
                });
                builder.setNegativeButton("No",null);
                builder.show();

                return false;
            }
        });
        //menu.add("Action1");
        //menu.add("Action2");
        //SubMenu subMenu = menu.addSubMenu("Action3");
        //subMenu.add("action1");
        //subMenu.add("action2");
        return super.onCreateOptionsMenu(menu);
    }



/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }*/
}
