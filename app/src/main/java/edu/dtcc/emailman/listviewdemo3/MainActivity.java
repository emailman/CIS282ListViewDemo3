package edu.dtcc.emailman.listviewdemo3;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    // Used to not handle a click after a long press
    boolean isLongClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Build the array for the list
        final String[] fruits = {"Apple", "Mango", "Orange", "Grapes", "Bananas"};

        // Get a reference to the list view
        ListView fruitsList = (ListView) findViewById(android.R.id.list);

        // Bind the array to the ArrayAdapter
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, fruits);
        fruitsList.setAdapter(myAdapter);


        // Define an OnItemClick listener
        fruitsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int arg2, long arg3) {

                // Don't process a click immediately after a long click
                if (!isLongClick) {
                    String message = "Click on " + fruits[arg2];
                    Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
                }
                else
                    isLongClick = false;
            }
        });

        // Define an OnItemLongClick listener
        fruitsList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int arg2, long arg3) {

                isLongClick = true;
                String message = "Press on " + fruits[arg2];
                Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }
}
