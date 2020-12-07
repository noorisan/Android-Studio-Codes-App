package com.example.prototype;

import java.util.ArrayList;

public class HeroesData {
    private static String[] heroNames = {
            "Spinner",
            "Auto Complete TextView",
            "Web View"
    };
    private static String[] heroDetails={
            "Spinner menyediakan cara cepat untuk memilih salah satu dari sekumpulan nilai. Dalam status default, spinner menampilkan nilai yang dipilihnya saat ini.",
            "AutoCompleteTextView adalah widget subclass dari EditText yang berfungsi sebagai auto-complete. Ketika user (pengguna) mengetikan suatu huruf atau  kata di EditText,  maka akan muncul pilihan menu dropdown di bawahnya ,lalu saat kita memilih kata tersebut maka text akan otomatis muncul.",
            "WebView adalah komponen sistem yang dibuat oleh Chrome dan memungkinkan aplikasi Android dapat menampilkan halaman website tanpa harus membuka web browser."
    };
    private static int[] heroesImages = {
            R.drawable.spinner,
            R.drawable.autocomplete,
            R.drawable.webview
    };

    static ArrayList<Hero> getListData() {
        ArrayList<Hero> list = new ArrayList<>();
        for (int position = 0; position < heroNames.length; position++) {
            Hero hero = new Hero();
            hero.setName(heroNames[position]);
            hero.setDetail(heroDetails[position]);
            hero.setPhoto(heroesImages[position]);
            list.add(hero);
        }
        return list;
    }
}
