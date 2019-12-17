package com.itcrats.valuetext.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.itcrats.valuetext.R;
import com.itcrats.valuetext.adapter.ChatAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Context
    private Context mContext = this;
    // RecyclerView
    private RecyclerView chatRV;
    private ChatAdapter chatAdapter;

    String[] values = new String[] { "Jan",
            "Mark",
            "Sundar",
            "Rahul",
            "Trivago",
            "Kevin"
    };
    String[] chatDescription = new String[] { "Hey There! Are you using whatsapp?",
            "All data is...ummm...safe",
            "How is the scholarship going on?",
            "This morning i woke up at night",
            "Kya aapne kabhi online hotel booking kiya hai?",
            "Photo"
    };

    String[] chatDates = new String[] { "08:58",
            "YESTERDAY",
            "05/03/2018",
            "03/03/2018",
            "27/02/2018",
            "26/02/2018"
    };

    final ArrayList<String> chatNameList = new ArrayList<String>();
    final ArrayList<String> chatDescriptionList = new ArrayList<String>();
    final ArrayList<String> chatDatesList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialization
        initialize();
        // Data


        for (int i = 0; i < values.length; ++i) {
            chatNameList.add(values[i]);
        }

        for (int i = 0; i < values.length; ++i) {
            chatDescriptionList.add(chatDescription[i]);
        }

        for (int i = 0; i < values.length; ++i) {
            chatDatesList.add(chatDates[i]);
        }
    }

    // Initialize
    private void initialize(){
        // RecyclerView
        chatRV =  findViewById(R.id.chatRV);
        // Layout Manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        chatRV.setLayoutManager(linearLayoutManager);
        chatAdapter = new ChatAdapter(mContext, chatNameList, chatDescriptionList, chatDatesList);
        chatRV.setAdapter(chatAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
