package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Date;

public class androidmodeldata extends AppCompatActivity {
    private String pId;
    String subject;
    String text;
    Date date;

    public androidmodeldata(String subject,String text,Date date){
        this.subject=subject;
        this.text=text;
        this.date=date;
    }
    public androidmodeldata(){}
    public String getText(){return text;}
    public String getSubject(){return subject;}
    public Date getDate(){return date;}
    public String getpId(){return pId;}
    public void setpId(String pId){this.pId=pId;}
    public void setSubject(String subject){this.subject=subject;}
    public void setText(String text){this.text=text;}
    public void setDate(Date date){this.date=date;}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidmodeldata);
    }
}
