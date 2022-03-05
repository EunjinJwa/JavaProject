package jinny.study.javastandard.ch14;

import java.io.File;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void main(String[] args) {

        File[] fileArr = {new File("ex1.txt"), new File("ex1.java"), new File("ex2.txt"), new File("extest")};

        Stream<File> stream = Stream.of(fileArr);

        // map()으로 Stream<file>의 파일 이름을 Stream<String>으로 변환한다.
        Stream<String> fileNameStream = stream.map(File::getName);  // File::getName == f -> f.getName()
        fileNameStream.forEach(System.out::println);

        stream = Stream.of(fileArr);

        stream.map(File::getName)
                .filter(s -> s.indexOf(".") != -1)
                .map(s -> s.substring(s.indexOf(".")+1))
                .map(s -> s.toUpperCase())
                .distinct()
                .forEach(System.out::println);


    }
}
