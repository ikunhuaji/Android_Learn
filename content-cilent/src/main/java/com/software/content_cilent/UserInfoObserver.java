package com.software.content_cilent;

import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;

public class UserInfoObserver extends ContentObserver {
    public UserInfoObserver(Handler handler) {
        super(handler);
    }

    @Override
    public void onChange(boolean selfChange) {
//        super.onChange(selfChange);
        Log.i("user_info","数据发生变化");
    }
}
