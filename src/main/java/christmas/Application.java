package christmas;

import christmas.controller.WoowaChristmasPromotionController;

public class Application {
    public static void main(String[] args) {
        WoowaChristmasPromotionController woowaEvent = new WoowaChristmasPromotionController();
        woowaEvent.EventFlow();
    }
}
