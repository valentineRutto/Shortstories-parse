package com.moringaschool.shortstories;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class list extends ListActivity {
    List<Stories> story=new ArrayList<Stories>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ParseQuery<Shortstories>  query = new ParseQuery<Shortstories>("shortstories");
        query.findInBackground(new FindCallback<Shortstories>() {
            @Override
            public void done(List<Shortstories> list, ParseException e) {
                if(e !=null){
                    Toast.makeText(com.moringaschool.shortstories.list.this,"Error"+e,Toast.LENGTH_SHORT).show();
                }
                for(Shortstories story:list){
                    Shortstories newStory=new Shortstories();
                    newStory.setCategory(story.getCategory());
                    newStory.setTitle(story.getTitle());
                    story.add("stories",newStory);
                }
                ArrayAdapter<Shortstories> adapter=new ArrayAdapter<Shortstories>(
                        list.this,android.R.layout.simple_list_item_1);
                setListAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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
