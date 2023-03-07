package jinny.study.domain;

public class FreeMember extends Member {

    public FreeMember (String id, String name, int age) {
        super(id, name, age);
    }

    public String getMemberName() {
        return super.getName();
    }
}
