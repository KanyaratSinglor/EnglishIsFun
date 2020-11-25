package com.example.my;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my.model.ItemWord;
import com.example.my.model.Puzzle;
import com.example.my.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ActivityHomeList extends AppCompatActivity {

    String jsonItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_list);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_1);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        Intent intent = getIntent();
        //รับข้อความที่เป็น json object เข้ามา
        jsonItem = intent.getStringExtra("puzzles");
        Gson gson = new Gson();
        Type puzzlesListType = new TypeToken<ArrayList<Puzzle>>(){}.getType();
        //แปลง json ข้อความให้เป็น object
        ArrayList<Puzzle> puzzles = gson.fromJson(jsonItem, puzzlesListType);

        // specify an adapter (see also next example)
        MyAdapter mAdapter = new MyAdapter(puzzles);
        recyclerView.setAdapter(mAdapter);

        //ปุ่มเริ่มทำแบบทดสอบ
        Button toPicture = findViewById(R.id.to_pic);
        toPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHomeList.this, PictureActivity.class);
                //ส่งข้อความของ ArrayList Object ไปยังหน้าถัดไป
                intent.putExtra("puzzles", jsonItem);
                //ส่งชื่อไปยังหน้าถัดไป
                intent.putExtra("name", getIntent().getStringExtra("name"));
                startActivity(intent);
            }
        });

    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private ArrayList<Puzzle> puzzles;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        //2
        public class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView text;
            public ImageView image;
            public MyViewHolder(View v) {
                super(v);
                text = v.findViewById(R.id.text_view_word);
                image = v.findViewById(R.id.image_view);

                System.out.println("MyViewHolder");
            }
        }
        public MyAdapter(ArrayList<Puzzle> puzzles) {
            this.puzzles = puzzles;
            System.out.println("MyAdapter");

        }
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_word, parent, false);

            MyViewHolder vh = new MyViewHolder(v);
            System.out.println("onCreateViewHolder");
            return vh;
        }
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            //กดหนดรูปภาพและข้อความบน item
            holder.image.setImageResource(puzzles.get(position).getQuestionImgResId());
            holder.text.setText(puzzles.get(position).getAnswer());

            System.out.println("onBindViewHolder");
        }
        public int getItemCount() {

            System.out.println("getItemCount");
            //กดหนดขนาดของ list view
            return puzzles.size();
        }
    }


}