package jinny.study.domain;

import java.io.Serializable;

public class Member implements Serializable {
    private String id;
    private String name;
    private int age;

    public Member (String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString () {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
