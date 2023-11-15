package christmas.model;

import christmas.view.OutputView;

public class Event {
    public static boolean benefitProduct() {
        if(Calculate.getOriginTotalPrice() >= 120000) {
            return true;
        }
        return false;
    }
    public static int benefitProductExistence() {
        if(benefitProduct()) {
            return 25000;
        }
        return 0;
    }

    public static void checkBenefitProductExistence() {
        if(benefitProduct()) {
            Discount.Benefits.add("증정 이벤트: -"+ OutputView.formatChanger(25000) + "원");
        }
    }

    public static void checkEventPossibility() {

    }
}
