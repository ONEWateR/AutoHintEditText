package io.github.onewater.autohintedittext.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.github.onewater.autohintedittext.HintWatcher;

/**
 * Created by ONEWateR on 2016/3/12.
 */
public class AutoHintEditText extends SuffixEditText implements View.OnFocusChangeListener {

    List<HintWatcher> hintWatcherList = new ArrayList<>();

    public AutoHintEditText(Context context) {
        super(context);

        init(context);
    }

    public AutoHintEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public AutoHintEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        setOnFocusChangeListener(this);
        setSuffixTextColor(getTextColors());
        setSuffixTextAlpha(127);
        addTextChangedListener(new MyTextWatcher());
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            append(mSuffix);
            mSuffix = "";
        }
    }

    public void addHintWatcher(HintWatcher hintWatcher) {
        hintWatcherList.add(hintWatcher);
    }

    class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Nothing
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            for (int i = 0; i < hintWatcherList.size(); i++) {
                hintWatcherList.get(i).check(s.toString());
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            // Nothing
        }

    }

}
