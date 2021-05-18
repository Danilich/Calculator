package com.company.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {


public static boolean isDigits(String name){
    String regex = "((\\b([1-9 ]|10)\\b)\\s?+[\\\\+\\-*/]{1}(\\b([1-9 ]|10)\\b)\\s?+)+([\\\\+\\-*/]{1}(\\b([1-9 ]|10)\\b)\\s?+)*";
    Pattern p = Pattern.compile(regex);
    if (name == null) {
        return false;
    }
    Matcher m = p.matcher(name);
    return m.matches();
}
    public static boolean isRoman(String name)
    {
        String regex = "([XVI ]+[\\\\+\\-*/]{1}[XVI ]+)+([\\\\+\\-*/]{1}[XVI ]+)*";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);
        return m.matches();
    }

}
