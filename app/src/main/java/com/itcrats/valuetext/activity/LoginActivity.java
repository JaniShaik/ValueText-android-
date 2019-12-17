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
import com.itcrats.valuetext.utils.Constants;
import com.itcrats.valuetext.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity {

    // Context
    private Context mContext = this;
    // ImageView
    private ImageView logoIMG;
    // Button
    private Button loginBTN;
    // Spinner
    private Spinner typeSpinner;
    private HashMap<String, String> typeMap = new LinkedHashMap<String, String>();
    private ArrayList<String> typeValues;
    private ArrayAdapter<String> typeAdapter;
    private String typeKey = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hiding Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        // Hiding Action Bar
        getSupportActionBar().hide();
        // Initialization
        initialization();
        // LogIn click
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    // Initialization
    private void initialization() {
        // ImageView
        logoIMG = findViewById(R.id.logoIMG);
        // Set Image
        Glide.with(this).load(Constants.LOGO_URL).into(logoIMG);
        // Spinner
        typeSpinner = findViewById(R.id.typeSpinner);
        // Data
        typeMap.put("", "-- Select salesforce instance --");
        typeMap.put("1", "Sandbox");
        typeMap.put("2", "Production");
        typeValues = new ArrayList<>(typeMap.values());
        // Setting adapter to spinner
        settingAdapterToSpinner();
        // Button
        loginBTN = findViewById(R.id.loginBTN);

    }

    // Spinner Adapter
    private void settingAdapterToSpinner() {
        typeAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item, typeValues);
        typeSpinner.setAdapter(typeAdapter);
        typeAdapter.notifyDataSetChanged();

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String typeValue = typeSpinner.getSelectedItem().toString();
                typeKey = (String) Utils.getKeyFromValue(typeMap, typeValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    // Validation
    private void validate() {
        if (typeKey.isEmpty()) {
            Toasty.error(mContext, "Please select salesforce instance").show();
        } else {
            navigateToPhone();
        }
    }

    // Navigate to Phone number
    private void navigateToPhone() {
        Intent intent = new Intent(mContext, PhoneActivity.class);
        startActivity(intent);
    }

}
