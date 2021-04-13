package com.example.nguyenhuytoan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nguyenhuytoan.adapter.UserAdapter;
import com.example.nguyenhuytoan.database.UserDatabase;
import com.example.nguyenhuytoan.entity.UserEntity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edUser,edQuantity;
    private Button btAdd,btView;

    UserDatabase db;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = UserDatabase.getUserDatabase(this);
        initView();

    }

    private void initView(){
        edUser = findViewById(R.id.edUser);
        edQuantity = findViewById(R.id.edQuantity);
        btAdd = findViewById(R.id.btAdd);
        btView = findViewById(R.id.btView);
        btAdd.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == btAdd){
            onAdd();
        }
    }

    public void onAdd(){
        if (edUser.getText().toString().isEmpty()){
            Toast.makeText(this,"Please enter username",Toast.LENGTH_LONG).show();
            return;
        }

        UserEntity user = new UserEntity();
        Log.d("TAG", "onAdd: " + edUser.getText().toString());
        user.name = edUser.getText().toString();
        user.quantity = Integer.valueOf(edQuantity.getText().toString());
        db.userDao().insertUser(user);


    }
}