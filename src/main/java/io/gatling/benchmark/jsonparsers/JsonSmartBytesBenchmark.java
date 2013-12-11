package io.gatling.benchmark.jsonparsers;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import net.minidev.json.parser.JSONParser;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

@OutputTimeUnit(TimeUnit.SECONDS)
public class JsonSmartBytesBenchmark extends AbstractBenchmark {

	protected Object parse(byte[] bytes) throws Exception {
		String string = new String(bytes, StandardCharsets.UTF_8);
		return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(string);
	}

	@GenerateMicroBenchmark
	public void roundRobin(ThreadState state, BlackHole bh) throws Exception {
		super.roundRobin(state, bh);
	}
}
