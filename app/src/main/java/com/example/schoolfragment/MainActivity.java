package com.example.schoolfragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import com.example.schoolfragment.databinding.ActivityCalculatorDialogBinding;
import com.example.schoolfragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,CalculatorDialog.OnLoginInputListener{
    private ActivityMainBinding binding;
    private SparseArray fragments;
    private static final String TAG = "Activity1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initFragment();
        replaceFragement(R.id.fragmenttitle, (Fragment) fragments.get(R.id.fragmenttitle));
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculatorDialog calculatorDialog=new CalculatorDialog();
                calculatorDialog.show(getSupportFragmentManager(),"计算");
            }
        });
    }
    private void initFragment(){
        fragments=new SparseArray();
        fragments.put(R.id.fragmenttitle,BlankFragment.newInstance());
    }
    private void replaceFragement(int containerId, Fragment fragment){
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(containerId,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart() is called");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.i(TAG,"onCreate() is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart() is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume() is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause() is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop() is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy() is called");
    }
    public void onDialogPositiveClick(String username, String password) {
        int num= Integer.parseInt(username)+Integer.parseInt(password);
        Toast.makeText(this,String.valueOf(num),Toast.LENGTH_SHORT).show();
    }
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(this,"取消",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button1:Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.button2:Intent intent2=new Intent(MainActivity.this,CalculatorDialog.class);
                startActivity(intent2);
                break;
        }

    }
}