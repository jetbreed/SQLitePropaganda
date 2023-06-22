package com.jetbreed.sqlitepropaganda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.view.View;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText movie_name;
    EditText year;
    EditText duration;
    RatingBar ratingBar;
    RadioButton pythonMovie, reactMovie;
    RadioButton female;
    RadioButton male;
    CheckBox mssqlMovie, javaMovie;
    Button btnSave, btnAdd;
    MoviewReview moviereview;

//    String strRatingBar;
    int intDuration;
    int intYear;

    DatabaseAccessModifier databaseAccessModifier;

    ArrayAdapter arrayAdapter;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movie_name = findViewById(R.id.movie_name);
        year = findViewById(R.id.year);
        duration = findViewById(R.id.duration);
        ratingBar = findViewById(R.id.ratingBar);
        pythonMovie = findViewById(R.id.pythonMovie);
        reactMovie = findViewById(R.id.reactMovie);
        female = findViewById(R.id.female);
        male = findViewById(R.id.male);
        mssqlMovie = findViewById(R.id.mssqlMovie);
        javaMovie = findViewById(R.id.javaMovie);
        btnSave = findViewById(R.id.btnSave);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        databaseAccessModifier = new DatabaseAccessModifier(this);

        arrayAdapter = new ArrayAdapter<MoviewReview>(MainActivity.this, android.R.layout.simple_list_item_1, databaseAccessModifier.getResultList());
        listView.setAdapter(arrayAdapter);

        btnSave.setOnClickListener(view -> {

            try {

                intYear = Integer.parseInt(year.getText().toString());
                intDuration = Integer.parseInt(duration.getText().toString());

                moviereview =
                        new MoviewReview(
                                -1,
                                movie_name.getText().toString(),
                                pythonMovie.getText().toString(),
                                reactMovie.getText().toString(),
                                mssqlMovie.getText().toString(),
                                javaMovie.getText().toString(),
                                intYear,
                                intDuration,
                                ratingBar.getRating(),
                                female.getText().toString(),
                                male.getText().toString()
                        );

                DatabaseAccessModifier databaseAccessModifier = new DatabaseAccessModifier(MainActivity.this);

                boolean success = databaseAccessModifier.addOne(moviereview);

                Toast.makeText(MainActivity.this,
                        "Data Saved!!!" + success, Toast.LENGTH_SHORT).show();

                arrayAdapter = new ArrayAdapter<MoviewReview>(MainActivity.this, android.R.layout.simple_list_item_1, databaseAccessModifier.getResultList());
                listView.setAdapter(arrayAdapter);
            }
            catch (Exception ex) {
                Toast.makeText(this, "Missing Inputs", Toast.LENGTH_SHORT).show();
            }
        });

        btnAdd.setOnClickListener(view -> {
            databaseAccessModifier = new DatabaseAccessModifier(MainActivity.this);
            List<MoviewReview> allMembers = databaseAccessModifier.getResultList();

            arrayAdapter = new ArrayAdapter<MoviewReview>(MainActivity.this, android.R.layout.simple_list_item_1, databaseAccessModifier.getResultList());
            listView.setAdapter(arrayAdapter);

            Toast.makeText(MainActivity.this, allMembers.toString(), Toast.LENGTH_SHORT).show();
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MoviewReview clickedMember = (MoviewReview) adapterView.getItemAtPosition(i);
                databaseAccessModifier.deleteOne(clickedMember);
                arrayAdapter = new ArrayAdapter<MoviewReview>(MainActivity.this, android.R.layout.simple_list_item_1, databaseAccessModifier.getResultList());
                listView.setAdapter(arrayAdapter);
                Toast.makeText(MainActivity.this, "Deleted " + clickedMember.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}