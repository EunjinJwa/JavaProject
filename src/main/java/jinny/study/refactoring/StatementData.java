package jinny.study.refactoring;

import lombok.Builder;

import java.util.List;

@Builder
public class StatementData {
    public String customer;
    public List<StatementPerformance> statementPerformances;
    public long totalAmount;
    public long totalVolumeCredits;
}
