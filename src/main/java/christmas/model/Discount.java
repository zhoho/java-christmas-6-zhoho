package christmas.model;

import christmas.constant.Numbers;
import christmas.view.OutputView;

import java.util.ArrayList;

public class Discount {

    private static int visitDate;
    static int TotalBenefit;
    static int givingMenuDiscount;
    static int weekDiscount;
    static int weekendDiscount;
    static int specialDiscount;
    static int christmasDdayDiscount;
    static ArrayList<String> Benefits = new ArrayList<>();

    public enum PrintBenefits {
        CHISTMASDDAYDISCOUNT("크리스마스 디데이 할인: -"),
        WEEKDAYDISCOUNT("평일 할인: -"),
        WEEKENDDISCOUNT("주말 할인: -"),
        SPECIALDISCOUNT("특별 할인: -"),
        GIVINGEVENT("증정 이벤트: -"),
        ;
        private final String label;

        PrintBenefits(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }
    public static int calculateChristmasDdayDiscount() {
        if(visitDate < Numbers.CHRISTMASDDAYEND) {
            int christmasDdayDiscount = Numbers.CHRISTMASDDAYSTARTING;
            christmasDdayDiscount += visitDate * Numbers.CHRISTMASDDAYEVENT;
            Benefits.add(PrintBenefits.CHISTMASDDAYDISCOUNT.label() + OutputView.formatChanger(christmasDdayDiscount) + OutputView.PrintOutputMessage.WON.label());
            return christmasDdayDiscount;
        }
        return Numbers.ZERO;
    }

    public static int calculateWeekDiscount() {
     if (visitDate % Numbers.WEEK == Numbers.THREE || visitDate % Numbers.WEEK == Numbers.FOUR || visitDate % Numbers.WEEK == Numbers.FIVE || visitDate % Numbers.WEEK == Numbers.SIX || visitDate % Numbers.WEEK == Numbers.ZERO) {
         int dessertDiscount = MenuGet.getDessertDiscount();
         Benefits.add(PrintBenefits.WEEKDAYDISCOUNT.label() + OutputView.formatChanger(dessertDiscount) + OutputView.PrintOutputMessage.WON.label());
         return dessertDiscount;
     }
        return Numbers.ZERO;
    }

    public static int calculateWeekendDiscount() {
        if (visitDate % Numbers.WEEK == Numbers.ONE || visitDate % Numbers.WEEK == Numbers.TWO) {
            int mainDiscount = MenuGet.getMainDiscount();
            Benefits.add(PrintBenefits.WEEKENDDISCOUNT.label() + OutputView.formatChanger(mainDiscount) + OutputView.PrintOutputMessage.WON.label());
            return mainDiscount;
        }
        return Numbers.ZERO;
    }

    public static int calculateSpecialDiscount() {
        if (visitDate % Numbers.WEEK == Numbers.THREE || visitDate == Numbers.CHRISTMAS) {
            Benefits.add(PrintBenefits.SPECIALDISCOUNT.label() + OutputView.formatChanger(Numbers.SPECIALDISCOUNT) + OutputView.PrintOutputMessage.WON.label());
            return Numbers.SPECIALDISCOUNT;
        }
        return Numbers.ZERO;
    }

    public static int calculateTotalBenefit() {
        TotalBenefit = Numbers.ZERO;
        givingMenuDiscount = Numbers.ZERO;
        weekDiscount = calculateWeekDiscount();
        weekendDiscount = calculateWeekendDiscount();
        specialDiscount = calculateSpecialDiscount();
        christmasDdayDiscount = calculateChristmasDdayDiscount();

        if(Event.benefitProduct()) {
            givingMenuDiscount = Numbers.CHAMPAGNEPRICE;
        };
        TotalBenefit = givingMenuDiscount + weekDiscount + weekendDiscount + specialDiscount + christmasDdayDiscount;
        return TotalBenefit;
    }

    public static ArrayList<String> checkBenefits() {
        Event.checkBenefitProductExistence();
        return Benefits;
    }

    public static void getVisitDate(int date) {
        visitDate = date;
    }
}