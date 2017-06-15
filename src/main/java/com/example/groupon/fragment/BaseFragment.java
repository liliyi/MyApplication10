package com.example.groupon.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.groupon.ui.MainActivity;

/**
 * Created by tarena on 2017/6/15.
 */

public class BaseFragment extends Fragment {

    public void skip(View view){

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });


    }
}
