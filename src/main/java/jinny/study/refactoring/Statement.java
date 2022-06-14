package jinny.study.refactoring;

import jinny.study.refactoring.domain.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Statement {

    private HashMap<String, PlayForm> plays;

    public Statement() {
        Play play = new Play();
        this.plays = play.play;
    }

    public String statement(Invoice invoice) {
        StatementData data = StatementData.builder()
                .customer(invoice.customer)
                .statementPerformances(invoice.performances.stream().map(this::enrichPerformance).collect(Collectors.toList()))
                .build();
        data.totalAmount = totalAmount(invoice.performances);
        data.totalVolumeCredits = totalVolumeCredits(invoice.performances);
        return renderPlainText(data);   // 출력할 값이 StatementData에 모두 정의되어있으므로, 여러가지 형태로 rendering할 수 있음.
    }

    public StatementPerformance enrichPerformance(InvoicePerformance performance) {
        PerformanceCalculator cal = createPerformanceCalculator(performance, playFor(performance.playID));
        StatementPerformance result;
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        result = modelMapper.map(performance, StatementPerformance.class);
        result.play = playFor(performance.playID);
        result.amount = cal.getAmount();
        result.volumeCredits = cal.getVolumeCredits();
        return result;
    }

    private PerformanceCalculator createPerformanceCalculator(InvoicePerformance performance, PlayForm play) {
        switch (play.type) {
            case tragedy:
                return new TragedyCalculator(performance, play);
            case comedy:
                return new ComedyCalculator(performance, play);
            default:
                throw new RuntimeException("알 수 없는 공연 타입 : " + play.type);
        }
    }

    public String renderPlainText(StatementData data) {
        String result = String.format("청구 내역 (고객명: %s)\n", data.customer);
        for (StatementPerformance perf : data.statementPerformances) {
            result += String.format("%s: %s (%d석)\n", perf.play.name, usd(perf.amount), perf.audience);
        }
        result += String.format("총액: %s\n", usd(data.totalAmount));
        result += String.format("적립 포인트: %d점\n", data.totalVolumeCredits);
        return result;
    }

    private int totalAmount(List<InvoicePerformance> performances) {
        int result = 0;
        for (InvoicePerformance perf : performances) {
            result += amountFor(perf);
        }
        return result;
    }

    private int totalVolumeCredits(List<InvoicePerformance> performances) {
        int result = 0;
        for (InvoicePerformance perf : performances) {
            // 포인트 적림
            result += volumeCreditsFor(perf);
        }
        return result;
    }

    private long volumeCreditsFor(InvoicePerformance aPerformance) {
        return createPerformanceCalculator(aPerformance, playFor(aPerformance.playID)).getVolumeCredits();
    }


    private String usd(float number) {
        return NumberFormat.getCurrencyInstance(Locale.US).format((number/100));
    }

    private PlayForm playFor(String playID) {
        return plays.get(playID);
    }

    private long amountFor(InvoicePerformance aPerformance) {
        return createPerformanceCalculator(aPerformance, playFor(aPerformance.playID)).getAmount();
    }
}
