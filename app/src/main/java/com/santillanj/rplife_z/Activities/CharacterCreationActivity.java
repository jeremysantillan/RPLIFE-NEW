package com.santillanj.rplife_z.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.santillanj.rplife_z.Adapters.CharacterCreationAdapter;
import com.santillanj.rplife_z.Models.CharacterParts;
import com.santillanj.rplife_z.R;

import java.util.ArrayList;

public class CharacterCreationActivity extends AppCompatActivity {

    private RecyclerView mRecyclerChar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);

        mRecyclerChar = findViewById(R.id.mCharScrollView);

        ArrayList<CharacterParts> charPartsList = new ArrayList<>();
        charPartsList.add(new CharacterParts(getString(R.string.type_elima_name), getString(R.string.type_char_face), "Test 1", R.drawable.img_char_locked));
        charPartsList.add(new CharacterParts(getString(R.string.type_elima_name), getString(R.string.type_char_face), "Test 1", R.drawable.img_char_locked));
        charPartsList.add(new CharacterParts(getString(R.string.type_elima_name), getString(R.string.type_char_face), "Test 1", R.drawable.img_char_locked));
        charPartsList.add(new CharacterParts(getString(R.string.type_elima_name), getString(R.string.type_char_face), "Test 1", R.drawable.img_char_locked));
        charPartsList.add(new CharacterParts(getString(R.string.type_elima_name), getString(R.string.type_char_face), "Test 1", R.drawable.img_char_locked));
        charPartsList.add(new CharacterParts(getString(R.string.type_elima_name), getString(R.string.type_char_face), "Test 1", R.drawable.img_char_locked));
        charPartsList.add(new CharacterParts(getString(R.string.type_elima_name), getString(R.string.type_char_face), "Test 1", R.drawable.img_char_locked));

        CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());

        mRecyclerChar.setLayoutManager(layoutManager);
        mRecyclerChar.setAdapter(new CharacterCreationAdapter(charPartsList));
        mRecyclerChar.setHasFixedSize(true);
        mRecyclerChar.addOnScrollListener(new CenterScrollListener());

    }
}
