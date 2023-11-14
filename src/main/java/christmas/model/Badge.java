package christmas.model;

import christmas.view.OutputView;

public class Badge {
    public static String eventBadge() {
        if(OutputView.getCalculateTotalBeneit() >= 20000){
            return "산타";
        }
        else if(OutputView.getCalculateTotalBeneit() >= 10000) {
            return "트리";
        }
        else if(OutputView.getCalculateTotalBeneit() >= 5000) {
            return "별";
        }
        return "없음";
    }
}
