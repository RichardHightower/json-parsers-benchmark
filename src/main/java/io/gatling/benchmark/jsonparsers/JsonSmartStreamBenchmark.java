package io.gatling.benchmark.jsonparsers;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

import net.minidev.json.parser.JSONParser;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

@OutputTimeUnit(TimeUnit.SECONDS)
public class JsonSmartStreamBenchmark extends AbstractBenchmark {

	protected Object parse(byte[] bytes) throws Exception {
		return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(new ByteArrayInputStream(bytes));
	}

	@GenerateMicroBenchmark
	public void roundRobin(ThreadState state, BlackHole bh) throws Exception {
		super.roundRobin(state, bh);
	}
}
