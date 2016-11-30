package com.cornez.restaurantmenu;

/**
 * Created by Alerik Vi on 11/28/2016.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DessertFragment extends Fragment {

    RadioGroup radioGroup;

    final String KEY_SAVED_RADIO_BUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dessert, container, false);
    }

    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        radioGroup = (RadioGroup) getActivity().findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGroupOnCheckedChangeListener);
        LoadPreferences();
    }

    RadioGroup.OnCheckedChangeListener radioGroupOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int id) {

            RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(id);
            int checkedIndex = radioGroup.indexOfChild(checkedRadioButton);
            SavePreferences(KEY_SAVED_RADIO_BUTTON_INDEX, checkedIndex);
        }
    };

    private void SavePreferences(String key, int value) {
        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("MY_SHARED_PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    private void LoadPreferences() {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("MY_SHARED_PREF", Context.MODE_PRIVATE);
        int saveRadioIndex = sharedPreferences.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0);
        RadioButton savedCheckedRadioButton = (RadioButton) radioGroup.getChildAt(saveRadioIndex);
        savedCheckedRadioButton.setChecked(true);
    }

}
