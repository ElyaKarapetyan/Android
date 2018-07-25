package com.example.elya.films;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Film> films = new ArrayList<>();
        initFilmsList(films);

        RecyclerView recyclerView = findViewById(R.id.rv);;
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);;

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(manager);

        RecyclerView.Adapter myAdapter = new CustomAdapter(films, MainActivity.this);

        recyclerView.setAdapter(myAdapter);
    }

    private void initFilmsList(ArrayList<Film> films) {
        films.add(new Film("Avengers", R.drawable.film1, "Infinity War is a 2018 American superhero film based on the Marvel Comics superhero team the Avengers", 5, true, "https://en.wikipedia.org/wiki/Avengers:_Infinity_War"));
        films.add(new Film("Black Panther", R.drawable.film2, "Black Panther is a 2018 American superhero film based on the Marvel Comics character of the same name", 4, false, "https://en.wikipedia.org/wiki/Black_Panther_(film)"));
        films.add(new Film("Jurassic World", R.drawable.film3, "Fallen Kingdom is a 2018 American science fiction adventure film and the sequel to Jurassic World (2015).", 3, true, "https://en.wikipedia.org/wiki/Jurassic_World:_Fallen_Kingdom"));
        films.add(new Film("Incredibles", R.drawable.film4, "Incredibles 2 is a 2018 American 3D computer-animated superhero film", 1, false, "https://en.wikipedia.org/wiki/Incredibles_2"));
        films.add(new Film("Operation Red Sea", R.drawable.film5, "Incredibles 2 is a 2018 American 3D computer-animated superhero film", 1, false,"https://en.wikipedia.org/wiki/Incredibles_2"));
        films.add(new Film("Avengers", R.drawable.film1, "Infinity War is a 2018 American superhero film based on the Marvel Comics superhero team the Avengers", 5, true, "https://en.wikipedia.org/wiki/Avengers:_Infinity_War"));
        films.add(new Film("Black Panther", R.drawable.film2, "Black Panther is a 2018 American superhero film based on the Marvel Comics character of the same name", 4, false, "https://en.wikipedia.org/wiki/Black_Panther_(film)"));
        films.add(new Film("Jurassic World", R.drawable.film3, "Fallen Kingdom is a 2018 American science fiction adventure film and the sequel to Jurassic World (2015).", 3, true, "https://en.wikipedia.org/wiki/Jurassic_World:_Fallen_Kingdom"));
        films.add(new Film("Incredibles", R.drawable.film4, "Incredibles 2 is a 2018 American 3D computer-animated superhero film", 1, false, "https://en.wikipedia.org/wiki/Incredibles_2"));
        films.add(new Film("Operation Red Sea", R.drawable.film5, "Incredibles 2 is a 2018 American 3D computer-animated superhero film", 1, false, "https://en.wikipedia.org/wiki/Operation_Red_Sea"));

    }
}
