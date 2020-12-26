package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class modelnote extends AppCompatActivity {

    public class modelNote implements Serial {
        private String id;
        private String title;
        private String desc;
        private String date;
        private String user;

        public modelNote(){}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }
}
