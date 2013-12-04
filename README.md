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
BoonBenchmark.actionLabel             thrpt   8         5    2   516728,617    81768,047    ops/s
JacksonObjectBenchmark.actionLabel    thrpt   8         5    2   454697,077    11137,889    ops/s
JacksonASTBenchmark.actionLabel       thrpt   8         5    2   449642,950    36431,078    ops/s
JsonSmartBenchmark.actionLabel        thrpt   8         5    2   398320,823     5906,185    ops/s
GSONBenchmark.actionLabel             thrpt   8         5    2   327654,430     7595,551    ops/s

BoonBenchmark.citmCatalog             thrpt   8         5    2   486724,473    27875,912    ops/s
JacksonASTBenchmark.citmCatalog       thrpt   8         5    2   452150,410    15933,320    ops/s
JacksonObjectBenchmark.citmCatalog    thrpt   8         5    2   443450,440    23138,659    ops/s
JsonSmartBenchmark.citmCatalog        thrpt   8         5    2   367655,913    35533,980    ops/s
GSONBenchmark.citmCatalog             thrpt   8         5    2   332259,120    10648,096    ops/s

BoonBenchmark.medium                  thrpt   8         5    2   487657,197    58496,926    ops/s
JacksonASTBenchmark.medium            thrpt   8         5    2   452064,423    15099,801    ops/s
JacksonObjectBenchmark.medium         thrpt   8         5    2   418356,723    31197,628    ops/s
JsonSmartBenchmark.medium             thrpt   8         5    2   348987,200    47343,071    ops/s
GSONBenchmark.medium                  thrpt   8         5    2   321760,667    32247,756    ops/s

BoonBenchmark.menu                    thrpt   8         5    2   501840,700    15873,646    ops/s
JacksonASTBenchmark.menu              thrpt   8         5    2   455988,967    22193,357    ops/s
JacksonObjectBenchmark.menu           thrpt   8         5    2   420155,257    33970,799    ops/s
JsonSmartBenchmark.menu               thrpt   8         5    2   374585,443    21303,872    ops/s
GSONBenchmark.menu                    thrpt   8         5    2   330439,317     8275,263    ops/s

BoonBenchmark.sgml                    thrpt   8         5    2   509373,877    14076,802    ops/s
JacksonASTBenchmark.sgml              thrpt   8         5    2   462197,517    11728,903    ops/s
JacksonObjectBenchmark.sgml           thrpt   8         5    2   422408,680     8281,996    ops/s
JsonSmartBenchmark.sgml               thrpt   8         5    2   379323,083     5022,579    ops/s
GSONBenchmark.sgml                    thrpt   8         5    2   324244,373     5407,624    ops/s

BoonBenchmark.small                   thrpt   8         5    2   495639,050    13126,133    ops/s
JacksonASTBenchmark.small             thrpt   8         5    2   448940,757    11738,107    ops/s
JacksonObjectBenchmark.small          thrpt   8         5    2   398740,353    30813,681    ops/s
JsonSmartBenchmark.small              thrpt   8         5    2   389280,913    21207,823    ops/s
GSONBenchmark.small                   thrpt   8         5    2   319285,690    20572,290    ops/s

BoonBenchmark.webxml                  thrpt   8         5    2   476910,393    43969,866    ops/s
JacksonASTBenchmark.webxml            thrpt   8         5    2   454601,930    26480,906    ops/s
JacksonObjectBenchmark.webxml         thrpt   8         5    2   403868,947    43349,649    ops/s
JsonSmartBenchmark.webxml             thrpt   8         5    2   367233,867    44678,357    ops/s
GSONBenchmark.webxml                  thrpt   8         5    2   324109,180     9758,358    ops/s

BoonBenchmark.widget                  thrpt   8         5    2   493103,680    32218,420    ops/s
JacksonASTBenchmark.widget            thrpt   8         5    2   422923,833    44324,228    ops/s
JacksonObjectBenchmark.widget         thrpt   8         5    2   418473,367    37657,010    ops/s
JsonSmartBenchmark.widget             thrpt   8         5    2   378376,620    77293,977    ops/s
GSONBenchmark.widget                  thrpt   8         5    2   314231,610    16051,293    ops/s