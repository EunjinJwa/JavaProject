package jinny.study.refactoring;

import jinny.study.refactoring.domain.PlayForm;
import lombok.Data;

@Data
public class StatementPerformance {

    public String playID;
    public int audience;
    public PlayForm play;
    public long amount;
    public long volumeCredits;

}
