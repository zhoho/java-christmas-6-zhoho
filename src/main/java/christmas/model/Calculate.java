package christmas.model;

import christmas.constant.Constants;
import christmas.constant.ErrorMessage;
import christmas.constant.Numbers;

public class Calculate {
    static int originTotalPrice = Numbers.ZERO;
    public static void getOriginTotalPrice(String itemMenu, int quantity) {
        try {
            int price = Constants.getPriceForMenu(itemMenu);
            originTotalPrice += price * quantity;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.PrintErrorMessage.INVAILDMENU.label());
        }
    }

    public static int getOriginTotalPrice() {
        return originTotalPrice;
    }
}


