# Json to Map microbenchmark for the JVM

## tl;dr

Jackson and Boon are basically equivalent, Boon being slighly faster.

## How to

Build with `mvn clean package`

Run with `java -jar target/microbenchmarks.jar ".*" -wi 5 -r 2 -i 5 -f 1 -t 8`

## Figures

Here are the results on my machine:

* OS X 10.9
* Hotspot 1.7.0_45
* Intel Core i7 2,7 GHz

Benchmark                              Mode Thr     Count  Sec         Mean   Mean error    Units
JacksonObjectBenchmark.actionLabel    thrpt   8         5    2   394878,953    53567,078    ops/s
BoonBenchmark.actionLabel             thrpt   8         5    2   372282,693    56957,063    ops/s
JacksonASTBenchmark.actionLabel       thrpt   8         5    2   367635,467    64799,110    ops/s
JsonSmartBenchmark.actionLabel        thrpt   8         5    2   331578,770    39288,340    ops/s
GSONBenchmark.actionLabel             thrpt   8         5    2   287205,970    36538,784    ops/s

BoonBenchmark.citmCatalog             thrpt   8         5    2   423498,030    56265,167    ops/s
JacksonASTBenchmark.citmCatalog       thrpt   8         5    2   380263,437    71261,984    ops/s
JacksonObjectBenchmark.citmCatalog    thrpt   8         5    2   376538,330    80631,531    ops/s
JsonSmartBenchmark.citmCatalog        thrpt   8         5    2   318101,147    27831,398    ops/s
GSONBenchmark.citmCatalog             thrpt   8         5    2   273344,000    19003,384    ops/s

BoonBenchmark.medium                  thrpt   8         5    2   428046,720    48489,314    ops/s
JacksonASTBenchmark.medium            thrpt   8         5    2   393514,010    66774,909    ops/s
JacksonObjectBenchmark.medium         thrpt   8         5    2   373404,590    87621,425    ops/s
JsonSmartBenchmark.medium             thrpt   8         5    2   334441,843    29276,710    ops/s
GSONBenchmark.medium                  thrpt   8         5    2   277774,997    24417,981    ops/s

BoonBenchmark.menu                    thrpt   8         5    2   401953,760    51767,155    ops/s
JacksonASTBenchmark.menu              thrpt   8         5    2   390782,587    67034,224    ops/s
JacksonObjectBenchmark.menu           thrpt   8         5    2   383524,590    57805,927    ops/s
JsonSmartBenchmark.menu               thrpt   8         5    2   313328,387    29711,924    ops/s
GSONBenchmark.menu                    thrpt   8         5    2   282594,537    26867,776    ops/s

JacksonASTBenchmark.sgml              thrpt   8         5    2   408298,140    60166,845    ops/s
BoonBenchmark.sgml                    thrpt   8         5    2   404382,530    48675,223    ops/s
JacksonObjectBenchmark.sgml           thrpt   8         5    2   390012,303    53108,745    ops/s
JsonSmartBenchmark.sgml               thrpt   8         5    2   290055,097    49836,746    ops/s
GSONBenchmark.sgml                    thrpt   8         5    2   278775,197    25603,874    ops/s

BoonBenchmark.small                   thrpt   8         5    2   445551,807    48363,323    ops/s
JacksonASTBenchmark.small             thrpt   8         5    2   384500,290    35778,442    ops/s
JacksonObjectBenchmark.small          thrpt   8         5    2   382323,397    54108,402    ops/s
JsonSmartBenchmark.small              thrpt   8         5    2   291486,827    48810,945    ops/s
GSONBenchmark.small                   thrpt   8         5    2   281993,880    31517,227    ops/s

BoonBenchmark.webxml                  thrpt   8         5    2   424611,073    46081,440    ops/s
JacksonASTBenchmark.webxml            thrpt   8         5    2   404257,270    45061,881    ops/s
JacksonObjectBenchmark.webxml         thrpt   8         5    2   389330,923    43471,343    ops/s
JsonSmartBenchmark.webxml             thrpt   8         5    2   320705,933    46967,124    ops/s
GSONBenchmark.webxml                  thrpt   8         5    2   279837,933    44166,536    ops/s

BoonBenchmark.widget                  thrpt   8         5    2   436700,040    55656,323    ops/s
JacksonASTBenchmark.widget            thrpt   8         5    2   397899,957    55310,331    ops/s
JacksonObjectBenchmark.widget         thrpt   8         5    2   366094,557    45451,675    ops/s
JsonSmartBenchmark.widget             thrpt   8         5    2   329296,533    50001,102    ops/s
GSONBenchmark.widget                  thrpt   8         5    2   280108,290    31793,220    ops/s