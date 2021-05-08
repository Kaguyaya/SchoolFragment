package com.example.schoolfragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.schoolfragment.databinding.ActivityCalculatorDialogBinding;

public class CalculatorDialog extends DialogFragment {
    private ActivityCalculatorDialogBinding binding;
    private OnLoginInputListener listener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=ActivityCalculatorDialogBinding.inflate(inflater,container,false);
        View view=binding.getRoot();
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username=binding.etusername.getText().toString().trim();
                final String password=binding.etpassword.getText().toString();
                listener.onDialogPositiveClick(username,password);
                CalculatorDialog.this.dismiss();
            }
        });
        binding.canel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CalculatorDialog.this.dismiss();
            }
        });
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        final WindowManager.LayoutParams params=requireDialog().getWindow().getAttributes();
        params.width=ViewGroup.LayoutParams.MATCH_PARENT;
        requireDialog().getWindow().setAttributes(params);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.listener= (OnLoginInputListener) context;
    }
    public interface OnLoginInputListener{
        public void onDialogPositiveClick(String username,String password);
        public void onDialogNegativeClick(DialogFragment dialog);
    }
}