package christmas.controller;

import christmas.model.Discount;
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
        OutputView.printBenefitProduct();
        Discount.getVisitDate(visitDate);
        OutputView.CalculateTotalBenefit();
        OutputView.printBenefits();
        OutputView.printTotalBenefit();
        OutputView.printTotalExpectedPrice();
        OutputView.printEventBadge();
    }
}
