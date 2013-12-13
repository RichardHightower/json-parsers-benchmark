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
BoonCharArrayBenchmark.roundRobin      thrpt  16        10    1   724815,875    54339,825    ops/s
JacksonObjectBenchmark.roundRobin      thrpt  16        10    1   580014,875   145097,700    ops/s
JsonSmartBytesBenchmark.roundRobin     thrpt  16        10    1   575548,435    64202,618    ops/s
JsonSmartStringBenchmark.roundRobin    thrpt  16        10    1   541212,220    45144,815    ops/s
GSONStringBenchmark.roundRobin         thrpt  16        10    1   522947,175    65572,427    ops/s
BoonDirectBytesBenchmark.roundRobin    thrpt  16        10    1   521528,912    41366,197    ops/s
JacksonASTBenchmark.roundRobin         thrpt  16        10    1   512564,205   300704,545    ops/s
GSONReaderBenchmark.roundRobin         thrpt  16        10    1   446322,220    41327,496    ops/s
JsonSmartStreamBenchmark.roundRobin    thrpt  16        10    1   276399,298   130055,340    ops/s
JsonSmartReaderBenchmark.roundRobin    thrpt  16        10    1    86789,825    17690,031    ops/s