package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //กรอกชื่อผู้เล่น
        final EditText editTextName = (EditText) findViewById(R.id.edit_text_name);

        //สร้างปุ่มหน้าถัดไป
        Button startButton = findViewById(R.id.learn_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = editTextName.getEditableText().toString();
                //ชื่อผู้เล่นห้ามเป็นช่องว่าง
                if(msg.isEmpty()){
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    CharSequence text = "Please enter your name";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                //ทำการเปลี่ยนหน้า
                else {
                    Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                    //ส่งชื่อไปยังหน้าถัดไป
                    intent.putExtra("name", msg);
                    startActivity(intent);
                }


            }
        });


    }
}