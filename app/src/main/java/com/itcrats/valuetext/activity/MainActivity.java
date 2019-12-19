package com.itcrats.valuetext.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.itcrats.valuetext.R;
import com.itcrats.valuetext.adapter.ChatAdapter;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

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
    // Material SearchView
    private MaterialSearchView searchView;
    // Toolbar
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        // Search
        searchContent();
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

    /**
     * SearchView
     */
    private void searchContent() {
        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // Search
        MenuItem searchItem = menu.findItem(R.id.search);
        searchView.setMenuItem(searchItem);

        /*SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toasty.success(mContext, query).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });*/
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
