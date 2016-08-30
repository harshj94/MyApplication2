package jain.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements CalendarDatePickerDialogFragment.OnDateSetListener {

    private static final String FRAG_TAG_DATE_PICKER = "fragment_date_picker_name";
    String myapikey;
    EditText date;
    AutoCompleteTextView source, destination;
    Button getAvailability;
    private Drawer result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        source = (AutoCompleteTextView) findViewById(R.id.source);
        destination = (AutoCompleteTextView) findViewById(R.id.destination);
        date = (EditText) findViewById(R.id.date);
        getAvailability = (Button) findViewById(R.id.get);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        source.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, Arrays.asList(getResources().getStringArray(R.array.station_codes))));
        destination.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, Arrays.asList(getResources().getStringArray(R.array.station_codes))));

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Train");
        }

        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withFullscreen(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home").withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName("Play").withIcon(FontAwesome.Icon.faw_gamepad),
                        new PrimaryDrawerItem().withName("Custom").withIcon(FontAwesome.Icon.faw_eye),
                        //add some more items to get a scrolling list
                        new SectionDrawerItem().withName("Section Header"),
                        new SecondaryDrawerItem().withName("Settings").withIcon(FontAwesome.Icon.faw_cog),
                        new SecondaryDrawerItem().withName("Help").withIcon(FontAwesome.Icon.faw_question).withEnabled(false),
                        new SecondaryDrawerItem().withName("Open Source").withIcon(FontAwesome.Icon.faw_github),
                        new SecondaryDrawerItem().withName("Contact").withIcon(FontAwesome.Icon.faw_bullhorn),
                        new SectionDrawerItem().withName("Section Header"),
                        new PrimaryDrawerItem().withName("Custom").withIcon(FontAwesome.Icon.faw_eye),
                        new PrimaryDrawerItem().withName("Custom").withIcon(FontAwesome.Icon.faw_eye)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem instanceof Nameable) {
                            Toast.makeText(MainActivity.this, ((Nameable) drawerItem).getName().getText(MainActivity.this), Toast.LENGTH_SHORT).show();
                        }

                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);

        myapikey = "vdtqp7326";
        getAvailability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(source.getText().toString().equals("") || destination.getText().toString().equals("") || date.getText().toString().equals(""))) {
                    Intent i = new Intent(getApplicationContext(), TrainListActivity.class);
                    String text = source.getText().toString().trim();
                    i.putExtra("Source", text.substring(text.lastIndexOf(" ") + 1));
                    text = destination.getText().toString().trim();
                    i.putExtra("Destination", text.substring(text.lastIndexOf(" ") + 1));
                    i.putExtra("Date", date.getText().toString().trim());
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "One or more fields are empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(MainActivity.this);
                cdp.show(getSupportFragmentManager(), FRAG_TAG_DATE_PICKER);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        String month = "" + (monthOfYear + 1);
        String date_ = "" + dayOfMonth;
        if (monthOfYear < 10) {
            month = "0" + (monthOfYear + 1) + "";
        }
        if (dayOfMonth < 10) {
            date_ = "0" + dayOfMonth + "";
        }
        date.setText(date_ + "-" + month);
    }

    @Override
    public void onBackPressed() {
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
