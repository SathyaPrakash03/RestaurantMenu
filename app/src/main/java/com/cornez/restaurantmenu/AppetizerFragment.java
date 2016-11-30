package com.cornez.restaurantmenu;

/**
 * Created by Alerik Vi on 11/28/2016.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import static android.content.Context.MODE_PRIVATE;


public class AppetizerFragment extends Fragment {

    RadioGroup radioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        RadioButton bread = (RadioButton) getView().findViewById(R.id.radioButton1);
//        RadioButton soup = (RadioButton) getView().findViewById(R.id.radioButton2);
//        RadioButton salad = (RadioButton) getView().findViewById(R.id.radioButton3);

        SharedPreferences sharedPref = getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

//        bread.setChecked(sharedPref.getBoolean("bread", false));
//        soup.setChecked(sharedPref.getBoolean("soup", false));
//        salad.setChecked(sharedPref.getBoolean("salad", false));



        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_appetizer, container, false);
    }

//    public void onRadioButtonCLicked(View view, SharedPreferences.Editor editor) {
//
//        boolean checked = ((RadioButton) view).isChecked();
//
//        switch(view.getId()) {
//            case R.id.radioButton1:
//                if(checked)
//                    editor.putBoolean("bread", true);
//                break;
//            case R.id.radioButton2:
//                if(checked)
//                    editor.putBoolean("soup", true);
//                    break;
//            case R.id.radioButton3:
//                if(checked)
//                    editor.putBoolean("salad", true);
//                    break;
//        }
//    }


}
