package christmas.model;

import christmas.constant.Numbers;
import christmas.view.OutputView;

public class Event {
    public static boolean benefitProduct() {
        if(Calculate.getOriginTotalPrice() >= Numbers.CHAMPAGNELINE) {
            return true;
        }
        return false;
    }
    public static int benefitProductExistence() {
        if(benefitProduct()) {
            return Numbers.CHAMPAGNEPRICE;
        }
        return Numbers.ZERO;
    }

    public static void checkBenefitProductExistence() {
        if(benefitProduct()) {
            Discount.Benefits.add(Discount.PrintBenefits.GIVINGEVENT.label() + OutputView.formatChanger(Numbers.CHAMPAGNEPRICE) + OutputView.PrintOutputMessage.WON.label());
        }
    }
}
