package io.gatling.benchmark.jsonparsers;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.boon.json.JsonParserFactory;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

@OutputTimeUnit(TimeUnit.SECONDS)
public class BoonDirectBytesBenchmark extends AbstractBenchmark {

	protected Object parse(byte[] bytes) throws Exception {
		return new JsonParserFactory().useDirectBytes().setCharset(StandardCharsets.UTF_8).create().parse(Map.class, bytes);
	}

	@GenerateMicroBenchmark
	public void roundRobin(ThreadState state, BlackHole bh) throws Exception {
		super.roundRobin(state, bh);
	}
}
