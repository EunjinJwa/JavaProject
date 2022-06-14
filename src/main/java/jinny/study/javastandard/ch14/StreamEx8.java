package jinny.study.javastandard.ch14;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx8 {
    public static void main(String[] args) {
        Student[] students = new Student().getSampleStudentArr();

        System.out.println("1. 단순 그룹핑 : 학년별로 그룹");
        Map<Integer, List<Student>> studentsByHak = Stream.of(students)
                .collect(Collectors.groupingBy(Student::getHak));
        System.out.println(" 1학년");
        for (Student s : studentsByHak.get(1)) System.out.println(s.toString());
        System.out.println(" 2학년");
        for (Student s : studentsByHak.get(2)) System.out.println(s.toString());
        System.out.println(" 3학년");
        for (Student s : studentsByHak.get(3)) System.out.println(s.toString());

        System.out.println("2. 단순 그룹핑 : 학년별로 학생 수 그룹핑");
        Map<Integer, Long> stuCountByHak = Stream.of(students)
                .collect(Collectors.groupingBy(Student::getHak, Collectors.counting()));
        System.out.println(stuCountByHak);

        System.out.println("3. 단순 그룹핑 : 성적 등급별 그룹");
        Map<Student.Level, List<Student>> stuByLevel = Stream.of(students)
                .collect(Collectors.groupingBy(s ->
                    s.getTotalScore() >= 300 ? Student.Level.HIHG : s.getTotalScore() >= 200 ? Student.Level.MID : Student.Level.LOW
                ));

        // 출력 1
        stuByLevel.keySet().forEach(s -> {
            System.out.println(s + " -> " + stuByLevel.get(s));
        });
        // 출력 2
        TreeSet<Student.Level> keySet = new TreeSet(stuByLevel.keySet());
        for (Student.Level level : keySet) {
            for (Student s : stuByLevel.get(level)) {
                System.out.println(level + " => " + s);
            }
        }


        Function<Integer, Student.Level> getLevel = l -> l >= 300 ? Student.Level.HIHG : l >= 200 ? Student.Level.MID : Student.Level.LOW;

        System.out.println("4. 단순 그룹핑 + 통계 : 성적 등급별 학생 수 ");
        Map<Student.Level, Long> stuCountByLevel = Stream.of(students)
                .collect(Collectors.groupingBy(s -> getLevel.apply(s.totalScore), Collectors.counting()));
        System.out.println(stuCountByLevel);

        System.out.println("5. 다중 그룹핑 : 학년별, 반별 그룹 ");
        Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan = Stream.of(students)
                .collect(Collectors.groupingBy(Student::getHak,
                        Collectors.groupingBy(Student::getBan)));
        for (Map<Integer, List<Student>> banMap : stuByHakAndBan.values()) {
            System.out.println();
            for (List<Student> s : banMap.values()) {
                System.out.println();
                for (Student s1 : s) {
                    System.out.println(s1);
                }
            }
        }

        System.out.println("6. 다중 그룹핑 + 통계 : 학년별, 반별 1등 학생");
        Map<Integer, Map<Integer, Optional<Student>>> topSudentByHakAndBan = Stream.of(students)
                .collect(Collectors.groupingBy(Student::getHak,
                        Collectors.groupingBy(Student::getBan,
                                Collectors.maxBy(Comparator.comparing(Student::getTotalScore)))));
        for (Integer hak : topSudentByHakAndBan.keySet()) {
            System.out.println("학년 : " + hak);
            for (Integer ban : topSudentByHakAndBan.get(hak).keySet()) {
                System.out.println("반 : " + ban + " | " + topSudentByHakAndBan.get(hak).get(ban).get());
            }
        }

        System.out.println("7. 다중 그룹핑 + 통계 : 학년별, 반별 성적레벨 그룹");
        Map<String, Set<Student.Level>> stuByScoreGroup = Stream.of(students)
                .collect(Collectors.groupingBy(s -> s.getHak() + " - " + s.getBan(),
                        Collectors.mapping(s -> getLevel.apply(s.totalScore), Collectors.toSet())
                ));
        Set<String> keySet2 = stuByScoreGroup.keySet();
        for (String key: keySet2) {
            System.out.println(key + " > " + stuByScoreGroup.get(key));
        }


    }
}
