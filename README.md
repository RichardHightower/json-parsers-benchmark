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
BoonOverlayBenchmark.actionLabel             thrpt   8         5    2   857537,517    56039,572    ops/s
BoonBenchmark.actionLabel                    thrpt   8         5    2   778937,823    99661,891    ops/s
BoonOverlayUseValuesBenchmark.actionLabel    thrpt   8         5    2   755232,263    24780,184    ops/s
JacksonASTBenchmark.actionLabel              thrpt   8         5    2   543631,060    55154,448    ops/s
JsonSmartBenchmark.actionLabel               thrpt   8         5    2   521195,660    78740,640    ops/s
JacksonObjectBenchmark.actionLabel           thrpt   8         5    2   521869,340    51155,405    ops/s
BoonUTF8Benchmark.actionLabel                thrpt   8         5    2   520805,717   444311,563    ops/s
GSONBenchmark.actionLabel                    thrpt   8         5    2   416081,253    42551,983    ops/s

BoonUTF8Benchmark.citmCatalog                thrpt   8         5    2      499,883      253,006    ops/s
JacksonObjectBenchmark.citmCatalog           thrpt   8         5    2      454,413       70,918    ops/s
BoonOverlayBenchmark.citmCatalog             thrpt   8         5    2      348,413       65,789    ops/s
JacksonASTBenchmark.citmCatalog              thrpt   8         5    2      415,067       80,046    ops/s
JsonSmartBenchmark.citmCatalog               thrpt   8         5    2      403,707       50,873    ops/s
GSONBenchmark.citmCatalog                    thrpt   8         5    2      391,110       52,385    ops/s
BoonBenchmark.citmCatalog                    thrpt   8         5    2      340,253       68,829    ops/s
BoonOverlayUseValuesBenchmark.citmCatalog    thrpt   8         5    2      336,223      108,272    ops/s

BoonOverlayBenchmark.medium                  thrpt   8         5    2   605016,500    53007,095    ops/s
BoonOverlayUseValuesBenchmark.medium         thrpt   8         5    2   531021,193   106433,251    ops/s
BoonBenchmark.medium                         thrpt   8         5    2   438523,983    42059,981    ops/s
JacksonObjectBenchmark.medium                thrpt   8         5    2   364242,073    69145,273    ops/s
JacksonASTBenchmark.medium                   thrpt   8         5    2   350796,050    17523,920    ops/s
JsonSmartBenchmark.medium                    thrpt   8         5    2   340445,560    33294,658    ops/s
BoonUTF8Benchmark.medium                     thrpt   8         5    2   330930,693    26971,446    ops/s
GSONBenchmark.medium                         thrpt   8         5    2   264327,130    10583,725    ops/s

BoonOverlayBenchmark.menu                    thrpt   8         5    2  2996654,960   324778,553    ops/s
BoonOverlayUseValuesBenchmark.menu           thrpt   8         5    2  2442357,803   132518,350    ops/s
BoonBenchmark.menu                           thrpt   8         5    2  1966961,560   143822,915    ops/s
JsonSmartBenchmark.menu                      thrpt   8         5    2  1805778,987    69172,356    ops/s
BoonUTF8Benchmark.menu                       thrpt   8         5    2  1704107,197  1087696,277    ops/s
JacksonASTBenchmark.menu                     thrpt   8         5    2  1581252,323   152333,791    ops/s
JacksonObjectBenchmark.menu                  thrpt   8         5    2  1548697,283   167604,282    ops/s
GSONBenchmark.menu                           thrpt   8         5    2   772661,583    45806,242    ops/s

