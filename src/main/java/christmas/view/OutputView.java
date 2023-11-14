package christmas.view;

import christmas.model.Calculate;
import christmas.model.Discount;
import christmas.model.Event;

import java.text.DecimalFormat;

public class OutputView {
    static int originPrice;
    static int calculateTotalBenefit;
    public static void printWelcomeToEvent() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printShowDateOfEvent(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    public static void printMenuSetting() {
        System.out.println("<주문 메뉴>");
    }
    public static void printMenu(String itemName, int quantity) {
        System.out.println(itemName + " " + quantity + "개");
    }

    public static void printoriginTotalPrice() {
        String originTotalPrice = totalPriceFormat();
        System.out.println("\n<할인 전 총주문 금액>\n" + originTotalPrice + "원");
    }

    public static String totalPriceFormat() {
        originPrice = Calculate.getOriginTotalPrice();
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String originTotalPrice = decimalFormat.format(originPrice);
        return originTotalPrice;
    }

    public static void printBenefitProduct() {
        String givingMenu = "없음";
        if(Event.benefitProduct()) {
            givingMenu = "샴페인 1개";
        };
        System.out.println("\n<증정 메뉴>\n"+givingMenu);
    }

    public static void printBenefitList() {
        System.out.println("\n<혜택 내역>\n"+Discount.checkBenefits());
    }

    public static void printTotalExpectedPrice() {
        int num = originPrice - calculateTotalBenefit + Event.benefitProductExistence();
        String totalExpectedPrice = formatChanger(num);
        System.out.println("\n<할인 후 예상 결제 금액>\n" + totalExpectedPrice +"원");
    }

    public static void printTotalBenefit() {
        String totalBenefit = formatChanger(calculateTotalBenefit);
        System.out.println("\n<총혜택 금액>\n-" + totalBenefit + "원");
    }

    public static void getCalculateTotalBenefit() {
        calculateTotalBenefit = Discount.calculateTotalBenefit();
    }
    public static String formatChanger(int num) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String originTotalPrice = decimalFormat.format(num);
        return originTotalPrice;
    }
}