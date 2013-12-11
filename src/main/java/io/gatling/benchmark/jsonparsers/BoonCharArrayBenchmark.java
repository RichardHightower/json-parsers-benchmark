package io.gatling.benchmark.jsonparsers;

import static io.gatling.benchmark.util.UnsafeUtil.*;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.boon.json.JsonParserFactory;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

@OutputTimeUnit(TimeUnit.SECONDS)
public class BoonCharArrayBenchmark extends AbstractBenchmark {

	protected Object parse(byte[] bytes) throws Exception {
		char[] chars = getChars(new String(bytes, StandardCharsets.UTF_8));
		return new JsonParserFactory().create().parse(Map.class, chars);
	}

	@GenerateMicroBenchmark
	public void roundRobin(ThreadState state, BlackHole bh) throws Exception {
		super.roundRobin(state, bh);
	}
}
