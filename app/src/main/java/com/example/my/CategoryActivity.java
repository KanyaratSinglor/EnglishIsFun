package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.my.model.Puzzle;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);

        //ปุ่มเลือกหมวดหมู่

        //หมวด Animal
        Button buttonAnimal = findViewById(R.id.animal_button);

        buttonAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //สร้าง Object Puzzle เพื่อเก็บรูปภาพคำถามและคำตอบ
                Puzzle rabbit = new Puzzle(R.drawable.rabbit, "rabbit");
                Puzzle dog = new Puzzle(R.drawable.dog, "dog");
                Puzzle lion = new Puzzle(R.drawable.lion, "lion");
                Puzzle pig = new Puzzle(R.drawable.pig, "pig");
                //ทำการเก็บรูปภาพคำถามและคำตอบลง ArrayList<Puzzles>
                final ArrayList<Puzzle> puzzles = new ArrayList<>();
                //เพิ่มคำศัพท์ลงใน ArrayList
                puzzles.add(rabbit);
                puzzles.add(dog);
                puzzles.add(lion);
                puzzles.add(pig);

                Intent intent = new Intent(CategoryActivity.this, ActivityHomeList.class);
                //แปลง  ArrayList Object เป็นข้อความ
                String itemJson = new Gson().toJson(puzzles);
                //ส่งข้อความของ ArrayList Object
                intent.putExtra("puzzles", itemJson);
                //ส่งชื่อไปยังหน้าถัดไป
                intent.putExtra("name",  getIntent().getStringExtra("name"));
                startActivity(intent);
            }
        });


        Button buttonBody = findViewById(R.id.body_button);

        buttonBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //สร้าง Object Puzzle เพื่อเก็บรูปภาพคำถามและคำตอบ
                Puzzle arm = new Puzzle(R.drawable.arm, "arm");
                Puzzle hand = new Puzzle(R.drawable.hand, "hand");
                Puzzle head = new Puzzle(R.drawable.head, "head");
                Puzzle eye = new Puzzle(R.drawable.eye, "eye");
                //ทำการเก็บรูปภาพคำถามและคำตอบลง ArrayList<Puzzles>
                final ArrayList<Puzzle> puzzles = new ArrayList<>();
                //เพิ่มคำศัพท์ลงใน ArrayList
                puzzles.add(arm);
                puzzles.add(head);
                puzzles.add(hand);
                puzzles.add(eye);

                Intent intent = new Intent(CategoryActivity.this, ActivityHomeList.class);
                //แปลง  ArrayList Object เป็นข้อความ
                String itemJson = new Gson().toJson(puzzles);
                //ส่งข้อความของ ArrayList Object
                intent.putExtra("puzzles", itemJson);
                //ส่งชื่อไปยังหน้าถัดไป
                intent.putExtra("name",  getIntent().getStringExtra("name"));
                startActivity(intent);

            }
        });

        Button buttonHome = findViewById(R.id.home_button);

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //สร้าง Object Puzzle เพื่อเก็บรูปภาพคำถามและคำตอบ
                Puzzle jar = new Puzzle(R.drawable.jar, "jar");
                Puzzle telephone = new Puzzle(R.drawable.telephone, "telephone");
                Puzzle jug = new Puzzle(R.drawable.jug, "jug");
                Puzzle broom = new Puzzle(R.drawable.broom, "broom");
                //ทำการเก็บรูปภาพคำถามและคำตอบลง ArrayList<Puzzles>
                final ArrayList<Puzzle> puzzles = new ArrayList<>();
                //เพิ่มคำศัพท์ลงใน ArrayList
                puzzles.add(jar);
                puzzles.add(telephone);
                puzzles.add(jug);
                puzzles.add(broom);

                Intent intent = new Intent(CategoryActivity.this, ActivityHomeList.class);
                //แปลง  ArrayList Object เป็นข้อความ
                String itemJson = new Gson().toJson(puzzles);
                //ส่งข้อความของ ArrayList Object
                intent.putExtra("puzzles", itemJson);
                //ส่งชื่อไปยังหน้าถัดไป
                intent.putExtra("name",  getIntent().getStringExtra("name"));
                startActivity(intent);
            }
        });

    }
}