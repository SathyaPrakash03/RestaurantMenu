package com.cornez.restaurantmenu;

/**
 * Created by Alerik Vi on 11/28/2016.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

public class EntreeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entree, container, false);
    }

    public void onRadioButtonCLicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioButton4:
                if(checked)
                    //store pref
                    break;
            case R.id.radioButton5:
                if(checked)
                    //store pref
                    break;
            case R.id.radioButton6:
                if(checked)
                    //store pref
                    break;
        }
    }
}
