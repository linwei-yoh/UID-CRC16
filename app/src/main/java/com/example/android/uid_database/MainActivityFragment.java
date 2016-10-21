package com.example.android.uid_database;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @BindView(R.id.Input_Uid)
    EditText Input_Uid;

    @BindView(R.id.result)
    EditText Output_result;
    @BindView(R.id.calculate)
    Button Btncal;
    @OnClick(R.id.calculate)
    public void btnClick(){
        String id;
        int result;

        id = Input_Uid.getText().toString();
        if(id.length() != 16){
            id = Utility.addZeroForNum(id,16);
        }

        id = "wz"+id.substring(2,id.length()-2)+"yk";
        id = id.toUpperCase();

        result = Utility.CRC16(id.getBytes());

        Output_result.setText(String.valueOf(result));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,rootView);

//        Input_Uid.setTransformationMethod(new AllCapTransformationMethod ());
        return rootView;
    }

}
