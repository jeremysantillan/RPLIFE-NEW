package com.santillanj.rplife_z.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.santillanj.rplife_z.Adapters.CharacterCreationAdapter;
import com.santillanj.rplife_z.Adapters.CustomViewPager;
import com.santillanj.rplife_z.Adapters.ViewPagerAdapter;
import com.santillanj.rplife_z.Fragments.CharPartFragment;
import com.santillanj.rplife_z.Models.CharacterParts;
import com.santillanj.rplife_z.R;

import java.util.ArrayList;

public class CharacterCreationActivity extends AppCompatActivity {

    private RecyclerView mRecyclerChar;
    private NavigationTabStrip mCharNavStrip;
    private CustomViewPager mCharViewPager;

    private ArrayList<CharacterParts> charFaceList;
    private ArrayList<CharacterParts> charHairList;
    private ArrayList<CharacterParts> charBodyList;
    private ArrayList<CharacterParts> charClothesList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);

        mCharViewPager = findViewById(R.id.mCharViewPager);
        mCharNavStrip = findViewById(R.id.mNavTabStrip);

        setCharFaceList();
        setCharHairList();
        setCharBodyList();
        setCharClothesList();
        setupViewPager(mCharViewPager);

    }

    private void setCharFaceList()
    {
        charFaceList = new ArrayList<>();
        charFaceList.add(new CharacterParts(null, getString(R.string.type_char_face), null, R.drawable.img_faces_1));
        charFaceList.add(new CharacterParts(null, getString(R.string.type_char_face), null, R.drawable.img_faces_2));
        charFaceList.add(new CharacterParts(null, getString(R.string.type_char_face), null, R.drawable.img_faces_3));
        charFaceList.add(new CharacterParts(null, getString(R.string.type_char_face), null, R.drawable.img_faces_4));
        charFaceList.add(new CharacterParts(null, getString(R.string.type_char_face), null, R.drawable.img_faces_5));
        charFaceList.add(new CharacterParts(null, getString(R.string.type_char_face), null, R.drawable.img_faces_6));
        charFaceList.add(new CharacterParts(null, getString(R.string.type_char_face), null, R.drawable.img_faces_7));
        charFaceList.add(new CharacterParts(null, getString(R.string.type_char_face), null, R.drawable.img_faces_8));
    }

    private void setCharHairList()
    {
        charHairList = new ArrayList<>();
        charHairList.add(new CharacterParts(null, getString(R.string.type_char_hair), null, R.drawable.img_hair_1));
        charHairList.add(new CharacterParts(null, getString(R.string.type_char_hair), null, R.drawable.img_hair_2));
        charHairList.add(new CharacterParts(null, getString(R.string.type_char_hair), null, R.drawable.img_hair_3));
        charHairList.add(new CharacterParts(null, getString(R.string.type_char_hair), null, R.drawable.img_hair_4));
        charHairList.add(new CharacterParts(null, getString(R.string.type_char_hair), null, R.drawable.img_hair_5));
        charHairList.add(new CharacterParts(null, getString(R.string.type_char_hair), null, R.drawable.img_hair_6));
        charHairList.add(new CharacterParts(null, getString(R.string.type_char_hair), null, R.drawable.img_hair_7));
        charHairList.add(new CharacterParts(null, getString(R.string.type_char_hair), null, R.drawable.img_hair_8));
    }

    private void setCharBodyList()
    {
        charBodyList = new ArrayList<>();
        charBodyList.add(new CharacterParts(null, getString(R.string.type_char_body), null, R.drawable.img_char_locked));
        charBodyList.add(new CharacterParts(null, getString(R.string.type_char_body), null, R.drawable.img_char_locked));
        charBodyList.add(new CharacterParts(null, getString(R.string.type_char_body), null, R.drawable.img_body_1));
        charBodyList.add(new CharacterParts(null, getString(R.string.type_char_body), null, R.drawable.img_body_2));
        charBodyList.add(new CharacterParts(null, getString(R.string.type_char_body), null, R.drawable.img_body_3));
        charBodyList.add(new CharacterParts(null, getString(R.string.type_char_body), null, R.drawable.img_char_locked));
        charBodyList.add(new CharacterParts(null, getString(R.string.type_char_body), null, R.drawable.img_char_locked));
        charBodyList.add(new CharacterParts(null, getString(R.string.type_char_body), null, R.drawable.img_char_locked));
        charBodyList.add(new CharacterParts(null, getString(R.string.type_char_body), null, R.drawable.img_char_locked));
    }


    private void setCharClothesList()
    {
        charClothesList = new ArrayList<>();
        charClothesList.add(new CharacterParts(null, getString(R.string.type_char_clothes), null, R.drawable.img_char_locked));
        charClothesList.add(new CharacterParts(null, getString(R.string.type_char_clothes), null, R.drawable.img_char_locked));
        charClothesList.add(new CharacterParts(null, getString(R.string.type_char_clothes), null, R.drawable.img_clothes_1));
        charClothesList.add(new CharacterParts(null, getString(R.string.type_char_clothes), null, R.drawable.img_clothes_2));
        charClothesList.add(new CharacterParts(null, getString(R.string.type_char_clothes), null, R.drawable.img_clothes_3));
        charClothesList.add(new CharacterParts(null, getString(R.string.type_char_clothes), null, R.drawable.img_char_locked));
        charClothesList.add(new CharacterParts(null, getString(R.string.type_char_clothes), null, R.drawable.img_char_locked));
        charClothesList.add(new CharacterParts(null, getString(R.string.type_char_clothes), null, R.drawable.img_char_locked));

    }



    private void setupViewPager(CustomViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new CharPartFragment().newInstance(charFaceList), getString(R.string.type_char_face));
        adapter.addFragment(new CharPartFragment().newInstance(charHairList), getString(R.string.type_char_hair));
        adapter.addFragment(new CharPartFragment().newInstance(charBodyList), getString(R.string.type_char_body));
        adapter.addFragment(new CharPartFragment().newInstance(charClothesList), getString(R.string.type_char_clothes));

        viewPager.setAdapter(adapter);
        viewPager.setPagingEnabled(false);

        mCharNavStrip.setViewPager(viewPager,0);
        mCharNavStrip.setTitles(getString(R.string.type_char_face), getString(R.string.type_char_hair), getString(R.string.type_char_body), getString(R.string.type_char_clothes));
    }


}
