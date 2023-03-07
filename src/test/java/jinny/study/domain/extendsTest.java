package jinny.study.domain;

import org.junit.jupiter.api.Test;

public class extendsTest {


    @Test
    public void upCastingTest() {
        Member member = new FreeMember("1", "kassy", 30);
        System.out.println(member.getName());
    }


    @Test
    public void downCastingTest() {
        FreeMember member = (FreeMember) new Member("1", "kassy", 30);
        System.out.println(member.getName());
    }
}
