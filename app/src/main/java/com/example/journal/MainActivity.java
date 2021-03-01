package com.example.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private FloatingActionButton addBtn;
    private ArrayList<User> array_db_user;
    private TaskSqlLiteDatabase db;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Add_user.class));

            }
        });
        db = new TaskSqlLiteDatabase(MainActivity.this);
        array_db_user = db.ReadALLUser();
         adapter=new Adapter(MainActivity.this,array_db_user);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User userItem=(User)parent.getItemAtPosition(position);
                Intent intent=new  Intent(MainActivity.this,Update_user.class);
                intent.putExtra("name",userItem.getName());
                intent.putExtra("phone",userItem.getPhone());
                intent.putExtra("id",userItem.getId());
                startActivity(intent);
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                User userItem = (User) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Item Long Click at position "+position+"\ntitle : "+userItem.getName(), Toast.LENGTH_LONG).show();



                return false;
            }
        });



    }
}