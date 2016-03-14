# AutoHintEditText
模仿知乎的邮箱输入框，实现自动补全邮箱后缀。
当然还可以进行其他的一个扩展，比如手机号，最近登录账号等。

# Screenshots
![](/pic/pic.png)
![](/pic/demo.gif)

# 引用
```xml
compile 'io.github.onewater:autohintedittext:1.0.1'
```

# 使用

## 基本用法
```xml
    <io.github.onewater.autohintedittext.widget.AutoHintEditText
        android:id="@+id/et_account"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="输入手机号码或邮箱"
        android:imeOptions="actionNext"
        android:singleLine="true" />
```

```java
        AutoHintEditText autoHintEditText = (AutoHintEditText) findViewById(R.id.et_account);

        EmailHintWatcher emailHintWatcher = new EmailHintWatcher(autoHintEditText);
        emailHintWatcher.setSuffixData(R.array.email_suffix_array);
        autoHintEditText.addHintWatcher(emailHintWatcher);
```

## 自定义数据
可以使用string-array或者String[]的方式作为自定义的邮箱后缀数据。
如：
```xml
    <string-array name="email_suffix_array">
        <item>\@yahoo.com</item>
        <item>\@msn.com</item>
        <item>\@hotmail.com</item>
        <item>\@gmail.com</item>
        ......
    </string-array>
```

# License
```
Copyright 2015 ONEWateR

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