BoonOverlayBenchmark.roundRobin              thrpt   8         5    2  1001558,210    66836,669    ops/s
BoonOverlayUseValuesBenchmark.roundRobin     thrpt   8         5    2   959784,213    39305,863    ops/s
BoonBenchmark.roundRobin                     thrpt   8         5    2   717155,880    65508,962    ops/s
JacksonASTBenchmark.roundRobin               thrpt   8         5    2   642535,960   116914,033    ops/s
JacksonObjectBenchmark.roundRobin            thrpt   8         5    2   621086,537    41830,529    ops/s
BoonUTF8Benchmark.roundRobin                 thrpt   8         5    2   620200,180    23217,435    ops/s
JsonSmartBenchmark.roundRobin                thrpt   8         5    2   543488,693    34402,550    ops/s
GSONBenchmark.roundRobin                     thrpt   8         5    2   445124,723    32934,550    ops/s

BoonOverlayUseValuesBenchmark.sgml           thrpt   8         5    2  1627804,460   217962,353    ops/s
BoonOverlayBenchmark.sgml                    thrpt   8         5    2  1473733,283   217451,469    ops/s
BoonBenchmark.sgml                           thrpt   8         5    2  1232296,833   209228,967    ops/s
JacksonASTBenchmark.sgml                     thrpt   8         5    2  1194232,733   133534,436    ops/s
BoonUTF8Benchmark.sgml                       thrpt   8         5    2  1089877,663    72390,764    ops/s
JacksonObjectBenchmark.sgml                  thrpt   8         5    2   976289,837   138176,415    ops/s
JsonSmartBenchmark.sgml                      thrpt   8         5    2   887153,590    51655,074    ops/s
GSONBenchmark.sgml                           thrpt   8         5    2   647123,770    35057,454    ops/s

BoonOverlayUseValuesBenchmark.small          thrpt   8         5    2 12459497,693  1554512,937    ops/s
BoonOverlayBenchmark.small                   thrpt   8         5    2 12348143,330   837411,967    ops/s
BoonUTF8Benchmark.small                      thrpt   8         5    2 11088749,960  2127010,316    ops/s
BoonBenchmark.small                          thrpt   8         5    2 10202333,280   203994,584    ops/s
JacksonASTBenchmark.small                    thrpt   8         5    2  7433507,910   773467,341    ops/s
JsonSmartBenchmark.small                     thrpt   8         5    2  7048427,117   502277,538    ops/s
JacksonObjectBenchmark.small                 thrpt   8         5    2  3198795,660   160177,562    ops/s
GSONBenchmark.small                          thrpt   8         5    2  1106845,913    53295,065    ops/s

BoonOverlayUseValuesBenchmark.webxml         thrpt   8         5    2   309090,513    16998,525    ops/s
BoonOverlayBenchmark.webxml                  thrpt   8         5    2   301942,433    59479,198    ops/s
BoonBenchmark.webxml                         thrpt   8         5    2   223423,577     5316,818    ops/s
JacksonObjectBenchmark.webxml                thrpt   8         5    2   185513,607    17723,991    ops/s
JacksonASTBenchmark.webxml                   thrpt   8         5    2   184583,887    41669,764    ops/s
BoonUTF8Benchmark.webxml                     thrpt   8         5    2   173947,220    44893,887    ops/s
JsonSmartBenchmark.webxml                    thrpt   8         5    2   172450,600    13102,557    ops/s
GSONBenchmark.webxml                         thrpt   8         5    2   131624,803    11385,647    ops/s

BoonOverlayUseValuesBenchmark.widget         thrpt   8         5    2  1556466,613   112359,370    ops/s
BoonOverlayBenchmark.widget                  thrpt   8         5    2  1551415,240   217723,400    ops/s
BoonBenchmark.widget                         thrpt   8         5    2  1113386,623    67734,671    ops/s
BoonUTF8Benchmark.widget                     thrpt   8         5    2   956814,943   139414,756    ops/s
JacksonASTBenchmark.widget                   thrpt   8         5    2   944304,737   116398,209    ops/s
JacksonObjectBenchmark.widget                thrpt   8         5    2   930823,567   117901,592    ops/s
JsonSmartBenchmark.widget                    thrpt   8         5    2   723536,697    87078,803    ops/s
GSONBenchmark.widget                         thrpt   8         5    2   573606,620    39201,336    ops/s