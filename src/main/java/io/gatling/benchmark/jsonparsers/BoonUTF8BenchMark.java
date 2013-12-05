package io.gatling.benchmark.jsonparsers;

import org.boon.json.JsonUTF8Parser;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;

import static io.gatling.benchmark.jsonparsers.Bytes.ACTION_LABEL_BYTES;
import static io.gatling.benchmark.jsonparsers.Bytes.CITM_CATALOG_BYTES;


public class BoonUTF8BenchMark {


    private Object parse(byte[] bytes) throws Exception {
        return JsonUTF8Parser.parseMap ( bytes );
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void citmCatalog(BlackHole bh) throws Exception {
        bh.consume(parse(CITM_CATALOG_BYTES));
    }

}
