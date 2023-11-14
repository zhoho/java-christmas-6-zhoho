package christmas.model;

public class Event {
    public static boolean benefitProduct() {
        if(Calculate.getOriginTotalPrice() >= 120000) {
            return true;
        }
        return false;
    }


}
