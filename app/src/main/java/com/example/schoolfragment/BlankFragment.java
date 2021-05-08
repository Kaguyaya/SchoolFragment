package com.example.schoolfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolfragment.databinding.FragmentBlankBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    private static final String TAG = "Fragment";
private FragmentBlankBinding binding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public BlankFragment() {
    }


    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.i(TAG,"onCreate() is called");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentBlankBinding.inflate(inflater,container,false);
        View view=binding.getRoot();
        getParentFragmentManager().setFragmentResultListener("title", this, (requestKey, result) -> {
            final String title = result.getString("title_name");
            binding.tvTitle.setText(title);
        });
        Log.i(TAG,"onCreateView() is called");
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG,"onAttach() is called");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,"onCreateView() is called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"onCreateView() is called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"onCreateView() is called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"onCreateView() is called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"onCreateView() is called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onCreateView() is called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"onCreateView() is called");
    }
}