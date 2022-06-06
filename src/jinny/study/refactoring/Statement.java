package jinny.study.refactoring;

import jinny.study.refactoring.domain.*;

import java.util.HashMap;

public class Statement {

    private HashMap<String, PlayForm> plays;

    public Statement() {
        Play play = new Play();
        this.plays = play.play;
    }

    public String statement(Invoice invoice, HashMap<String, PlayForm> plays) {
        plays = this.plays;

        int totalAmount = 0;
        int volumeCredits = 0;
        String result = String.format("청구 내역 (고객명: %s)\n", invoice.customer);

        for (InvoicePerformance perf : invoice.performances) {
            final PlayForm play = plays.get(perf.playID);
            long thisAmount = 0;

            switch (play.type) {
                case tragedy:
                    thisAmount = 40000;
                    if (perf.audience > 30) {
                        thisAmount += 1000 * (perf.audience - 30);
                    }
                    break;
                case comedy:
                    thisAmount = 30000;
                    if (perf.audience > 20) {
                        thisAmount += 10000 + 500 * (perf.audience -20);
                    }
                    thisAmount += 300 * perf.audience;
                    break;
                default:
                    throw new RuntimeException("알 수 없는 장르" + play.type);
            }

            // 포인트 적림
            volumeCredits += Math.max(perf.audience - 30, 0);
            // 희극 관객 5마다 추가 포인트 제공
            if (PlayType.comedy == play.type)
                volumeCredits += Math.floor(perf.audience/5);

            // 청구 내역 출력
            result += String.format("%s: %.2f (%d석)\n", play.name, (double) thisAmount / 100, perf.audience);
            totalAmount += thisAmount;
        }
        result += String.format("총액: %.2f\n", (double)totalAmount / 100);
        result += String.format("적립 포인트: %d점\n", volumeCredits);
        return result;
    }
}
