package christmas.controller;

import christmas.model.MenuGet;
import christmas.view.InputView;
import christmas.view.OutputView;

public class WoowaChristmasPromotionController {
    public WoowaChristmasPromotionController() {
        OutputView.printWelcomeToEvent();
    }

    public void EventFlow() {
        int visitDate = InputView.readDate();
        String menuOrder = InputView.readMenu();

        OutputView.printShowDateOfEvent(visitDate);
        OutputView.printMenuSetting();

        MenuGet.menuCheck(menuOrder);
        OutputView.printoriginTotalPrice();

    }
}
