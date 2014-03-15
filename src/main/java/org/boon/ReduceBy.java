package org.boon;

import org.boon.primitive.Int;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

/**
 * Created by Richard on 3/15/14.
 */
public class ReduceBy {

    final static int [] array;

    final static Object func = new Functions();

    static {
        int [] a = new int[50_000];

        for (int index = 0; index < a.length; index++) {
            a[index] = index;
        }

        array = a;
    }



    public long sumReduceByUsingInvokeDynamic() {
        return Int.reduceBy(array, func);
    }

    public long sumReduceByUsingInterface() {
        return Int.reduceBy(array, new Int.ReduceBy(){

            @Override
            public long reduce(long sum, int value) {
                return sum+value;
            }
        });
    }


    public long sumReduceByReflection() {
        return Int.reduceBy(array, 0, array.length, func);
    }


    public long sumLoop() {

            long sum = 0;
            for (int index = 0; index < array.length; index++) {
                sum+= array[index];
            }
            return sum;
    }

    public long sum() {
        return Int.sum(array);
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sumReduceByUsingInvokeDynamicBench(BlackHole bh) throws Exception {
        bh.consume(sumReduceByUsingInvokeDynamic());
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sumReduceByReflectionBench(BlackHole bh) throws Exception {
        bh.consume(sumReduceByReflection());
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sumLoopBench(BlackHole bh) throws Exception {
        bh.consume(sumLoop());
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sumBench(BlackHole bh) throws Exception {
        bh.consume(sum());
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sumReduceByUsingInterfaceBench(BlackHole bh) throws Exception {
        bh.consume(sumReduceByUsingInterface());
    }



}
