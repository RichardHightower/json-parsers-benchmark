# Json to Map microbenchmark for the JVM

## tl;dr

Jackson and regular Boon are basically equivalent, Boon being slighly faster.

BoonOverlay delays value parsing, so it's promissing if you're only interested in a small part of your JSON tree.

## How to

Build with `mvn clean package`

Run with `java -jar target/microbenchmarks.jar ".*" -wi 5 -r 2 -i 5 -f 1 -t 8`

## Figures

Here are the results on my machine:

* OS X 10.9
* Hotspot 1.7.0_45
* Intel Core i7 2,7 GHz

Benchmark                                     Mode Thr     Count  Sec         Mean   Mean error    Units
BoonOverlayBenchmark.actionLabel             thrpt   8         5    2   691487,867    40760,724    ops/s
BoonOverlayUseValuesBenchmark.actionLabel    thrpt   8         5    2   672264,477    65798,005    ops/s
BoonBenchmark.actionLabel                    thrpt   8         5    2   475263,257    61526,446    ops/s
JacksonASTBenchmark.actionLabel              thrpt   8         5    2   466012,647    11139,252    ops/s
JacksonObjectBenchmark.actionLabel           thrpt   8         5    2   375909,553    22532,204    ops/s
JsonSmartBenchmark.actionLabel               thrpt   8         5    2   371352,267    33163,619    ops/s
GSONBenchmark.actionLabel                    thrpt   8         5    2   317089,043     4702,773    ops/s

BoonOverlayBenchmark.citmCatalog             thrpt   8         5    2   694900,090    23533,966    ops/s
BoonOverlayUseValuesBenchmark.citmCatalog    thrpt   8         5    2   638409,270    58615,220    ops/s
BoonBenchmark.citmCatalog                    thrpt   8         5    2   473628,487    34869,521    ops/s
JacksonASTBenchmark.citmCatalog              thrpt   8         5    2   464525,197     8241,965    ops/s
JacksonObjectBenchmark.citmCatalog           thrpt   8         5    2   412020,803    43919,667    ops/s
JsonSmartBenchmark.citmCatalog               thrpt   8         5    2   370032,123    11569,016    ops/s
GSONBenchmark.citmCatalog                    thrpt   8         5    2   328385,433     9344,014    ops/s

BoonOverlayUseValuesBenchmark.medium         thrpt   8         5    2   695444,230    75311,183    ops/s
BoonOverlayBenchmark.medium                  thrpt   8         5    2   693551,257    29699,365    ops/s
BoonBenchmark.medium                         thrpt   8         5    2   472161,033    22568,272    ops/s
JacksonASTBenchmark.medium                   thrpt   8         5    2   451094,170    14805,412    ops/s
JacksonObjectBenchmark.medium                thrpt   8         5    2   440485,723    17369,666    ops/s
JsonSmartBenchmark.medium                    thrpt   8         5    2   362685,307    28725,194    ops/s
GSONBenchmark.medium                         thrpt   8         5    2   316205,750    27120,890    ops/s

BoonOverlayUseValuesBenchmark.menu           thrpt   8         5    2   699579,237    26301,648    ops/s
BoonOverlayBenchmark.menu                    thrpt   8         5    2   696423,360    19441,683    ops/s
BoonBenchmark.menu                           thrpt   8         5    2   448970,253    39216,226    ops/s
JacksonObjectBenchmark.menu                  thrpt   8         5    2   431428,360    32128,673    ops/s
JacksonASTBenchmark.menu                     thrpt   8         5    2   430463,190    16615,290    ops/s
JsonSmartBenchmark.menu                      thrpt   8         5    2   374998,760    16710,176    ops/s
GSONBenchmark.menu                           thrpt   8         5    2   311871,533     4332,438    ops/s

BoonOverlayUseValuesBenchmark.sgml           thrpt   8         5    2   713075,023    19628,856    ops/s
BoonOverlayBenchmark.sgml                    thrpt   8         5    2   679688,463    49531,700    ops/s
BoonBenchmark.sgml                           thrpt   8         5    2   446264,503    27423,754    ops/s
JacksonASTBenchmark.sgml                     thrpt   8         5    2   445197,767    39778,292    ops/s
JacksonObjectBenchmark.sgml                  thrpt   8         5    2   431708,060    24138,640    ops/s
JsonSmartBenchmark.sgml                      thrpt   8         5    2   388464,247    14308,223    ops/s
GSONBenchmark.sgml                           thrpt   8         5    2   312052,457    30331,977    ops/s

BoonOverlayUseValuesBenchmark.small          thrpt   8         5    2   687089,840    67249,719    ops/s
BoonOverlayBenchmark.small                   thrpt   8         5    2   667646,190    63204,398    ops/s
BoonBenchmark.small                          thrpt   8         5    2   474116,713    28427,692    ops/s
JacksonASTBenchmark.small                    thrpt   8         5    2   453298,387     6226,972    ops/s
JacksonObjectBenchmark.small                 thrpt   8         5    2   444794,760    26912,425    ops/s
JsonSmartBenchmark.small                     thrpt   8         5    2   342130,703    39236,683    ops/s
GSONBenchmark.small                          thrpt   8         5    2   317537,450    14598,521    ops/s

BoonOverlayUseValuesBenchmark.webxml         thrpt   8         5    2   655906,260    56942,340    ops/s
BoonOverlayBenchmark.webxml                  thrpt   8         5    2   629895,473    65502,234    ops/s
BoonBenchmark.webxml                         thrpt   8         5    2   480784,060    27454,294    ops/s
JacksonASTBenchmark.webxml                   thrpt   8         5    2   415767,397    74435,543    ops/s
JacksonObjectBenchmark.webxml                thrpt   8         5    2   435337,783    23164,209    ops/s
JsonSmartBenchmark.webxml                    thrpt   8         5    2   375670,277    27219,872    ops/s
GSONBenchmark.webxml                         thrpt   8         5    2   325432,633    10306,148    ops/s

BoonOverlayUseValuesBenchmark.widget         thrpt   8         5    2   692563,243    39104,895    ops/s
BoonOverlayBenchmark.widget                  thrpt   8         5    2   647854,663   165380,124    ops/s
BoonBenchmark.widget                         thrpt   8         5    2   472287,577    23931,384    ops/s
JacksonObjectBenchmark.widget                thrpt   8         5    2   444909,073     6481,708    ops/s
JacksonASTBenchmark.widget                   thrpt   8         5    2   397047,780    58983,013    ops/s
JsonSmartBenchmark.widget                    thrpt   8         5    2   377167,430    26459,035    ops/s
GSONBenchmark.widget                         thrpt   8         5    2   323039,363    21066,625    ops/s