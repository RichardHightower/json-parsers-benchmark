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

Run with `java -jar target/microbenchmarks.jar ".*" -wi 5 -r 2 -i 5 -f 1 -t 8`

## Figures

Here are the results on my machine:

* OS X 10.9
* Hotspot 1.7.0_45
* Intel Core i7 2,7 GHz

Benchmark                                     Mode Thr     Count  Sec         Mean   Mean error    Units
BoonOverlayBenchmark.actionLabel             thrpt   8         5    2  1068294,827     5601,188    ops/s
BoonOverlayUseValuesBenchmark.actionLabel    thrpt   8         5    2  1064954,287    13579,677    ops/s
BoonBenchmark.actionLabel                    thrpt   8         5    2   823934,387   100451,180    ops/s
JacksonASTBenchmark.actionLabel              thrpt   8         5    2   669864,977    30823,709    ops/s
JacksonObjectBenchmark.actionLabel           thrpt   8         5    2   633946,047     7543,007    ops/s
JsonSmartBenchmark.actionLabel               thrpt   8         5    2   587014,007    52624,797    ops/s
GSONBenchmark.actionLabel                    thrpt   8         5    2   485704,213     8755,187    ops/s

JacksonObjectBenchmark.citmCatalog           thrpt   8         5    2      538,430       24,877    ops/s
JacksonASTBenchmark.citmCatalog              thrpt   8         5    2      507,720       26,056    ops/s
GSONBenchmark.citmCatalog                    thrpt   8         5    2      503,147       27,695    ops/s
JsonSmartBenchmark.citmCatalog               thrpt   8         5    2      448,437       83,213    ops/s
BoonOverlayUseValuesBenchmark.citmCatalog    thrpt   8         5    2      391,643       20,264    ops/s
BoonOverlayBenchmark.citmCatalog             thrpt   8         5    2      373,130       61,214    ops/s
BoonBenchmark.citmCatalog                    thrpt   8         5    2      341,950       13,474    ops/s

BoonOverlayBenchmark.medium                  thrpt   8         5    2   694742,400    55116,165    ops/s
BoonOverlayUseValuesBenchmark.medium         thrpt   8         5    2   674185,747    50935,106    ops/s
BoonBenchmark.medium                         thrpt   8         5    2   487278,430    12214,492    ops/s
JacksonASTBenchmark.medium                   thrpt   8         5    2   437368,343    11441,632    ops/s
JacksonObjectBenchmark.medium                thrpt   8         5    2   424664,777    43412,785    ops/s
JsonSmartBenchmark.medium                    thrpt   8         5    2   365513,400    31685,541    ops/s
GSONBenchmark.medium                         thrpt   8         5    2   304126,100    31500,907    ops/s

BoonOverlayBenchmark.menu                    thrpt   8         5    2  3344725,563   220739,049    ops/s
BoonOverlayUseValuesBenchmark.menu           thrpt   8         5    2  3271076,737   146237,691    ops/s
BoonBenchmark.menu                           thrpt   8         5    2  2433783,297   196748,652    ops/s
JacksonASTBenchmark.menu                     thrpt   8         5    2  1971944,700    66832,674    ops/s
JsonSmartBenchmark.menu                      thrpt   8         5    2  1914820,760   117082,888    ops/s
JacksonObjectBenchmark.menu                  thrpt   8         5    2  1861000,550    55140,905    ops/s
GSONBenchmark.menu                           thrpt   8         5    2   846423,570    60840,691    ops/s

BoonOverlayUseValuesBenchmark.sgml           thrpt   8         5    2  1956326,197    85282,700    ops/s
BoonOverlayBenchmark.sgml                    thrpt   8         5    2  1946052,680   150570,081    ops/s
BoonBenchmark.sgml                           thrpt   8         5    2  1391541,897    43746,545    ops/s
JacksonASTBenchmark.sgml                     thrpt   8         5    2  1243308,097    39304,806    ops/s
JacksonObjectBenchmark.sgml                  thrpt   8         5    2  1091648,117    94900,960    ops/s
JsonSmartBenchmark.sgml                      thrpt   8         5    2  1010991,047   135997,355    ops/s
GSONBenchmark.sgml                           thrpt   8         5    2   735690,060    44579,995    ops/s

BoonOverlayUseValuesBenchmark.small          thrpt   8         5    2 17128129,157   375964,177    ops/s
BoonOverlayBenchmark.small                   thrpt   8         5    2 17046853,847   485384,021    ops/s
BoonBenchmark.small                          thrpt   8         5    2 11262531,033   516444,319    ops/s
JacksonASTBenchmark.small                    thrpt   8         5    2  8806269,483   787799,796    ops/s
JsonSmartBenchmark.small                     thrpt   8         5    2  7857383,170   258983,499    ops/s
JacksonObjectBenchmark.small                 thrpt   8         5    2  3482681,697   259746,915    ops/s
GSONBenchmark.small                          thrpt   8         5    2  1245247,570    55684,511    ops/s

BoonOverlayBenchmark.webxml                  thrpt   8         5    2   373443,407    20000,912    ops/s
BoonOverlayUseValuesBenchmark.webxml         thrpt   8         5    2   356831,263     9256,476    ops/s
BoonBenchmark.webxml                         thrpt   8         5    2   253886,783     9789,672    ops/s
JacksonObjectBenchmark.webxml                thrpt   8         5    2   223812,533     8046,606    ops/s
JacksonASTBenchmark.webxml                   thrpt   8         5    2   208272,520    11278,966    ops/s
JsonSmartBenchmark.webxml                    thrpt   8         5    2   179489,020     6043,467    ops/s
GSONBenchmark.webxml                         thrpt   8         5    2   151219,670    10214,736    ops/s

BoonOverlayBenchmark.widget                  thrpt   8         5    2  1919098,073   125247,468    ops/s
BoonOverlayUseValuesBenchmark.widget         thrpt   8         5    2  1916807,237   147873,153    ops/s
BoonBenchmark.widget                         thrpt   8         5    2  1260125,100    24488,355    ops/s
JacksonASTBenchmark.widget                   thrpt   8         5    2  1090080,720    97876,014    ops/s
JacksonObjectBenchmark.widget                thrpt   8         5    2  1045555,867    43791,297    ops/s
JsonSmartBenchmark.widget                    thrpt   8         5    2   872514,167    67707,190    ops/s
GSONBenchmark.widget                         thrpt   8         5    2   698191,337     7437,340    ops/s