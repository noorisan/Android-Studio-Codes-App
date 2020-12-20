package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Hero> list = new ArrayList<>();
    private RecyclerView rvHeroes;
    private String title = "Mode List";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);
        list.addAll(HeroesData.getListData());
        setActionBarTitle(title);
        showRecyclerList();
    }
    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        rvHeroes.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        setActionBarTitle(title);
    }
    private void showRecyclerGrid() {
        rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list);
        rvHeroes.setAdapter(gridHeroAdapter);

        gridHeroAdapter.setOnItemClickCallback(new GridHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });
    }
    private void showRecyclerCardView(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        CardViewHeroAdapter cardViewHeroAdapter = new CardViewHeroAdapter(list);
        rvHeroes.setAdapter(cardViewHeroAdapter);
    }
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
    private void showSelectedHero(Hero hero) {
       if (hero.getName().equals("Spinner")){
           Intent move=new Intent(MainActivity.this,SpinnerWidget.class);
           startActivity(move);
       }else if (hero.getName().equals("a")){
           Intent moveWithData=new Intent(MainActivity.this,DetailIntentActivityWithData.class);
           moveWithData.putExtra(DetailIntentActivityWithData.EXTRA_NAMA,hero.getName());
           moveWithData.putExtra("pic",hero.getPhoto());
           startActivity(moveWithData);
       }else if (hero.getName().equals("Auto Complete TextView")){
           Intent move=new Intent(MainActivity.this, AutoCompleteWidget.class);
           startActivity(move);
       }else if (hero.getName().equals("Web View")){
           Intent move=new Intent(MainActivity.this, WebView.class);
           move.putExtra(WebView.EXTRA_URL,"https://github.com/noorisan/Android-Studio-Codes-App");
           startActivity(move);
       }else if (hero.getName().equals("Linnier Layout")) {
           Intent move = new Intent(MainActivity.this, LinnierActivity.class);
           startActivity(move);
       }else if (hero.getName().equals("Progress Bar")) {
           Intent move = new Intent(MainActivity.this, ProgressBar.class);
           startActivity(move);
       }else if (hero.getName().equals("Map View")) {
           Intent move = new Intent(MainActivity.this, MapView.class);
           startActivity(move);
       }
        //Toast.makeText(this, "Kamu memilih " + hero.getName(), Toast.LENGTH_SHORT).show();

    }
}