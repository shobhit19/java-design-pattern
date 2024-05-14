package seleniumdesignpattern.factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GoogleFactory {

    public static GooglePage get(String language){
        // without java 8
        if(language.equalsIgnoreCase("en")){
            return new GoogleEnglish();
        } else if (language.equalsIgnoreCase("sa")) {
            return new GoogleArabic();
        } else if (language.equalsIgnoreCase("fr")) {
            return new GoogleFrench();
        }
        else {
            System.out.println("Please pass valid language");
        }
       //return null;

        // using java 8

        return  MAP.get(language).get();
    }

    // using java 8

    private static final Supplier<GooglePage> ENG = ()->new GoogleEnglish();
    private static final Supplier<GooglePage> FR = ()->new GoogleFrench();
    private static final Supplier<GooglePage> SA = ()->new GoogleArabic();

    private static final Map<String,Supplier<GooglePage>> MAP = new HashMap<>();

    static {
        MAP.put("ENG",ENG);
        MAP.put("FR",FR);
        MAP.put("SA",SA);
    }
}
