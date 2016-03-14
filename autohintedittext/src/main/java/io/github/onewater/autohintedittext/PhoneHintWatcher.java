package io.github.onewater.autohintedittext;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import io.github.onewater.autohintedittext.widget.AutoHintEditText;

/**
 * Created by ONEWateR on 2016/3/12.
 */
public class PhoneHintWatcher extends HintWatcher {

    String mPhoneNumber;

    public PhoneHintWatcher(AutoHintEditText autoHintEditText) {
        super(autoHintEditText);

        mPhoneNumber = getPhoneNumber();
    }

    @Override
    public void check(final String s) {
        if (TextUtils.isEmpty(mPhoneNumber)) {
            return;
        }

        if (s.length() >= 3 && mPhoneNumber.startsWith(s)) {
            int a = diff(s, mPhoneNumber);
            if (a != -1) {
                setSuffix(mPhoneNumber.substring(a));
            }
        }
    }

    private String getPhoneNumber(){
        TelephonyManager mTelephonyMgr;
        mTelephonyMgr = (TelephonyManager)  mEditText.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        return mTelephonyMgr.getLine1Number();
    }

}
