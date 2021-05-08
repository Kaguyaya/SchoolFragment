package com.example.schoolfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.schoolfragment.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
private ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }
}