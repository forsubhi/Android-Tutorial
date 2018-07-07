package com.example.mohammedsubhi.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by MohammedSubhi on 8/5/2017.
 */
public class CustomTextView  extends TextView{
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface type = Typeface.createFromAsset(getResources().getAssets(),"fonts/Kokila.ttf");
        setTypeface(type);
    }
}
