package jinny.study.refactoring;

import jinny.study.refactoring.domain.Invoice;
import jinny.study.refactoring.domain.InvoicePerformance;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StatementTest {

    @Test
    void statement() {
        String resultString = "청구 내역 (고객명: BigCo)\n" +
                "Hamlet: $650.00 (55석)\n" +
                "As You Like It: $580.00 (35석)\n" +
                "Othello: $500.00 (40석)\n" +
                "총액: $1,730.00\n" +
                "적립 포인트: 47점\n";

        Invoice invoice = new Invoice();
        invoice.customer = "BigCo";
        invoice.addPerformance(new InvoicePerformance("hamlet", 55));
        invoice.addPerformance(new InvoicePerformance("as-like", 35));
        invoice.addPerformance(new InvoicePerformance("othello", 40));

        Statement statement = new Statement();
        String result = statement.statement(invoice);

        Assertions.assertThat(resultString).isEqualTo(result);
    }

    @Test
    public void modelMapperTest() {
        InvoicePerformance obj1 = new InvoicePerformance("aa", 100);
        Statement statement = new Statement();
        StatementPerformance obj2 = statement.enrichPerformance(obj1);

        Assertions.assertThat(obj1.playID.equals(obj2.playID));
    }

}