package utilities;

public class StringUtility {

    public static void verifyEquals(String expected, String actual){
        if(expected.equalsIgnoreCase(actual)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
    }
}
