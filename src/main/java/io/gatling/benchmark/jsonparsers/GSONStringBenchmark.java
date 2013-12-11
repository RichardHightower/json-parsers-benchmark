package io.gatling.benchmark.jsonparsers;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import com.google.gson.Gson;

@OutputTimeUnit(TimeUnit.SECONDS)
public class GSONStringBenchmark extends AbstractBenchmark {

	private static final Gson GSON = new Gson();

	protected Object parse(byte[] bytes) throws Exception {
		String string = new String(bytes, StandardCharsets.UTF_8);
		return GSON.fromJson(string, Map.class);
	}

	@GenerateMicroBenchmark
	public void roundRobin(ThreadState state, BlackHole bh) throws Exception {
		super.roundRobin(state, bh);
	}
}
