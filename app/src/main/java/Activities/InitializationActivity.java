package Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;

import com.jackandphantom.blurimage.BlurImage;
import com.santillanj.rplife_z.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Adapters.InitializationAdapter;
import Fonts.CustomGradientTextView;
import Fonts.CustomTextView;

public class InitializationActivity extends AppCompatActivity {

    private ImageView mImgInitTypeLogo;
    private ImageView mImgInitTypeHeader;
    private CustomGradientTextView mTxtInitTypeName;
    private CustomTextView mTxtInitTypeDesc;
    private Button mBtnSelectType;
    private RecyclerView mRecyclerInitTypes;
    private ArrayList<String> initTypesList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialization);

        mImgInitTypeLogo = findViewById(R.id.mImgInitializationLogo);
        mImgInitTypeHeader = findViewById(R.id.mImgInitializationHeader);
        mTxtInitTypeName = findViewById(R.id.mTxtInitializationName);
        mTxtInitTypeDesc = findViewById(R.id.mTxtInitializationDesc);
        mBtnSelectType = findViewById(R.id.mBtnSelectType);
        mRecyclerInitTypes = findViewById(R.id.mRecyclerInitialization);




        blurImage();
        setUpRecycler();
    }




    private void blurImage(){
        BlurImage.with(getApplicationContext()).load(R.drawable.img_elima_logo_new).intensity(5).Async(true).into(mImgInitTypeHeader);
    }

    private void setUpRecycler(){

     initTypesList = new ArrayList<>();

        initTypesList.add(getString(R.string.type_elima));
        initTypesList.add(getString(R.string.type_erudite));
        initTypesList.add(getString(R.string.type_locked_1));
        initTypesList.add(getString(R.string.type_locked_2));
        initTypesList.add(getString(R.string.type_locked_3));

        mRecyclerInitTypes.setLayoutManager(new LinearLayoutManager(InitializationActivity.this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerInitTypes.setAdapter(new InitializationAdapter(initTypesList));

        int resId = R.anim.layout_slide_from_right;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, resId);
        mRecyclerInitTypes.setLayoutAnimation(animation);
    }




}
