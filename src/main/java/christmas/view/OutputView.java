package christmas.view;

import christmas.model.Badge;
import christmas.model.Calculate;
import christmas.model.Discount;
import christmas.model.Event;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OutputView {
    static int originPrice;
    static int calculateTotalBenefit;
    private static final String LINE_SEPARATOR = System.lineSeparator();
    public enum PrintOutputMessage {
        PRINTSAYHELLO("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
        PRINTSEETHEEVENT("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
        PRINTORDERMENU("<주문 메뉴>"),
        PRINTTOTALORIGINPRICE("\n<할인 전 총주문 금액>\n"),
        PRINTGIVINGMENU("\n<증정 메뉴>\n"),
        PRINTBENEFITS("\n<혜택 내역>"),
        PRINTEXPECTEDPRICE("\n<할인 후 예상 결제 금액>\n"),
        PRINTTOTALPRICE("\n<총혜택 금액>\n-"),
        PRINTEVENTBADGE("\n<12월 이벤트 배지>\n"),
        DECEMBER("12월 "),
        NUMBEROF("개"),
        WON("원"),
        X("없음"),
        GIVINGMENU("샴페인 1개"),
        FORMAT("#,###"),
        ;
        private final String label;

        PrintOutputMessage(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }

    public static void printWelcomeToEvent() {
        System.out.println(PrintOutputMessage.PRINTSAYHELLO.label());
    }

    public static void printShowDateOfEvent(int date) {
        System.out.println(PrintOutputMessage.DECEMBER.label() + date + PrintOutputMessage.PRINTSEETHEEVENT.label());
    }

    public static void printMenuSetting() {
        System.out.println(PrintOutputMessage.PRINTORDERMENU.label());
    }

    public static void printMenu(String itemName, int quantity) {
        System.out.println(itemName + " " + quantity + PrintOutputMessage.NUMBEROF.label());
    }

    public static void printoriginTotalPrice() {
        String originTotalPrice = totalPriceFormat();
        System.out.println(PrintOutputMessage.PRINTTOTALORIGINPRICE.label() + originTotalPrice + PrintOutputMessage.WON.label());
    }

    public static String totalPriceFormat() {
        originPrice = Calculate.getOriginTotalPrice();
        DecimalFormat decimalFormat = new DecimalFormat(PrintOutputMessage.FORMAT.label());
        String originTotalPrice = decimalFormat.format(originPrice);
        return originTotalPrice;
    }

    public static void printBenefitProduct() {
        String givingMenu = PrintOutputMessage.X.label();
        if(Event.benefitProduct()) {
            givingMenu = PrintOutputMessage.GIVINGMENU.label();
        };
        System.out.println(PrintOutputMessage.PRINTGIVINGMENU.label() + givingMenu);
    }

    public static void printBenefits() {
        ArrayList<String> benefits = Discount.checkBenefits();
        System.out.println(PrintOutputMessage.PRINTBENEFITS.label());
        if(benefits.isEmpty()) {
            benefits.add(PrintOutputMessage.X.label());
        }
        for(String benefit : benefits) {
            System.out.println(benefit);
        }
    }

    public static void printTotalExpectedPrice() {
        int num = originPrice - calculateTotalBenefit + Event.benefitProductExistence();
        String totalExpectedPrice = formatChanger(num);
        System.out.println(PrintOutputMessage.PRINTEXPECTEDPRICE.label() + totalExpectedPrice + PrintOutputMessage.WON.label());
    }

    public static void printTotalBenefit() {
        String totalBenefit = formatChanger(calculateTotalBenefit);
        System.out.println(PrintOutputMessage.PRINTTOTALPRICE.label() + totalBenefit + PrintOutputMessage.WON.label());
    }

    public static void printEventBadge() {
        System.out.println(PrintOutputMessage.PRINTEVENTBADGE.label() + Badge.eventBadge());

    }

    public static void CalculateTotalBenefit() {
        calculateTotalBenefit = Discount.calculateTotalBenefit();
    }

    public static int getCalculateTotalBeneit() {
        return calculateTotalBenefit;
    }
    public static String formatChanger(int num) {
        DecimalFormat decimalFormat = new DecimalFormat(PrintOutputMessage.FORMAT.label());
        String originTotalPrice = decimalFormat.format(num);
        return originTotalPrice;
    }
}