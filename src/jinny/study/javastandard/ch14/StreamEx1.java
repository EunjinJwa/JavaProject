package jinny.study.javastandard.ch14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Stream의 정렬
 */
public class StreamEx1 {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("user1", 1, 30),
                new Student("user2", 1, 50),
                new Student("user3", 3, 100),
                new Student("user4", 1, 80),
                new Student("user5", 2, 20),
                new Student("user6", 2, 80),
                new Student("user7", 3, 100),
                new Student("user8", 1, 15)
        );

        System.out.println("(1) Student의 ban 으로 정렬 (오름차순)");
        students.stream().sorted(Comparator.comparing(Student::getBan))
                .forEach(System.out::println);

        System.out.println("(2) Student 기본 정렬 - Student 클래스에서 구현한 compareTo 정의 기준");
        students.stream().sorted()
                .forEach(System.out::println);

        System.out.println("(3) 반으로 오름차순 정렬 후 Student의 기본 정렬");
        students.stream().sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder()))
                        .forEach(System.out::println);

    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ban=" + ban +
                ", totalScore=" + totalScore +
                '}';
    }

    /**
     * 기본 정렬 정의
     * 총점 내림차순을 기본 정렬로 한다.
     * @param s
     * @return
     */
    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
