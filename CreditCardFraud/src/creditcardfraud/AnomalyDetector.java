package creditcardfraud;

import java.util.List;

public class AnomalyDetector {
    private final List<Payment> paymentHistory;

    public AnomalyDetector(List<Payment> paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public boolean isAnomalyDetected(Payment payment) {
        double deviationThreshold = 0.3; // 30% deviation threshold

        // Calculate the average amount and country of previous payments
        double averageAmount = calculateAverageAmount();
        String averageCountry = calculateAverageCountry();

        // Calculate the deviation percentage of the new payment compared to the average amount
        double amountDeviation = (averageAmount - payment.getAmount()) / averageAmount;
        // Check if the amount deviation or country is greater than the thresholds
        // Not an anomaly
        
        // Check if the amount deviation or country is greater than the thresholds
        if (amountDeviation > deviationThreshold || !payment.getCountry().equals(averageCountry)) {
            return true;
        }else {
            return false;
        }
    }

    private double calculateAverageAmount() {
        double sum = 0.0;
        int count = 0;

        for (Payment payment : paymentHistory) {
            sum += payment.getAmount();
            count++;
        }

        return sum / count;
    }

    private String calculateAverageCountry() {
        // Assuming country is a String property of the Payment class
        // and paymentHistory is a list of Payment objects
        int totalCount = paymentHistory.size();
        int maxCount = 0;
        String mostCommonCountry = "";

        for (Payment payment : paymentHistory) {
            int currentCount = 0;
            for (Payment innerPayment : paymentHistory) {
                if (innerPayment.getCountry().equals(payment.getCountry())) {
                    currentCount++;
                }
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostCommonCountry = payment.getCountry();
            }
        }

        return mostCommonCountry;
    }
}
