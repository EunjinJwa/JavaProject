package jinny.study.javastandard.ch14;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * collect()의 다양한 활용
 */
public class StreamEx6 {
    public static void main(String[] args) {

        Student[] studentArr = {
                new Student("user1", 3, 315),
                new Student("user2", 1, 204),
                new Student("user3", 2, 123),
                new Student("user4", 2, 400),
                new Student("user5", 1, 158),
                new Student("user6", 1, 400),
                new Student("user7", 3, 135)
        };

        List<String> names = Stream.of(studentArr).map(Student::getName).collect(Collectors.toList());
        System.out.println("names = " + names);

        // 스트림을 배열로 변환
        Student[] studentArr2 = Stream.of(studentArr).toArray(Student[]::new);
        System.out.println("Arrays.toString(studentArr2) = " + Arrays.toString(studentArr2));

        // 스트림을 Map<String, Student>로 변환. 학생 이름이 key
        Map<String, Student> studentMap = Stream.of(studentArr).collect(Collectors.toMap(Student::getName, k->k));
        System.out.println(studentMap);

        long count = Stream.of(studentArr).count();
        long count2 = Stream.of(studentArr).collect(Collectors.counting());
        System.out.println("count = " + count + " & count == count2 > " + (count == count2));

        // 배열의 요소를 sum 하는 방법
        long sum1 = Stream.of(studentArr).mapToInt(Student::getTotalScore).sum();
        long sum2 = Stream.of(studentArr).map(Student::getTotalScore).reduce(0, Integer::sum);  // .reduce(0, (a,b) -> Integer.sum(a,b))
        long sum3 = Stream.of(studentArr).collect(Collectors.summingLong(Student::getTotalScore));
        long sum4 = Stream.of(studentArr).collect(Collectors.reducing(0, k -> k.getTotalScore(), (a,b) -> a + b ));
        long sum5 = Stream.of(studentArr).collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
        System.out.println((sum1 == sum2) + " | sum = " + sum1);
        System.out.println((sum3 == sum4 && sum4 == sum5) + " | sum = " + sum3);

        // max 점수인 student 찾기
        Optional<Student> topStudent1 = Stream.of(studentArr).max(Comparator.comparing(Student::getTotalScore));
        Optional<Student> topStudent2 = Stream.of(studentArr)
                .collect(Collectors.maxBy(Comparator.comparing(a -> a.getTotalScore())));
        System.out.println(topStudent1.get().getTotalScore() == topStudent2.get().getTotalScore());

        // statistics
        IntSummaryStatistics stats = Stream.of(studentArr).mapToInt(Student::getTotalScore).summaryStatistics();
        IntSummaryStatistics stats2 = Stream.of(studentArr).collect(Collectors.summarizingInt(Student::getTotalScore));
        System.out.println("count = " + stats.getCount());
        System.out.println("max = " + stats.getMax());
        System.out.println("average = " + stats.getAverage());
        System.out.println("stats2 = " + stats2);

        // joining
        String stuNames = Stream.of(studentArr).map(Student::getName).collect(Collectors.joining());
        String stuNames2 = Stream.of(studentArr).map(Student::getName).collect(Collectors.joining(","));
        String stuName3 = Stream.of(studentArr).map(Student::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println("stuNames = " + stuNames);
        System.out.println("stuNames2 = " + stuNames2);
        System.out.println("stuName3 = " + stuName3);

    }
}
