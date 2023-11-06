package kamalMakarimJBusRD;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable
{
    public String email;
    public String name;
    public String password;
    public static final  String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+(\\.[A-Za-z]+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])\\S{8,}$";


    public Account (String name, String email, String password){
        super();
        this.name = name;
        this.email= email;
        this.password = password;
    }
    
    public String toString(){
        return "AccountId: " + id + "\temail: " + email + "\tname: " + name + "\tpassword: " + password;
    }

    public boolean validate(){
        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Pattern passwordPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher emailMatcher = emailPattern.matcher(REGEX_EMAIL);
        Matcher passwordMatcher = passwordPattern.matcher(REGEX_PASSWORD);
        return emailMatcher.find() && passwordMatcher.find();
    }
}