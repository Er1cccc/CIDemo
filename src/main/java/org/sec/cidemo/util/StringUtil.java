package org.sec.cidemo.util;

import org.apache.commons.lang.StringEscapeUtils;

public class StringUtil {
    public static String clean(String input){
        return StringEscapeUtils.escapeHtml(input);
    }
}
