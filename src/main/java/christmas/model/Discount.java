package christmas.model;

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
    public static int calculateChristmasDdayDiscount() {
        if(visitDate < 26) {
            int christmasDdayDiscount = 900;
            christmasDdayDiscount += visitDate * 100;
            Benefits.add("크리스마스 디데이 할인: -"+ OutputView.formatChanger(christmasDdayDiscount) + "원");
            return christmasDdayDiscount;
        }
        return 0;
    }

    public static int calculateWeekDiscount() {
     if (visitDate % 7 == 1 || visitDate % 7 == 2) {
         int dessertDiscount = MenuGet.getDessertDiscount();
         Benefits.add("평일 할인: -"+ OutputView.formatChanger(dessertDiscount) + "원");
         return dessertDiscount;
     }
        return 0;
    }

    public static int calculateWeekendDiscount() {
        if (visitDate % 7 == 1 || visitDate % 7 == 2) {
            int mainDiscount = MenuGet.getMainDiscount();
            Benefits.add("주말 할인: -"+ OutputView.formatChanger(mainDiscount) + "원");
            return mainDiscount;
        }
        return 0;
    }

    public static int calculateSpecialDiscount() {
        if (visitDate % 7 == 3 || visitDate == 25) {
            Benefits.add("특별 할인: -"+ OutputView.formatChanger(1000) + "원");
            return 1000;
        }
        return 0;
    }

    public static int calculateTotalBenefit() {
        TotalBenefit = 0;
        givingMenuDiscount = 0;
        weekDiscount = calculateWeekDiscount();
        weekendDiscount = calculateWeekendDiscount();
        specialDiscount = calculateSpecialDiscount();
        christmasDdayDiscount = calculateChristmasDdayDiscount();

        if(Event.benefitProduct()) {
            givingMenuDiscount = 25000;
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