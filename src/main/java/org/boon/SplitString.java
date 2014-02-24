package org.boon;

import org.boon.core.reflection.FastStringUtils;
import org.boon.primitive.CharScanner;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


public class SplitString {


    private static final String csv =
            "gomezle01,1933,0,ALS193307060,NYA,AL,1,1\n" +
            "ferreri01,1933,0,ALS193307060,BOS,AL,1,2\n" +
            "gehrilo01,1933,0,ALS193307060,NYA,AL,1,3\n" +
            "gehrich01,1933,0,ALS193307060,DET,AL,1,4\n" +
            "dykesji01,1933,0,ALS193307060,CHA,AL,1,5\n" +
            "cronijo01,1933,0,ALS193307060,WS1,AL,1,6\n" +
            "chapmbe01,1933,0,ALS193307060,NYA,AL,1,7\n" +
            "simmoal01,1933,0,ALS193307060,CHA,AL,1,8\n" +
            "ruthba01,1933,0,ALS193307060,NYA,AL,1,9\n" +
            "dickebi01,1933,0,ALS193307060,NYA,AL,0,\n" +
            "ferrewe01,1933,0,ALS193307060,CLE,AL,0,\n" +
            "foxxji01,1933,0,ALS193307060,PHA,AL,0,\n" +
            "hildeor01,1933,0,ALS193307060,CLE,AL,0,\n" +
            "lazzeto01,1933,0,ALS193307060,NYA,AL,0,\n" +
            "averiea01,1933,0,ALS193307060,CLE,AL,1,\n" +
            "crowdal01,1933,0,ALS193307060,WS1,AL,1,\n" +
            "grovele01,1933,0,ALS193307060,PHA,AL,1,\n" +
            "westsa01,1933,0,ALS193307060,SLA,AL,1,\n" +
            "hallabi01,1933,0,ALS193307060,SLN,NL,1,1\n" +
            "wilsoji01,1933,0,ALS193307060,SLN,NL,1,2\n" +
            "terrybi01,1933,0,ALS193307060,NY1,NL,1,3\n" +
            "friscfr01,1933,0,ALS193307060,SLN,NL,1,4\n" +
            "martipe01,1933,0,ALS193307060,SLN,NL,1,5\n" +
            "bartedi01,1933,0,ALS193307060,PHI,NL,1,6\n" +
            "hafeych01,1933,0,ALS193307060,CIN,NL,1,7\n" +
            "bergewa01,1933,0,ALS193307060,BSN,NL,1,8\n" +
            "kleinch01,1933,0,ALS193307060,PHI,NL,1,9\n" +
            "schumha02,1933,0,ALS193307060,NY1,NL,0,\n" +
            "cuccito01,1933,0,ALS193307060,BRO,NL,1,\n" +
            "engliwo01,1933,0,ALS193307060,CHN,NL,1,\n" +
            "hartnga01,1933,0,ALS193307060,CHN,NL,1,\n" +
            "hubbeca01,1933,0,ALS193307060,NY1,NL,1,\n" +
            "odoulle01,1933,0,ALS193307060,NY1,NL,1,\n" +
            "traynpi01,1933,0,ALS193307060,PIT,NL,1,\n" +
            "wanerpa01,1933,0,ALS193307060,PIT,NL,1,\n" +
            "warnelo01,1933,0,ALS193307060,CHN,NL,1,\n" +
            "gomezle01,1934,0,NLS193407100,NYA,AL,1,1\n" +
            "dickebi01,1934,0,NLS193407100,NYA,AL,1,2\n" +
            "gehrilo01,1934,0,NLS193407100,NYA,AL,1,3\n" +
            "gehrich01,1934,0,NLS193407100,DET,AL,1,4\n" +
            "foxxji01,1934,0,NLS193407100,PHA,AL,1,5\n" +
            "cronijo01,1934,0,NLS193407100,WS1,AL,1,6\n" +
            "manushe01,1934,0,NLS193407100,WS1,AL,1,7\n" +
            "simmoal01,1934,0,NLS193407100,CHA,AL,1,8\n" +
            "ruthba01,1934,0,NLS193407100,NYA,AL,1,9\n" +
            "bridgto01,1934,0,NLS193407100,DET,AL,0,\n" +
            "dykesji01,1934,0,NLS193407100,CHA,AL,0,\n" +
            "ferreri01,1934,0,NLS193407100,BOS,AL,0,\n" +
            "higgipi01,1934,0,NLS193407100,PHA,AL,0,\n" +
            "russeja01,1934,0,NLS193407100,WS1,AL,0,\n" +
            "averiea01,1934,0,NLS193407100,CLE,AL,1,\n" +
            "chapmbe01,1934,0,NLS193407100,NYA,AL,1,\n" +
            "cochrmi01,1934,0,NLS193407100,DET,AL,1,\n" +
            "hardeme01,1934,0,NLS193407100,CLE,AL,1,\n" +
            "ruffire01,1934,0,NLS193407100,NYA,AL,1,\n" +
            "westsa01,1934,0,NLS193407100,SLA,AL,1,\n" +
            "hubbeca01,1934,0,NLS193407100,NY1,NL,1,1\n" +
            "hartnga01,1934,0,NLS193407100,CHN,NL,1,2\n" +
            "terrybi01,1934,0,NLS193407100,NY1,NL,1,3\n" +
            "friscfr01,1934,0,NLS193407100,SLN,NL,1,4\n" +
            "traynpi01,1934,0,NLS193407100,PIT,NL,1,5\n" +
            "jackstr01,1934,0,NLS193407100,NY1,NL,1,6\n" +
            "medwijo01,1934,0,NLS193407100,SLN,NL,1,7\n" +
            "bergewa01,1934,0,NLS193407100,BSN,NL,1,8\n" +
            "cuyleki01,1934,0,NLS193407100,CHN,NL,1,9\n" +
            "moorejo02,1934,0,NLS193407100,NY1,NL,0,\n" +
            "deandi01,1934,0,NLS193407100,SLN,NL,1,\n" +
            "frankfr02,1934,0,NLS193407100,BSN,NL,1,\n" +
            "hermabi01,1934,0,NLS193407100,CHN,NL,1,\n" +
            "kleinch01,1934,0,NLS193407100,CHN,NL,1,\n" +
            "lopezal01,1934,0,NLS193407100,BRO,NL,1,\n" +
            "martipe01,1934,0,NLS193407100,SLN,NL,1,\n" +
            "mungova01,1934,0,NLS193407100,BRO,NL,1,\n" +
            "ottme01,1934,0,NLS193407100,NY1,NL,1,\n" +
            "vaughar01,1934,0,NLS193407100,PIT,NL,1,\n" +
            "wanerpa01,1934,0,NLS193407100,PIT,NL,1,\n" +
            "warnelo01,1934,0,NLS193407100,CHN,NL,1,\n" +
            "gomezle01,1935,0,ALS193507080,NYA,AL,1,1\n" +
            "hemslro01,1935,0,ALS193507080,SLA,AL,1,2\n" +
            "gehrilo01,1935,0,ALS193507080,NYA,AL,1,3\n" +
            "gehrich01,1935,0,ALS193507080,DET,AL,1,4\n" +
            "foxxji01,1935,0,ALS193507080,PHA,AL,1,5\n" +
            "cronijo01,1935,0,ALS193507080,BOS,AL,1,6\n" +
            "johnsbo01,1935,0,ALS193507080,PHA,AL,1,7\n" +
            "simmoal01,1935,0,ALS193507080,CHA,AL,1,8\n" +
            "vosmijo01,1935,0,ALS193507080,CLE,AL,1,9\n" +
            "averiea01,1935,0,ALS193507080,CLE,AL,0,\n" +
            "bridgto01,1935,0,ALS193507080,DET,AL,0,\n" +
            "cochrmi01,1935,0,ALS193507080,DET,AL,0,\n" +
            "ferreri01,1935,0,ALS193507080,BOS,AL,0,\n" +
            "grovele01,1935,0,ALS193507080,BOS,AL,0,\n" +
            "myerbu01,1935,0,ALS193507080,WS1,AL,0,\n" +
            "rowesc01,1935,0,ALS193507080,DET,AL,0,\n" +
            "westsa01,1935,0,ALS193507080,SLA,AL,0,\n" +
            "bluegos01,1935,0,ALS193507080,WS1,AL,1,\n" +
            "chapmbe01,1935,0,ALS193507080,NYA,AL,1,\n" +
            "cramedo01,1935,0,ALS193507080,PHA,AL,1,\n" +
            "hardeme01,1935,0,ALS193507080,CLE,AL,1,\n" +
            "walkebi01,1935,0,ALS193507080,SLN,NL,1,1\n" +
            "wilsoji01,1935,0,ALS193507080,PHI,NL,1,2\n" +
            "terrybi01,1935,0,ALS193507080,NY1,NL,1,3\n" +
            "hermabi01,1935,0,ALS193507080,CHN,NL,1,4\n" +
            "martipe01,1935,0,ALS193507080,SLN,NL,1,5\n" +
            "vaughar01,1935,0,ALS193507080,PIT,NL,1,6\n" +
            "medwijo01,1935,0,ALS193507080,SLN,NL,1,7\n" +
            "bergewa01,1935,0,ALS193507080,BSN,NL,1,8\n" +
            "ottme01,1935,0,ALS193507080,NY1,NL,1,9\n" +
            "friscfr01,1935,0,ALS193507080,SLN,NL,0,\n" +
            "hubbeca01,1935,0,ALS193507080,NY1,NL,0,\n" +
            "colliri02,1935,0,ALS193507080,SLN,NL,1,\n" +
            "deandi01,1935,0,ALS193507080,SLN,NL,1,\n" +
            "derripa01,1935,0,ALS193507080,CIN,NL,1,\n" +
            "hartnga01,1935,0,ALS193507080,CHN,NL,1,\n" +
            "mancugu01,1935,0,ALS193507080,NY1,NL,1,\n" +
            "moorejo02,1935,0,ALS193507080,NY1,NL,1,\n" +
            "schumha02,1935,0,ALS193507080,NY1,NL,1,\n" +
            "wanerpa01,1935,0,ALS193507080,PIT,NL,1,\n" +
            "whitebu01,1935,0,ALS193507080,SLN,NL,1,\n" +
            "grovele01,1936,0,NLS193607070,BOS,AL,1,1\n" +
            "ferreri01,1936,0,NLS193607070,BOS,AL,1,2\n" +
            "gehrilo01,1936,0,NLS193607070,NYA,AL,1,3\n" +
            "gehrich01,1936,0,NLS193607070,DET,AL,1,4\n" +
            "higgipi01,1936,0,NLS193607070,PHA,AL,1,5\n" +
            "applilu01,1936,0,NLS193607070,CHA,AL,1,6\n" +
            "radclri01,1936,0,NLS193607070,CHA,AL,1,7\n" +
            "averiea01,1936,0,NLS193607070,CLE,AL,1,8\n" +
            "dimagjo01,1936,0,NLS193607070,NYA,AL,1,9\n" +
            "bridgto01,1936,0,NLS193607070,DET,AL,0,\n" +
            "gomezle01,1936,0,NLS193607070,NYA,AL,0,\n" +
            "hemslro01,1936,0,NLS193607070,SLA,AL,0,\n" +
            "kenneve01,1936,0,NLS193607070,CHA,AL,0,\n" +
            "pearsmo01,1936,0,NLS193607070,NYA,AL,0,\n" +
            "chapmbe01,1936,0,NLS193607070,WS1,AL,1,\n" +
            "crosefr01,1936,0,NLS193607070,NYA,AL,1,\n" +
            "dickebi01,1936,0,NLS193607070,NYA,AL,1,";

