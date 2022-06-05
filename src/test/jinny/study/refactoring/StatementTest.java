package jinny.study.refactoring;

import jinny.study.refactoring.domain.Invoice;
import jinny.study.refactoring.domain.InvoicePerformance;


class StatementTest {

    public void statementTest() {

        Invoice invoice = new Invoice();
        invoice.customer = "BigCo";
        invoice.addPerformance(new InvoicePerformance("hamlet", 55));
        invoice.addPerformance(new InvoicePerformance("as-like", 35));
        invoice.addPerformance(new InvoicePerformance("othello", 40));

        Statement statement = new Statement();
        String result = statement.statement(invoice, null);
        System.out.println(result);
    }

}