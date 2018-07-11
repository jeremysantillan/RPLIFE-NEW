package com.santillanj.rplife_z.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Jeremy on 6/22/2018.
 */

public class CustomEditText extends EditText {
    public CustomEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/BebasNeue.otf"));
    }
}