    private Integer parse(String str) throws Exception {
        int i=0;
        String[] splitLines = Str.splitLines(str);
        String[] stats;

        for (String line : splitLines) {
            stats = Str.splitComma(line);
            i += Integer.parseInt(stats[1]);
        }
        return i;
    }

    private Integer parseChars(String str) throws Exception {
        char[] chars = FastStringUtils.toCharArray(csv);
        int i=0;
        char[][] splitLines = CharScanner.splitLines(chars);
        char[][] stats;

        for (char[] line : splitLines) {
            stats = CharScanner.splitComma(line);
            i += CharScanner.parseInt(stats[1]);
        }
        return i;
    }


    private Integer parseJDK(String str) throws Exception {
        int i=0;
        String[] splitLines = str.split("(\n|\r)");
        String[] stats;

        for (String line : splitLines) {
            stats = line.split( ",");
            i += Integer.parseInt(stats[1]);
        }
        return i;
    }

    static Pattern newLine = Pattern.compile("(\n|\r)");

    private Integer parseJDK2(String str) throws Exception {
        int i=0;
        String[] splitLines = newLine.split(str);
        String[] stats;

        for (String line : splitLines) {
            stats = line.split( ",");
            i += Integer.parseInt(stats[1]);
        }
        return i;
    }

    static Pattern newLineOrComma = Pattern.compile("(\n|\r|,)");

    private Object parseJDK3(String str) throws Exception {
        return newLineOrComma.split(str);
    }


    private Object parse3Chars(String str) throws Exception {

        char[] chars = FastStringUtils.toCharArray(str);
        return CharScanner.splitByChars(chars, '\n', '\r', ',');

    }


    private Object parse3Str(String str) throws Exception {

        return StringScanner.splitByChars(str, '\n', '\r', ',');

    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void splitString(BlackHole bh) throws Exception {
        bh.consume(parse(csv));
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void splitStringJDK(BlackHole bh) throws Exception {
        bh.consume(parseJDK(csv));
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void splitStringJDK2(BlackHole bh) throws Exception {
        bh.consume(parseJDK2(csv));
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void splitChars(BlackHole bh) throws Exception {
        bh.consume(parseChars(csv));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void parse3JDK(BlackHole bh) throws Exception {
        bh.consume(parseJDK3(csv));
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void parse3Chars(BlackHole bh) throws Exception {
        bh.consume(parse3Chars(csv));
    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void parse3Str(BlackHole bh) throws Exception {
        bh.consume(parse3Str(csv));
    }

    public static void main(String... args) {

    }
}
