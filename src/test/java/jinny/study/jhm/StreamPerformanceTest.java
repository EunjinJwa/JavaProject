package jinny.study.jhm;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
public class StreamPerformanceTest {

    List<Integer> collect = IntStream.range(0, 100).boxed().collect(Collectors.toList());

    @Test
    public void callTest() throws RunnerException {
        Options build = new OptionsBuilder()
                .include(StreamPerformanceTest.class.getSimpleName())
                .warmupIterations(1)            // JVM warm-up 반복 횟수
                .measurementIterations(1)      // warm-up 이후 실제 실행 횟수
                .forks(1)
                .threads(2)
                .build();
        new Runner(build).run();
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void parallelStreamTest() {
        long start = System.currentTimeMillis();
        collect.parallelStream().forEach(index -> {
//            System.out.println("["+index+"] " + Thread.currentThread().getName() + " |  " + new Date());
            try {
				Thread.sleep(1000);
//                System.out.println("["+index+"] ========================");
            } catch (Exception e) { }
        });
        long end = System.currentTimeMillis();
        System.out.println("parallel : " + (end - start));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void streamTest() {
        long start = System.currentTimeMillis();
        collect.stream().forEach(index -> {
//            System.out.println("["+index+"] " + Thread.currentThread().getName() + " |  " + new Date());
            try {
				Thread.sleep(1000);
//                System.out.println("["+index+"] ========================");
            } catch (Exception e) { }
        });
        long end = System.currentTimeMillis();
        System.out.println("normal : " + (end - start));
    }
}
