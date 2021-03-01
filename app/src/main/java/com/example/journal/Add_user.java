package com.example.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_user extends AppCompatActivity {
    private Button btn_add;
    private EditText add_name,add_phone;
    private TaskSqlLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        add_name=findViewById(R.id.add_name);
        add_phone=findViewById(R.id.add_phone);
        btn_add=findViewById(R.id.btn_note_add);
        db = new TaskSqlLiteDatabase(Add_user.this);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = add_name.getText().toString();
                String phone = add_phone.getText().toString();
                db.CreateUser(new User(name,phone));
                Toast.makeText(Add_user.this, "User created .... !", Toast.LENGTH_SHORT).show();
                Intent car = new Intent(Add_user.this,MainActivity.class);
                startActivity(car);
            }
        });
    }
}