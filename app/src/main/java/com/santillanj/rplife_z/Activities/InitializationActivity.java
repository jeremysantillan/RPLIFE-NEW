package com.santillanj.rplife_z.Activities;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.jackandphantom.blurimage.BlurImage;
import com.santillanj.rplife_z.Models.CharacterParts;
import com.santillanj.rplife_z.R;

import java.util.ArrayList;

import com.santillanj.rplife_z.Adapters.InitializationAdapter;
import com.santillanj.rplife_z.Fonts.CustomTextView;
import com.santillanj.rplife_z.Interfaces.InitializationRecyclerListener;
import com.santillanj.rplife_z.Models.InitializationType;

public class InitializationActivity extends AppCompatActivity implements InitializationRecyclerListener, View.OnClickListener {

    private ImageView mImgInitTypeLogo;
    private ImageView mImgInitTypeHeader;
    private CustomTextView mTxtInitTypeName;
    private CustomTextView mTxtInitTypeDesc;
    private Button mBtnSelectType;
    private RecyclerView mRecyclerInitTypes;
    private ArrayList<InitializationType> initTypesList;

    private static final String TAG = "InitActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialization);

        mImgInitTypeLogo = findViewById(R.id.mImgInitializationLogo);
        mImgInitTypeHeader = findViewById(R.id.mImgInitializationHeader);
        mTxtInitTypeName = findViewById(R.id.mTxtInitializationName);
        mTxtInitTypeDesc = findViewById(R.id.mTxtInitializationDesc);
        mBtnSelectType = findViewById(R.id.mBtnSelectType);
        mBtnSelectType.setOnClickListener(this);
        mRecyclerInitTypes = findViewById(R.id.mRecyclerInitialization);

        //initial logo

        setStuff(new InitializationType(getString(R.string.type_elima_name), getString(R.string.type_elima_desc), R.drawable.img_elima_logo_new, R.color.colorTxtElimaStart, R.color.colorTxtElimaEnd));

        //set delay before setting up recycler
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setUpRecycler();
            }
        }, 500);
    }

    private void setStuff(InitializationType intType) {
        BlurImage.with(getApplicationContext()).load(intType.getTypeImgID()).intensity(5).Async(true).into(mImgInitTypeHeader);

        Glide.get(InitializationActivity.this).clearMemory();
        Glide.with(mImgInitTypeLogo.getContext()).load(intType.getTypeImgID()).transition(GenericTransitionOptions.with(android.R.anim.fade_in)).into(mImgInitTypeLogo);
        mTxtInitTypeName.setText(intType.getTypeName());
        mTxtInitTypeDesc.setText(intType.getTypeDesc());

        //setGradient
        mTxtInitTypeName.getPaint().setShader(new LinearGradient(0,0,0,mTxtInitTypeName.getLineHeight(), getResources().getColor(intType.getColorStart()), getResources().getColor(intType.getColorEnd()), Shader.TileMode.REPEAT));

    }

    private void setUpRecycler() {
        initTypesList = new ArrayList<>();
        initTypesList.add(new InitializationType(getString(R.string.type_elima_name), getString(R.string.type_elima_desc), R.drawable.img_elima_logo_new, R.color.colorTxtElimaStart, R.color.colorTxtElimaEnd));
        initTypesList.add(new InitializationType(getString(R.string.type_erudite_name), getString(R.string.type_erudite_desc), R.drawable.img_erudite_logo_new, R.color.colorTxtEruditeStart, R.color.colorTxtEruditeEnd));
        initTypesList.add(new InitializationType(getString(R.string.type_locked_name), getString(R.string.type_locked_desc), R.drawable.img_initialization_locked_1, R.color.coloredTxt_1_Start, R.color.coloredTxt_1_End));
        initTypesList.add(new InitializationType(getString(R.string.type_locked_name), getString(R.string.type_locked_desc), R.drawable.img_initialization_locked_2, R.color.coloredTxt_2_Start, R.color.coloredTxt_2_End));
        initTypesList.add(new InitializationType(getString(R.string.type_locked_name), getString(R.string.type_locked_desc), R.drawable.img_initialization_locked_3, R.color.coloredTxt_3_Start, R.color.coloredTxt_3_End));

        mRecyclerInitTypes.setLayoutManager(new LinearLayoutManager(InitializationActivity.this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerInitTypes.setAdapter(new InitializationAdapter(initTypesList, this));
        mRecyclerInitTypes.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
    }


    @Override
    public void onInitRecyclerItemClick(InitializationType initType) {
        if (initType != null) {
            Log.d(TAG, "onInitRecyclerItemClick: " + initType.getTypeName());
            setStuff(initType);
        } else {
            Log.d(TAG, "onInitRecyclerItemClick Called! Item is NULL");
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mBtnSelectType:
                startActivity(new Intent(InitializationActivity.this, CharacterCreationActivity.class));
                break;
        }
    }
}
