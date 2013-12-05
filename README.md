# Json to Map microbenchmark for the JVM

## Use case

Input is byte arrays.

If the parser can't guess encoding by itself, we try to decode in the most efficient possible way, but encoding time is accounted for.

## tl;dr

* Jackson is the most polyvalent.
* Boon is very interesting if you can make use of the overlay parser (ie you actually only need a small part of the values in the JSON tree) and if your JSON payloads not too big (citmCatalog is about 1,5Mb).
* GSON is very bad for this use case

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

Benchmark                                     Mode Thr     Count  Sec         Mean   Mean error    Units
BoonOverlayBenchmark.actionLabel             thrpt   8         5    2  1050115,803    60344,684    ops/s
BoonOverlayUseValuesBenchmark.actionLabel    thrpt   8         5    2   978396,220    20870,864    ops/s
BoonBenchmark.actionLabel                    thrpt   8         5    2   872192,337    40616,188    ops/s
BoonUTF8Benchmark.actionLabel                thrpt   8         5    2   645806,923   291198,042    ops/s
JacksonASTBenchmark.actionLabel              thrpt   8         5    2   662466,007    78741,489    ops/s
JacksonObjectBenchmark.actionLabel           thrpt   8         5    2   645722,710    44173,032    ops/s
JsonSmartBenchmark.actionLabel               thrpt   8         5    2   629050,627    26839,132    ops/s
GSONBenchmark.actionLabel                    thrpt   8         5    2   489137,390    15577,750    ops/s

BoonUTF8Benchmark.citmCatalog                thrpt   8         5    2      624,080      204,579    ops/s
JacksonObjectBenchmark.citmCatalog           thrpt   8         5    2      544,783       77,920    ops/s
JacksonASTBenchmark.citmCatalog              thrpt   8         5    2      537,337       84,352    ops/s
GSONBenchmark.citmCatalog                    thrpt   8         5    2      525,643       61,674    ops/s
JsonSmartBenchmark.citmCatalog               thrpt   8         5    2      459,893       53,263    ops/s
BoonBenchmark.citmCatalog                    thrpt   8         5    2      343,727       58,903    ops/s
BoonOverlayBenchmark.citmCatalog             thrpt   8         5    2      361,053       66,945    ops/s
BoonOverlayUseValuesBenchmark.citmCatalog    thrpt   8         5    2      378,610       89,851    ops/s

BoonOverlayBenchmark.medium                  thrpt   8         5    2   726803,413    18016,269    ops/s
BoonOverlayUseValuesBenchmark.medium         thrpt   8         5    2   723759,733    24627,805    ops/s
BoonBenchmark.medium                         thrpt   8         5    2   514843,260    61843,037    ops/s
JacksonASTBenchmark.medium                   thrpt   8         5    2   465918,713    25601,192    ops/s
JacksonObjectBenchmark.medium                thrpt   8         5    2   456611,160    11401,094    ops/s
BoonUTF8Benchmark.medium                     thrpt   8         5    2   411533,560    17849,863    ops/s
JsonSmartBenchmark.medium                    thrpt   8         5    2   375688,630    13505,999    ops/s
GSONBenchmark.medium                         thrpt   8         5    2   326120,593    22742,349    ops/s

BoonOverlayUseValuesBenchmark.menu           thrpt   8         5    2  3364498,100   180830,367    ops/s
BoonOverlayBenchmark.menu                    thrpt   8         5    2  3346544,170    96471,113    ops/s
BoonBenchmark.menu                           thrpt   8         5    2  2629268,687   152308,577    ops/s
BoonUTF8Benchmark.menu                       thrpt   8         5    2  2316799,073   487744,693    ops/s
JacksonASTBenchmark.menu                     thrpt   8         5    2  2100562,213    68391,568    ops/s
JacksonObjectBenchmark.menu                  thrpt   8         5    2  1889663,237    52360,313    ops/s
JsonSmartBenchmark.menu                      thrpt   8         5    2  1875261,367   111611,316    ops/s
GSONBenchmark.menu                           thrpt   8         5    2   877673,730    28408,232    ops/s

BoonOverlayUseValuesBenchmark.sgml           thrpt   8         5    2  2026264,257    94004,498    ops/s
BoonOverlayBenchmark.sgml                    thrpt   8         5    2  1877181,233    49459,711    ops/s
BoonBenchmark.sgml                           thrpt   8         5    2  1437633,770    80488,369    ops/s
BoonUTF8Benchmark.sgml                       thrpt   8         5    2  1353147,113   151521,022    ops/s
JacksonASTBenchmark.sgml                     thrpt   8         5    2  1321486,643    59318,875    ops/s
JacksonObjectBenchmark.sgml                  thrpt   8         5    2  1144227,433    87878,307    ops/s
JsonSmartBenchmark.sgml                      thrpt   8         5    2  1059614,417    70794,378    ops/s
GSONBenchmark.sgml                           thrpt   8         5    2   766230,320    24632,939    ops/s

BoonOverlayUseValuesBenchmark.small          thrpt   8         5    2 17320008,590   701150,884    ops/s
BoonOverlayBenchmark.small                   thrpt   8         5    2 16522670,067   798815,905    ops/s
BoonUTF8Benchmark.small                      thrpt   8         5    2 13228973,470   594593,631    ops/s
BoonBenchmark.small                          thrpt   8         5    2 11677191,653   592521,133    ops/s
JacksonASTBenchmark.small                    thrpt   8         5    2  9313487,023  1048531,493    ops/s
JsonSmartBenchmark.small                     thrpt   8         5    2  8475345,077   311967,017    ops/s
JacksonObjectBenchmark.small                 thrpt   8         5    2  3522526,980    74977,324    ops/s
GSONBenchmark.small                          thrpt   8         5    2  1278005,960    30848,450    ops/s

BoonOverlayUseValuesBenchmark.webxml         thrpt   8         5    2   389891,297    11347,365    ops/s
BoonOverlayBenchmark.webxml                  thrpt   8         5    2   381895,957    13759,926    ops/s
BoonBenchmark.webxml                         thrpt   8         5    2   260081,817     6597,728    ops/s
JacksonASTBenchmark.webxml                   thrpt   8         5    2   239955,910     8419,066    ops/s
JacksonObjectBenchmark.webxml                thrpt   8         5    2   235983,893     8428,481    ops/s
BoonUTF8Benchmark.webxml                     thrpt   8         5    2   214283,310     7498,150    ops/s
JsonSmartBenchmark.webxml                    thrpt   8         5    2   199826,017    11436,504    ops/s
GSONBenchmark.webxml                         thrpt   8         5    2   163696,820     8507,568    ops/s

BoonOverlayBenchmark.widget                  thrpt   8         5    2  2006398,183    65506,261    ops/s
BoonOverlayUseValuesBenchmark.widget         thrpt   8         5    2  2004429,077    83887,840    ops/s
BoonBenchmark.widget                         thrpt   8         5    2  1253091,663    99380,868    ops/s
JacksonASTBenchmark.widget                   thrpt   8         5    2  1185460,470    34988,233    ops/s
BoonUTF8Benchmark.widget                     thrpt   8         5    2  1177887,563    90463,932    ops/s
JacksonObjectBenchmark.widget                thrpt   8         5    2  1097226,060    73715,849    ops/s
JsonSmartBenchmark.widget                    thrpt   8         5    2   903774,463    31820,856    ops/s
GSONBenchmark.widget                         thrpt   8         5    2   703171,867    30524,076    ops/s