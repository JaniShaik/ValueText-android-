package com.itcrats.valuetext.networkInterceptor;

import java.io.IOException;

/**
 * Created by JANI SHAIK on 14/11/2019
 */

public class NoConnectivityException extends IOException {
    public String getMessage() {
        return "No connectivity exception";
    }
}
