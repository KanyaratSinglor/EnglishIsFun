package com.example.my.model;

public class Puzzle {
    //รูปภาพคำถาม
    int questionImgResId;
    //คำตอบ
    String answer;

    public Puzzle(int questionImgResId, String answer){
        //กำหนดคำถาม
        this.questionImgResId = questionImgResId;
        //กำหนดคำตอบ
        this.answer = answer;
    }

    public int getQuestionImgResId() {
        return questionImgResId;
    }

    public String getAnswer() {
        return answer;
    }
}
