package org.telegram.messenger;

import android.content.Context;

public class AndroidUtilities {
    public static float screenRefreshRate = 60;
    public static int dp(Context context, float value) {
        if (value == 0) {
            return 0;
        }
        return (int) Math.ceil(context.getResources().getDisplayMetrics().density * value);
    }
}
