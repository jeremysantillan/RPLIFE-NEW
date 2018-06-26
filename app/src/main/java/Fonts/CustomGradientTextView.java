package Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.lightfire.gradienttextcolor.GradientTextView;

/**
 * Created by Jeremy on 6/22/2018.
 */

public class CustomGradientTextView extends GradientTextView {
    public CustomGradientTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/BebasNeue.otf"));
    }
}
