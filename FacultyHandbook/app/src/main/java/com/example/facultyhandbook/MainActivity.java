package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Handler;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    ImageView getSearch;
    EditText edtSearch;
    ImageView dropdown;
    SharedPreferences mPreferences;
    CardView science, commerce, engineering, health, humanities;
    CardView year2019,year2018,year2017, year2016;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        getSearch = findViewById(R.id.get_search);
        edtSearch = findViewById(R.id.edtSearch);
        dropdown = findViewById(R.id.dropdown);

        science = findViewById(R.id.science);
        commerce = findViewById(R.id.commerce);
        engineering = findViewById(R.id.engineering);
        health = findViewById(R.id.health);
        humanities = findViewById(R.id.humanity);

        year2019 = findViewById(R.id.year2019);
        year2018 = findViewById(R.id.year2018);
        year2017 = findViewById(R.id.year2017);
        year2016 = findViewById(R.id.year2016);


        year2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), PreviousRulesActivity.class);
                intent.putExtra("year","2019");
                startActivity(intent);

            }
        });

        year2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), PreviousRulesActivity.class);
                intent.putExtra("year","2018");
                startActivity(intent);

            }
        });

        year2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), PreviousRulesActivity.class);
                intent.putExtra("year","2017");
                startActivity(intent);

            }
        });

        year2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), PreviousRulesActivity.class);
                intent.putExtra("year","2016");
                startActivity(intent);

            }
        });

        getSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtSearch.setVisibility(View.VISIBLE);
            }
        });

        edtSearch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                edtSearch.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ScienceActivity.class);
                startActivity(intent);
            }
        });

        commerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CommerceActivity.class);
                startActivity(intent);
            }
        });
        engineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EngineeringActivity.class);
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthActivity.class);
                startActivity(intent);
            }
        });

        humanities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HumanitiesActivity.class);
                startActivity(intent);
            }
        });


        dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), dropdown);
                dropDownMenu.getMenuInflater().inflate(R.menu.dropdown_menu, dropDownMenu.getMenu());
                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){

                            case R.id.locations:
                                Intent intent = new Intent(getApplicationContext(), FacultyLocationActivity.class);
                                startActivity(intent);
                                return true;

                            case R.id.governance:
                                Intent intent2 = new Intent(getApplicationContext(), GovernanceActivity.class);
                                startActivity(intent2);
                                return true;

                            case R.id.content:
                                Intent intent3 = new Intent(getApplicationContext(), AppContentActivity.class);
                                startActivity(intent3);
                                return true;

                            case R.id.settings:
                                Intent intent4 = new Intent(getApplicationContext(), CurriculaActivity.class);
                                startActivity(intent4);

                                return true;
                            case R.id.logout:
                        /*        mPreferences = getSharedPreferences("CurrentUser", MODE_PRIVATE);
                                SharedPreferences.Editor editor=mPreferences.edit();
                                editor.remove("Email");
                                editor.remove("PassWord");
                                editor.commit();
                                Message myMessage=new Message();
                                myMessage.obj="NOTSUCCESS";
                                //handler.sendMessage(myMessage);
                                finish();*/

                                return true;

                            default:
                                //return super.onMenuItemSelected(menuItem);
                        }
                        // Toast.makeText(getApplicationContext(), "You have clicked " + menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                dropDownMenu.show();
            }
        });

    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}
