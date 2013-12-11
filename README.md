# Json to Map microbenchmark for the JVM

## Use case

Input is byte arrays.

If the parser can't guess encoding by itself, we try to decode in the most efficient possible way, but encoding time is accounted for.

## tl;dr

* Jackson is the most polyvalent.
* Boon is very interesting if you can make use of the overlay parser (ie you actually only need a small part of the values in the JSON tree) and if your JSON payloads not too big (citmCatalog is about 1,5Mb).
* GSON is not very good for this use case

and regular Boon are basically equivalent, Boon being slighly faster.

BoonOverlay delays value parsing, so it's promising if you're only interested in a small part of your JSON tree.

## How to

Build with `mvn clean package`

Run with `java -jar target/microbenchmarks.jar ".*" -wi 1 -i 5 -f 1 -t 8`

## Figures

Here are the results on my machine:

* OS X 10.9
* Hotspot 1.7.0_45
* Intel Core i7 2,7 GHz

Benchmark                               Mode Thr     Count  Sec         Mean   Mean error    Units
BoonCharArrayBenchmark.roundRobin      thrpt  16        20    1   728637,749    33788,999    ops/s
JacksonASTBenchmark.roundRobin         thrpt  16        20    1   648126,547    68926,526    ops/s
JacksonObjectBenchmark.roundRobin      thrpt  16        20    1   625373,468    29713,740    ops/s
JsonSmartStringBenchmark.roundRobin    thrpt  16        20    1   554507,738    17355,724    ops/s
JsonSmartBytesBenchmark.roundRobin     thrpt  16        20    1   548681,071    23638,098    ops/s
GSONStringBenchmark.roundRobin         thrpt  16        20    1   509019,675    27328,786    ops/s
GSONReaderBenchmark.roundRobin         thrpt  16        20    1   429658,645    17885,251    ops/s
BoonDirectBytesBenchmark.roundRobin    thrpt  16        20    1   389449,467    17550,011    ops/s
JsonSmartStreamBenchmark.roundRobin    thrpt  16        20    1   345438,873    55877,116    ops/s
JsonSmartReaderBenchmark.roundRobin    thrpt  16        20    1   101966,373     8217,541    ops/s