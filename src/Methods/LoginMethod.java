package Methods;

import java.util.HashMap;

public class LoginMethod {
    public static boolean checkUser(String username, String password, HashMap<String, String> users) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        }
        return false;
    }
    public static int rateChecker(int mts, int farerate, int fareRate2, int fareRate3) {
        if (mts < 5) {
            return mts * farerate;
        } else if (mts <= 10) { // Adjusted condition to include 5-10 km range
            return mts * fareRate2;
        } else { // Handle distance greater than 10 km
            return mts * fareRate3;
        }
    }
}
