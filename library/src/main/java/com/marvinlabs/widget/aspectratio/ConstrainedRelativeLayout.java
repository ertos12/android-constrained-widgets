package com.marvinlabs.widget.aspectratio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * A relative layout with a constrained aspect ratio.
 *
 * @author Vincent Mimoun-Prat @ MarvinLabs (www.marvinlabs.com)
 */
public class ConstrainedRelativeLayout extends RelativeLayout implements AspectRatioDelegate.ConstrainedView {

    public ConstrainedRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        aspectRatioDelegate = new AspectRatioDelegate(this, attrs);
    }

    public ConstrainedRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        aspectRatioDelegate = new AspectRatioDelegate(this, attrs);
    }

    public ConstrainedRelativeLayout(Context context) {
        super(context);
        aspectRatioDelegate = new AspectRatioDelegate(this);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        aspectRatioDelegate.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @SuppressLint("WrongCall")
    @Override
    public void callParentOnMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private AspectRatioDelegate aspectRatioDelegate;
}
