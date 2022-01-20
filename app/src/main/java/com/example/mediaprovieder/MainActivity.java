package com.example.mediaprovieder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button searh,facebook;
    EditText searchbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    searchbox=findViewById(R.id.serarch);
    searh=findViewById(R.id.Search_button);
    facebook=findViewById(R.id.facebook);

     facebook.setOnClickListener(this);
     searh.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == facebook){
            Intent intent=new Intent(MainActivity.this,Home.class);
            //put extra to get the dat
            intent.putExtra("urlAddress","https://www.youtube.com");
            startActivity(intent);
        }
        if(view == searh){
            openWebpage();
        }

    }

    private void openWebpage() {
        String input=searchbox.getText().toString();
        if(TextUtils.isEmpty(input)){
            Toast.makeText(MainActivity.this, "please enter the address", Toast.LENGTH_SHORT).show();
        }else
        {
            String url_without_http=input.replaceAll("https://www.","");
            String https="https://";
            String www="www.";

            Intent search=new Intent(MainActivity.this,Home.class);
             search.putExtra("urlAddress",https+www+url_without_http);
            startActivity(search);
        }
    }
}