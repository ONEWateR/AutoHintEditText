package io.github.onewater.autohintedittext;

import android.support.annotation.ArrayRes;

import java.util.HashMap;

import io.github.onewater.autohintedittext.widget.AutoHintEditText;

/**
 * Created by ONEWateR on 2016/3/12.
 */
public class EmailHintWatcher extends HintWatcher {

    private String[] mSuffixData = new String[0];

    private HashMap<String, String> mSuffixMap = new HashMap<>();

    public EmailHintWatcher(AutoHintEditText editText) {
        super(editText);
    }

    public void setSuffixData(@ArrayRes int resId) {
        mSuffixData = mEditText.getResources().getStringArray(resId);
        createSuffixMap();
    }

    public void setSuffixData(String[] array) {
        mSuffixData = array;
        createSuffixMap();
    }

    void createSuffixMap() {
        for (int i = 0; i < mSuffixData.length; i++) {
            String value = mSuffixData[i];
            for (int j = 2; j < value.length(); j++) {
                mSuffixMap.put(value.substring(1, j), value.substring(j, value.length()));
            }
        }
    }

    public void check(final String s) {
        int atIndex = s.indexOf('@');
        if (atIndex != -1) {
            String suffix = s.substring(atIndex + 1);
            setSuffix(mSuffixMap.containsKey(suffix) ? mSuffixMap.get(suffix) : "");
        } else {
            setSuffix("");
        }
    }


}
