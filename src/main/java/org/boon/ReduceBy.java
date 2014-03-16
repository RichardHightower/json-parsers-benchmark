package org.boon;

import org.boon.collections.IntList;
import org.boon.core.Fn;
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
        int [] a = new int[5_000_000];

        for (int index = 0; index < a.length; index++) {
            a[index] = 1;
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

    public long sumIntListReduceByUsingInterface() {
        IntList list = new IntList(array);

        return list.reduceBy(new Int.ReduceBy(){

            @Override
            public long reduce(long sum, int value) {
                return sum+value;
            }
        });
    }


    public long sumReduceByDirectReflection() {

        //Using
        return Int.reduceBy(array, new Fn() {
            long f(long sum, int value) {
                return sum + value;
            }
        });
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
    public void sumIntListReduceByUsingInterfaceBench(BlackHole bh) throws Exception {
        bh.consume(sumIntListReduceByUsingInterface());
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sumReduceByUsingInvokeDynamicBench(BlackHole bh) throws Exception {
        bh.consume(sumReduceByUsingInvokeDynamic());
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

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sumReduceByDirectReflectionBench(BlackHole bh) throws Exception {
        bh.consume(sumReduceByDirectReflection());
    }




}
