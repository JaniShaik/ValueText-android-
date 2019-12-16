package com.itcrats.valuetext.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;

import java.util.Map;

import es.dmoral.toasty.Toasty;

/**
 * Created by JANI SHAIK on 14/11/2019
 */

public class Utils {
    /**
     * MIME Types
     */
    public static String[] getMIMETypes() {
        String[] mime_types = {"image/*", "application/msword", "application/pdf",
                "application/vnd.oasis.opendocument.text", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"};
        return mime_types;
    }

    public static Boolean stringNotNullOrEmpty(String checkString) {
        if (checkString != null && !checkString.isEmpty() && !checkString.equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }

    public static SpannableString returnSpannableString(String normalString) {
        SpannableString spannableString = new SpannableString(normalString);
        ForegroundColorSpan foregroundSpan = new ForegroundColorSpan(Color.RED);
        spannableString.setSpan(foregroundSpan, spannableString.length() - 1, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

    // Server Error
    public static void serverError(Context mContext, int code) {
        switch (code) {
            case 404:
                Toasty.error(mContext, "Not Found", Toast.LENGTH_SHORT).show();
                break;
            case 500:
                Toasty.error(mContext, "Server broken", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toasty.error(mContext, "Unknown error", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
