package christmas.model;

public class Discount {

    private static int visitDate;

    public static int calculateChristmasDdayDiscount() {
        if(visitDate < 26) {
            int christmasDdayDiscount = 900;
            christmasDdayDiscount += visitDate * 100;
            return christmasDdayDiscount;
        }
        return 0;
    }

    public static int calculateWeekDiscount() {
     if (visitDate % 7 == 1 || visitDate % 7 == 2) {
         return MenuGet.getDessertDiscount();
     }
        return MenuGet.getMainDiscount();
    }

    public static int calculateSpecialDiscount() {
        if (visitDate % 7 == 3 || visitDate == 25) {
            return 1000;
        }
        return 0;
    }

    public static int calculateTotalBenefit() {
        int TotalBenefit = 0;
        int givingMenuDiscount = 0;
        int weekDiscount = calculateWeekDiscount();
        int specialDiscount = calculateSpecialDiscount();
        int christmasDdayDiscount = calculateChristmasDdayDiscount();

        if(Event.benefitProduct()) {
            givingMenuDiscount = 25000;
        };

        TotalBenefit = givingMenuDiscount + weekDiscount + specialDiscount + christmasDdayDiscount;
        return TotalBenefit;
    }

    
    public static void getVisitDate(int date) {
        visitDate = date;
    }
}