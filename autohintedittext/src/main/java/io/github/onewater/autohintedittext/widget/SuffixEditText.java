package io.github.onewater.autohintedittext.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by ONEWateR on 2016/3/12.
 */
public class SuffixEditText extends EditText {

    protected ColorStateList mSuffixTextColor;

    protected String mSuffix = "";

    private int mPaintAlpha = 255;

    public SuffixEditText(Context context) {
        super(context);
    }

    public SuffixEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SuffixEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mSuffix != null && getText().length() > 0) {
            Paint mPaint = getPaint();
            mPaint.setColor(mSuffixTextColor.getColorForState(getDrawableState(), 0));
            mPaint.setAlpha(mPaintAlpha);
            int lineBaseline = getLineBounds(0, null);

            canvas.drawText(mSuffix,
                    getPaint().measureText(getText().toString()) + getPaddingLeft(),
                    canvas.getClipBounds().top + lineBaseline,
                    mPaint);
        }
    }

    public void setSuffixTextAlpha(int paintAlpha) {
        mPaintAlpha = paintAlpha;
    }

    public void setSuffixTextColor(ColorStateList suffixTextColor) {
        mSuffixTextColor = suffixTextColor;
    }

    public void setSuffix(String suffix) {
        mSuffix = suffix;
        invalidate();
    }

}
