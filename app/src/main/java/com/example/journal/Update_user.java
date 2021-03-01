package com.example.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_user extends AppCompatActivity {
    private Button btn_update;
    private EditText edite_name,edite_phone;
    private Intent my_data;
    private String user_name,user_phone;
    private int user_id;
    private TaskSqlLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        btn_update=findViewById(R.id.btn_note_update);
        edite_name=findViewById(R.id.update_name);
        edite_phone=findViewById(R.id.update_phone);

        my_data = getIntent();
        user_name = my_data.getStringExtra("name");
        user_phone = my_data.getStringExtra("phone");
        user_id = my_data.getIntExtra("id",0);
        edite_name.setText(user_name);
        edite_phone.setText(user_phone);
        db= new TaskSqlLiteDatabase(Update_user.this);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edite_name.getText().toString();
                String phone = edite_phone.getText().toString();
                db.UpdateUser(new User(user_id,name,phone));
                Toast.makeText(Update_user.this, "User updated .... !", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Update_user.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}