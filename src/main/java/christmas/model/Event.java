package christmas.model;

public class Event {
    public static String benefitProduct() {
        if(Calculate.getOriginTotalPrice() >= 120000) {
            return "샴페인 1개";
        }
        return "없음";
    }


}
