# Json to Map microbenchmark for the JVM

## Use case

Input is byte arrays.

If the parser can't guess encoding by itself, we try to decode in the most efficient possible way, but encoding time is accounted for.

## tl;dr

* Jackson is the most polyvalent (having a valence of three or more).
* Boon is very interesting if you can make use of the overlay parser (ie you actually only need a small part of the values in the JSON tree) and if your JSON payloads not too big (citmCatalog is about 1,5Mb).
* GSON is very bad for this use case

Jackson and regular Boon are basically equivalent, Boon being slighly faster.

BoonOverlay delays value parsing, so it's promising if you're only interested in a small part of your JSON tree.

## How to

Build with `mvn clean package`

Run with `java -jar target/microbenchmarks.jar ".*" -wi 1 -i 5 -f 1 -t 8`

## Figures

I reran after tightening the decodeValue loop a bit.

```
Benchmark                                             Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.GSONBenchmark.citmCatalog                    thrpt   8         5    1      285.230       69.333    ops/s
i.g.b.j.BoonBenchmark.citmCatalog                    thrpt   8         5    1      265.740       62.488    ops/s
i.g.b.j.BoonOverlayUseValuesBenchmark.citmCatalog    thrpt   8         5    1      260.550       76.974    ops/s
i.g.b.j.JacksonASTBenchmark.citmCatalog              thrpt   8         5    1      258.663      197.156    ops/s
i.g.b.j.BoonOverlayBenchmark.citmCatalog             thrpt   8         5    1      245.153      109.295    ops/s
i.g.b.j.JacksonObjectBenchmark.citmCatalog           thrpt   8         5    1      255.753      136.051    ops/s
i.g.b.j.JsonSmartBenchmark.citmCatalog               thrpt   8         5    1      227.390       68.948    ops/s
```

Boon comes in 2nd and 3rd.


Here are the results on my machine:

* OS X 10.9
* Hotspot 1.7.0_45
* Intel Core i7 2,7 GHz

```
Benchmark                                     Mode Thr     Count  Sec         Mean   Mean error    Units
BoonOverlayUseValuesBenchmark.actionLabel    thrpt   8         5    2  1062961,957    46121,726    ops/s
BoonOverlayBenchmark.actionLabel             thrpt   8         5    2  1020327,587    71035,655    ops/s
BoonBenchmark.actionLabel                    thrpt   8         5    2   866659,787    81312,219    ops/s
JacksonASTBenchmark.actionLabel              thrpt   8         5    2   657474,827    21224,877    ops/s
JsonSmartBenchmark.actionLabel               thrpt   8         5    2   607153,890    34306,642    ops/s
JacksonObjectBenchmark.actionLabel           thrpt   8         5    2   584123,507    76015,668    ops/s
GSONBenchmark.actionLabel                    thrpt   8         5    2   465000,087    41854,192    ops/s
```

```
JacksonObjectBenchmark.citmCatalog           thrpt   8         5    2      523,747       75,108    ops/s
JacksonASTBenchmark.citmCatalog              thrpt   8         5    2      505,293       76,214    ops/s
GSONBenchmark.citmCatalog                    thrpt   8         5    2      493,313       48,052    ops/s
JsonSmartBenchmark.citmCatalog               thrpt   8         5    2      466,147       47,255    ops/s
BoonOverlayBenchmark.citmCatalog             thrpt   8         5    2      365,973       97,886    ops/s
BoonBenchmark.citmCatalog                    thrpt   8         5    2      350,973       58,406    ops/s
BoonOverlayUseValuesBenchmark.citmCatalog    thrpt   8         5    2      339,557       62,196    ops/s
```
```
BoonOverlayBenchmark.medium                  thrpt   8         5    2   677838,777    19785,286    ops/s
BoonOverlayUseValuesBenchmark.medium         thrpt   8         5    2   677217,327    19138,809    ops/s
BoonBenchmark.medium                         thrpt   8         5    2   472803,637    32543,489    ops/s
JacksonASTBenchmark.medium                   thrpt   8         5    2   423047,263    30355,190    ops/s
JacksonObjectBenchmark.medium                thrpt   8         5    2   428952,800    13490,733    ops/s
JsonSmartBenchmark.medium                    thrpt   8         5    2   372056,543    47864,022    ops/s
GSONBenchmark.medium                         thrpt   8         5    2   315321,577    19551,929    ops/s
```

