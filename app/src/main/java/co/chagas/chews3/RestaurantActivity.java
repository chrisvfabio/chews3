package co.chagas.chews3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import co.chagas.chews3.data.MyDB;


public class RestaurantActivity extends ActionBarActivity {

    EditText nameET, addressET, typeET, commentET;
    Button addBT;
    MyDB dba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        dba = new MyDB(this);
        dba.open();
        nameET = (EditText) findViewById(R.id.nameEditText);
        addressET = (EditText) findViewById(R.id.addressEditText);
        typeET = (EditText) findViewById(R.id.typeEditText);
        commentET = (EditText)findViewById(R.id.commentEditText);
        addBT = (Button) findViewById(R.id.addNewButton);

        addBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    saveItToDB();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

    public void saveItToDB(){
        dba.insertRestaurant(nameET.getText().toString(), addressET.getText().toString(),
                typeET.getText().toString(), commentET.getText().toString());

        dba.close();
        nameET.setText("");
        addressET.setText("");
        typeET.setText("");
        commentET.setText("");

        Intent i = new Intent(RestaurantActivity.this, RestaurantItemFragment.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurant, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_restaurant, container, false);
            return rootView;
        }
    }
}
