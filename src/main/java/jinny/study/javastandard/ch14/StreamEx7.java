package jinny.study.javastandard.ch14;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * collect를 활용한 partitioningBy()
 */
public class StreamEx7 {
    public static void main(String[] args) {

        Student[] stuArr = new Student().getSampleStudentArr();

        // 단순 분할 : 성별
        Map<Boolean, List<Student>> stuBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student::isMale));
        List<Student> maleStudents = stuBySex.get(true);
        List<Student> femaleStudents = stuBySex.get(false);
        for (Student s : maleStudents) System.out.println(s.toString());
        for (Student s : femaleStudents) System.out.println(s.toString());

        // 단순 분할 + 통계 : 성별 학생 수
        Map<Boolean, Long> stuCountBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student::isMale, Collectors.counting()));
        System.out.println("여학생 수: " + stuCountBySex.get(false));
        System.out.println("남학생 수: " + stuCountBySex.get(true));

        // 단순 분할 + 통계 : 성별 1등 학생
        Map<Boolean, Optional<Student>> topStuBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student::isMale, Collectors.maxBy(Comparator.comparing(Student::getTotalScore))));
        System.out.println("top 여학생 : " + topStuBySex.get(false).get());
        System.out.println("top 남학생 : " + topStuBySex.get(true).get());

        Map<Boolean, Student> topStuBySex2 = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student::isMale,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getTotalScore)), Optional::get)));
        System.out.println("top 여학생 : " + topStuBySex2.get(false));
        System.out.println("top 남학생 : " + topStuBySex2.get(true));

        // 다중 분할 : 성별 불합격자, 100점 이하
        Map<Boolean, Map<Boolean, List<Student>>> failedStuBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student::isMale,
                        Collectors.partitioningBy(s -> s.totalScore > 150)));
        List<Student> failedMailStudents = failedStuBySex.get(true).get(false);
        List<Student> failedFemailStudents = failedStuBySex.get(false).get(false);
        for (Student s : failedMailStudents) System.out.println(s.toString());
        System.out.println("");
        for (Student s : failedFemailStudents) System.out.println(s.toString());


    }
}
