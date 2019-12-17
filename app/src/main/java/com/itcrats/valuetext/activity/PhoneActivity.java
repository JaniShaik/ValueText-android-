package com.itcrats.valuetext.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.itcrats.valuetext.R;
import com.itcrats.valuetext.model.PhoneNumber;
import com.itcrats.valuetext.utils.Constants;
import com.itcrats.valuetext.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import es.dmoral.toasty.Toasty;

public class PhoneActivity extends AppCompatActivity {

    // Context
    private Context mContext = this;
    // ImageView
    private ImageView logoIMG;
    // Spinner
    private Spinner phoneSpinner;
    private HashMap<String, String> phoneNumberMap = new LinkedHashMap<String, String>();
    private ArrayList<String> phoneNumberValues;
    private ArrayAdapter<String> phoneNumberAdapter;
    private String phoneNumberKey = "";
    // EditText
    private EditText mobileET;
    // Button
    private Button nextBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hiding Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_phone);
        // Hiding Action Bar
        getSupportActionBar().hide();
        // Initialize
        initialization();
    }

    // Initialization
    private void initialization() {
        // ImageView
        logoIMG = findViewById(R.id.logoIMG);
        // Set Image
        Glide.with(this).load(Constants.LOGO_URL).into(logoIMG);
        // Spinner
        phoneSpinner = findViewById(R.id.phoneSpinner);
        // Data
        phoneNumberMap.put("", "-- Select --");
        phoneNumberMap.put("1", "9848012345");
        phoneNumberValues = new ArrayList<String>(phoneNumberMap.values());
        // Set Adapter
        settingAdapterToSpinner();
        // Button
        nextBTN = findViewById(R.id.nextBTN);
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phoneNumberKey.isEmpty()) {
                    Toasty.error(mContext, "Please select mobile number..!").show();
                } else {
                    Intent intent = new Intent(mContext, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    // Spinner Adapter
    private void settingAdapterToSpinner() {
        phoneNumberAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item, phoneNumberValues);
        phoneSpinner.setAdapter(phoneNumberAdapter);
        phoneNumberAdapter.notifyDataSetChanged();

        phoneSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String typeValue = phoneSpinner.getSelectedItem().toString();
                phoneNumberKey = (String) Utils.getKeyFromValue(phoneNumberMap, typeValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
