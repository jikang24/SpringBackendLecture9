package org.example.Head04_JCF_StreamAPI.example6;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class SummarizingExample {
    public static void main(String[] args) {
        List<Integer> intScores = Arrays.asList(80, 95, 70, 100, 85);
        List<Long> longScores = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        List<Double> doubleScores = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);

        IntSummaryStatistics intSummaryStatistics = intScores.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Int Summmary Count = " + intSummaryStatistics.getCount());
        System.out.println("Int Summmary Sum = " + intSummaryStatistics.getSum());
        System.out.println("Int Summmary Min = " + intSummaryStatistics.getMin());
        System.out.println("Int Summmary Max = " + intSummaryStatistics.getMax());
        System.out.println("Int Summmary Average = " + intSummaryStatistics.getAverage());
    }


}
