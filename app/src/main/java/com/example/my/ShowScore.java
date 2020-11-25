package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my.db.AppDatabase;
import com.example.my.model.User;
import com.example.my.util.AppExecutors;

public class ShowScore extends AppCompatActivity {


    @Override
    protected void onResume() {
        super.onResume();

        final AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                //  เชื่อม database และดึงข้อมูลของผู้เล่นมาทำการเก็บไว้ใน Array ซึ่งข้อมูลจะถูกเรียงลำดับคะแนนไว้อยู่แล้วจาก Query database ด้วย order By point DESC
                AppDatabase db = AppDatabase.getInstance(ShowScore.this);
                final User[] users = db.userDao().getAllUsers();
                System.out.println(users.length);

                executors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        //แสดงข้อมูลผู้เล่นที่ได้คะแนนสูงสุด
                        TextView textViewTopName1 = findViewById(R.id.text_view_top_name_1);
                        textViewTopName1.setText(users[0].name);

                        TextView textViewTopPoint1 = findViewById(R.id.text_view_top_point_1);
                        textViewTopPoint1.setText(String.valueOf(users[0].point));


                        //แสดงข้อมูลผู้เล่นที่ได้คะแนนอันรองอันดับ1
                        TextView textViewTopName2 = findViewById(R.id.text_view_top_name_2);
                        textViewTopName2.setText(users[1].name);

                        TextView textViewTopPoint2 = findViewById(R.id.text_view_top_point_2);
                        textViewTopPoint2.setText(String.valueOf(users[1].point));


                        //แสดงบข้อมูลผู้เล่นที่ได้คะแนนอันรองอันดับ2
                        TextView textViewTopName3 = findViewById(R.id.text_view_top_name_3);
                        textViewTopName3.setText(users[2].name);

                        TextView textViewTopPoint3 = findViewById(R.id.text_view_top_point_3);
                        textViewTopPoint3.setText(String.valueOf(users[2].point));
                    }
                });
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

       //รับค่าจาก score จาก intent
       int point = getIntent().getIntExtra("Score", 0);

       //นำมาแสดงค่า score
       TextView textViewScore = findViewById(R.id.text_viwe_show_score);
       textViewScore.setText(point+ "");

    }
}