package com.apress.gerber.reminders;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.SQLException;

public class RemindersActivity extends AppCompatActivity {
    private ListView mListView;
    private RemindersDbAdapter mDbAdapter;
    private RemindersSimpleCursorAdapter mCursorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        mListView = (ListView) findViewById(R.id.reminders_list_view);

        mListView.setDivider(null);
        mDbAdapter=new RemindersDbAdapter(this);
        try {
            mDbAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Cursor cursor = mDbAdapter.fetchAllReminders();
        String[] from = new String[]{
                RemindersDbAdapter.COL_CONTENT
        };
        int[] to = new int[] { R.id.row_text };

        mCursorAdapter = new RemindersSimpleCursorAdapter(RemindersActivity.this,R.layout.reminders_row,cursor,from,to,0);
        mListView.setAdapter(mCursorAdapter);
//        //The arrayAdatper is the controller in our
//        //model-view-controller relationship. (controller)
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                //context
//                this,
//                //layout (view)
//                R.layout.reminders_row,
//                //row (view)
//                R.id.row_text,
//                //data (model) with bogus data to test our listview
//                new String[]{"first record", "second record", "third record", "fourth record", "fifth record"});
//        mListView.setAdapter(arrayAdapter);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reminders, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new:
                Log.d(getLocalClassName(), "create new Reminder");
                return true;
            case R.id.action_exit:
                Log.d(getLocalClassName(), "exit App");
                finish();
                return true;
            default:
                return false;
        }

    }
}