```
BoonOverlayUseValuesBenchmark.menu           thrpt   8         5    2  3315182,003   320620,709    ops/s
BoonOverlayBenchmark.menu                    thrpt   8         5    2  3235793,937   225455,764    ops/s
BoonBenchmark.menu                           thrpt   8         5    2  2490420,853   123599,184    ops/s
JacksonASTBenchmark.menu                     thrpt   8         5    2  1946907,660   174405,812    ops/s
JsonSmartBenchmark.menu                      thrpt   8         5    2  1877384,597    95945,398    ops/s
JacksonObjectBenchmark.menu                  thrpt   8         5    2  1820128,510    65374,528    ops/s
GSONBenchmark.menu                           thrpt   8         5    2   830056,570    86771,148    ops/s
```

```
BoonOverlayUseValuesBenchmark.sgml           thrpt   8         5    2  1925716,883   207260,636    ops/s
BoonOverlayBenchmark.sgml                    thrpt   8         5    2  1902968,240    54084,994    ops/s
BoonBenchmark.sgml                           thrpt   8         5    2  1362402,113    53022,432    ops/s
JacksonASTBenchmark.sgml                     thrpt   8         5    2  1217097,047    81860,969    ops/s
JacksonObjectBenchmark.sgml                  thrpt   8         5    2  1149081,437    81725,863    ops/s
JsonSmartBenchmark.sgml                      thrpt   8         5    2   974234,527   163274,791    ops/s
GSONBenchmark.sgml                           thrpt   8         5    2   747821,627    54873,413    ops/s
```

```
BoonOverlayUseValuesBenchmark.small          thrpt   8         5    2 17041602,563   909497,356    ops/s
BoonOverlayBenchmark.small                   thrpt   8         5    2 16908584,157   993726,047    ops/s
BoonBenchmark.small                          thrpt   8         5    2 11091223,857   435660,786    ops/s
JacksonASTBenchmark.small                    thrpt   8         5    2  8614927,580   963332,534    ops/s
JsonSmartBenchmark.small                     thrpt   8         5    2  8162157,220   378917,273    ops/s
JacksonObjectBenchmark.small                 thrpt   8         5    2  3538664,207    97811,901    ops/s
GSONBenchmark.small                          thrpt   8         5    2  1287765,810    24477,291    ops/s
```

```
BoonOverlayBenchmark.webxml                  thrpt   8         5    2   366903,577    12639,355    ops/s
BoonOverlayUseValuesBenchmark.webxml         thrpt   8         5    2   353483,927    20062,405    ops/s
BoonBenchmark.webxml                         thrpt   8         5    2   246991,500    15948,107    ops/s
JacksonObjectBenchmark.webxml                thrpt   8         5    2   223489,673    10302,025    ops/s
JacksonASTBenchmark.webxml                   thrpt   8         5    2   214008,963    38140,989    ops/s
JsonSmartBenchmark.webxml                    thrpt   8         5    2   199469,593    15809,418    ops/s
GSONBenchmark.webxml                         thrpt   8         5    2   152600,343    20934,888    ops/s
```

```
BoonOverlayUseValuesBenchmark.widget         thrpt   8         5    2  1916605,860   103995,415    ops/s
BoonOverlayBenchmark.widget                  thrpt   8         5    2  1900958,443    69651,769    ops/s
BoonBenchmark.widget                         thrpt   8         5    2  1187603,717    24366,161    ops/s
JacksonASTBenchmark.widget                   thrpt   8         5    2  1108853,063    81942,792    ops/s
JacksonObjectBenchmark.widget                thrpt   8         5    2  1031457,037    85314,738    ops/s
JsonSmartBenchmark.widget                    thrpt   8         5    2   870911,923    11616,332    ops/s
GSONBenchmark.widget                         thrpt   8         5    2   673113,010    38864,970    ops/s
```
