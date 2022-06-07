package jinny.study.javastandard.ch14;

public class Student implements Comparable<jinny.study.javastandard.ch14.Student> {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int totalScore;

    Student() {

    }

    Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public Student(String name, boolean isMale, int hak, int ban, int totalScore) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
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

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public Student[] getSampleStudentArr() {
        Student[] arr = {
                new Student("User1", true, 2, 1, 200),
                new Student("User2", true, 2, 1, 100),
                new Student("User3", true, 1, 1, 100),
                new Student("User4", false, 3, 1, 300),
                new Student("User5", true, 3, 2, 200),
                new Student("User6", false, 1, 1, 150),
                new Student("User7", false, 1, 2, 230),
                new Student("User8", true, 2, 1, 900),
                new Student("User9", false, 1, 1, 120),
                new Student("User10", true, 3, 2, 158),
                new Student("User11", false, 1, 2, 200),
                new Student("User12", false, 3, 1, 200),
                new Student("User13", false, 1, 2, 265),
                new Student("User14", true, 2, 1, 230),
                new Student("User15", false, 1, 2, 205)
        };
        return arr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", hak=" + hak +
                ", ban=" + ban +
                ", totalScore=" + totalScore +
                '}';
    }

    enum Level {
        HIHG,
        MID,
        LOW
    }

    /**
     * 기본 정렬 정의
     * 총점 내림차순을 기본 정렬로 한다.
     * @param s
     * @return
     */
    @Override
    public int compareTo(jinny.study.javastandard.ch14.Student s) {
        return s.totalScore - this.totalScore;
    }
}
