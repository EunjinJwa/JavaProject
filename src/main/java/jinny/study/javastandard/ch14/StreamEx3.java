package jinny.study.javastandard.ch14;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * IntSummaryStatistics
 * IntStream의 요소값으로 다양한 통계치를 뽑을 수 있다.
 */
public class StreamEx3 {
    public static void main(String[] args) {

        Student[] students = {
                new Student("user1", 3, 315),
                new Student("user2", 1, 204),
                new Student("user3", 2, 123),
                new Student("user4", 2, 151),
                new Student("user5", 1, 158),
                new Student("user6", 1, 156)
        };

        Stream<Student> studentStream = Stream.of(students);

        IntStream studentScoreStream = studentStream.mapToInt(Student::getTotalScore);

        IntSummaryStatistics statsStream = studentScoreStream.summaryStatistics();
        System.out.printf("count : %d%n", statsStream.getCount());
        System.out.printf("sum : %d%n", statsStream.getSum());
        System.out.printf("average : %.2f%n", statsStream.getAverage());
        System.out.printf("min : %d%n", statsStream.getMin());
        System.out.printf("max : %d", statsStream.getMax());
    }
}
