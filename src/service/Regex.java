package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static Pattern pattern;
    private static Pattern pattern1;
    private static Pattern pattern2;
    private Matcher matcher;
    private static final String string =   "^[A-Za-z0-9\n]+$";
    private static final String number =   "^[0-9]*$";
    private static final String email =  "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public Regex() {
        pattern = Pattern.compile(string);
        pattern1 = Pattern.compile(number);
        pattern2 = Pattern.compile(email);
        
    }
    public boolean string(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean email(String regex) {
        matcher = pattern2.matcher(regex);
        return matcher.matches();
    }
    public boolean number1(String regex) {
        matcher = pattern1.matcher(regex);
        return matcher.matches();
    }
}
