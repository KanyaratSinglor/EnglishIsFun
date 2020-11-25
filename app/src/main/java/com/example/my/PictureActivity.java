package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.my.db.AppDatabase;
import com.example.my.model.Puzzle;
import com.example.my.model.User;
import com.example.my.util.AppExecutors;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

public class PictureActivity extends AppCompatActivity {

    ImageView image ;
    int i = 0;
    //กำหนดค่าเริ่มต้นให้คะแนนเป็นมีค่า 0
    int score = 0;
    ArrayList<Puzzle> puzzles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);


        Intent intent = getIntent();
        //รับข้อความที่เป็น json object เข้ามา
        String jsonItem = intent.getStringExtra("puzzles");
        Gson gson = new Gson();
        Type puzzlesListType = new TypeToken<ArrayList<Puzzle>>(){}.getType();
        //แปลง json ข้อความให้เป็น object
        puzzles = gson.fromJson(jsonItem, puzzlesListType);

        //ทำการสลับลำดับ puzzles ที่อยู่ใน ArrayList
        Collections.shuffle(puzzles);



        //การอ้างอิง component รูปภาพ
        image = findViewById(R.id.image_view_pic);
        //การ set ค่าเริ่มต้นของรูปภาพ
        image.setImageResource(puzzles.get(0).getQuestionImgResId());



        Button buttonNext = findViewById(R.id.button_next);

        //ปุ่ม Next ทำการ check คำตอบ
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //เข้าถึง puzzle ปัจจุบันเพื่อนำมาใช้ตรวจสอบ
                Puzzle puzzle = puzzles.get(i);
                //ช่องกรอกคำตอบของผุ้เล่น
                EditText editTextAnswer = findViewById(R.id.editText_ans);
                String input = editTextAnswer.getEditableText().toString();
                //ถ้าตอบถูกจะทำการบวกคะแนนเพิ่มที +1
                if(input.equalsIgnoreCase(puzzle.getAnswer())){
                    score++;
                    //เมื่อทำถูกจะแสดงคำว่า"TRUE"
                    Toast.makeText(getApplicationContext(), "TRUE", Toast.LENGTH_SHORT).show();
                }
                else{
                    //เมื่อทำผิดจะแสดงคำว่า"FALSE"
                    Toast.makeText(getApplicationContext(), "FALSE", Toast.LENGTH_SHORT).show();
                }
                editTextAnswer.setText("");
                //ทำารเลื่อนไปยังข้อถัดไป
                i++;
                //เมื่อจบคำถามสุดท้ายจะดำเนินการตาม process ด้านล่าง
                if(puzzles.size() == i){
                    //แสดงคำว่า"END GAMES"
                    Toast.makeText(getApplicationContext(), "END GAMES", Toast.LENGTH_SHORT).show();

                    //เชื่อมต่อ database
                    AppExecutors executors = new AppExecutors();
                    executors.diskIO().execute(new Runnable() {
                        @Override
                        public void run() { // worker thread
                            AppDatabase db = AppDatabase.getInstance(PictureActivity.this);
                            User user = new User(0, getIntent().getStringExtra("name"), score);
                            //ทำการเก็บชื่่อและคะแนนที่ได้ของผู้เล่นลงใน database
                            db.userDao().addUser(user);
                            finish();
                        }
                    });


                    Intent intent = new Intent(PictureActivity.this, ShowScore.class);
                    //ส่งคะแนนเพื่อแสดงยังหน้าถัดไป
                    intent.putExtra("Score", score);
                    startActivity(intent);



                }
                //หากยังไม่จบเกมส์ จะทำprocess ด้านล่าง
                else {
                    //เรียก puzzles ถัดไปมาแสดง
                    puzzle = puzzles.get(i);
                    image.setImageResource(puzzle.getQuestionImgResId());
                }


            }
        });
    }
}