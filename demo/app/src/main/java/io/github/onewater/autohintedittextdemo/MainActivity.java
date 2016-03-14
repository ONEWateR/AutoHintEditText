package io.github.onewater.autohintedittextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.onewater.autohintedittext.EmailHintWatcher;
import io.github.onewater.autohintedittext.PhoneHintWatcher;
import io.github.onewater.autohintedittext.widget.AutoHintEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoHintEditText autoHintEditText = (AutoHintEditText) findViewById(R.id.et_account);

        EmailHintWatcher emailHintWatcher = new EmailHintWatcher(autoHintEditText);
        emailHintWatcher.setSuffixData(R.array.email_suffix_array);
        autoHintEditText.addHintWatcher(emailHintWatcher);

        PhoneHintWatcher phoneHintWatcher = new PhoneHintWatcher(autoHintEditText);
        autoHintEditText.addHintWatcher(phoneHintWatcher);
    }
}
