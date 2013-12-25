# Json to Map microbenchmark for the JVM


Boon is the all around fastest JSON parser out of GSON, Jackson and JsonSmart (so far).
Boon now has input stream, reader, byte[], char[], CharSequence and String support.


## How to


12/25/13


```
1.7 MB JSON String

Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.citmCatalog             thrpt   8         5    1      873.970       94.240    ops/s
i.g.j.s.GSONBenchmark.citmCatalog             thrpt   8         5    1      410.783      217.476    ops/s
i.g.j.s.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      294.690       47.593    ops/s
i.g.j.s.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      305.787       29.107    ops/s
i.g.j.s.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      311.063       29.646    ops/s

2K JSON String
Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.medium             thrpt   8         5    1   816416.973    13231.453    ops/s
i.g.j.s.GSONBenchmark.medium             thrpt   8         5    1   341148.250    18117.075    ops/s
i.g.j.s.JacksonASTBenchmark.medium       thrpt   8         5    1   263167.610   147495.795    ops/s
i.g.j.s.JacksonObjectBenchmark.medium    thrpt   8         5    1   282024.617     6922.138    ops/s
i.g.j.s.JsonSmartBenchmark.medium        thrpt   8         5    1   296944.993     7852.929    ops/s

```

```
1.7 MB JSON byte[]
Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchmark.citmCatalog             thrpt   8         5    1      628.710       91.286    ops/s
i.g.j.b.GSONBenchmark.citmCatalog             thrpt   8         5    1      439.203      120.003    ops/s
i.g.j.b.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      381.350       97.841    ops/s
i.g.j.b.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      402.537        3.634    ops/s
i.g.j.b.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      341.940       18.847    ops/s

2K JSON byte[]
Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchmark.medium             thrpt   8         5    1   648162.887    18697.319    ops/s
i.g.j.b.GSONBenchmark.medium             thrpt   8         5    1   260145.827     5934.588    ops/s
i.g.j.b.JacksonASTBenchmark.medium       thrpt   8         5    1   289863.140    48969.875    ops/s
i.g.j.b.JacksonObjectBenchmark.medium    thrpt   8         5    1   289010.543    11205.881    ops/s
i.g.j.b.JsonSmartBenchmark.medium        thrpt   8         5    1   262873.957     3901.193    ops/s
```

```
1.7 MB JSON Inputstream
Benchmark                                                Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.inputStream.BoonBenchmark.citmCatalog             thrpt   8         5    1      626.907       31.450    ops/s
i.g.j.inputStream.GSONBenchmark.citmCatalog             thrpt   8         5    1      426.120       13.946    ops/s
i.g.j.inputStream.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      376.820      115.502    ops/s
i.g.j.inputStream.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      360.850       89.648    ops/s


2K file JSON Inputstream
Benchmark                                           Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.inputStream.BoonBenchmark.medium             thrpt   8         5    1   218730.830     5262.596    ops/s
i.g.j.inputStream.GSONBenchmark.medium             thrpt   8         5    1   151255.407     4486.414    ops/s
i.g.j.inputStream.JacksonASTBenchmark.medium       thrpt   8         5    1   156512.527   107512.401    ops/s
i.g.j.inputStream.JacksonObjectBenchmark.medium    thrpt   8         5    1   160793.407     4056.790    ops/s

```

```
1.7 MB JSON Reader
Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.r.BoonBenchmark.citmCatalog             thrpt   8         5    1      615.313       63.716    ops/s
i.g.j.r.GSONBenchmark.citmCatalog             thrpt   8         5    1      411.847       18.978    ops/s
i.g.j.r.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      264.727      118.541    ops/s
i.g.j.r.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      246.783       93.409    ops/s
i.g.j.r.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      151.097        3.502    ops/s

2k JSON Reader
Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.r.BoonBenchmark.medium             thrpt   8         5    1   185075.093     6528.567    ops/s
i.g.j.r.GSONBenchmark.medium             thrpt   8         5    1   134025.760     3385.134    ops/s
i.g.j.r.JacksonASTBenchmark.medium       thrpt   8         5    1   107676.323    60674.421    ops/s
i.g.j.r.JacksonObjectBenchmark.medium    thrpt   8         5    1   116903.500     3206.994    ops/s
i.g.j.r.JsonSmartBenchmark.medium        thrpt   8         5    1    77898.710     2434.773    ops/s
```

Other JSON.org examples:


```
webxml json.org example
Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.webxml             thrpt   8         5    1   421016.033    13428.790    ops/s
i.g.j.s.GSONBenchmark.webxml             thrpt   8         5    1   143801.263     7870.384    ops/s
i.g.j.s.JacksonASTBenchmark.webxml       thrpt   8         5    1   125981.563    36753.717    ops/s
i.g.j.s.JacksonObjectBenchmark.webxml    thrpt   8         5    1   130069.577    25055.300    ops/s
i.g.j.s.JsonSmartBenchmark.webxml        thrpt   8         5    1   132422.153    10254.167    ops/s
```
Boon 3X faster

```
sgml json.org example
Benchmark                               Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.sgml             thrpt   8         5    1  1846015.410   101291.991    ops/s
i.g.j.s.GSONBenchmark.sgml             thrpt   8         5    1   988186.433    35337.393    ops/s
i.g.j.s.JacksonASTBenchmark.sgml       thrpt   8         5    1   680502.597   289591.197    ops/s
i.g.j.s.JacksonObjectBenchmark.sgml    thrpt   8         5    1   709969.980    29621.959    ops/s
i.g.j.s.JsonSmartBenchmark.sgml        thrpt   8         5    1   796387.753    22697.397    ops/s
```

Boon 2x faster

```
actionLabel json.org example
Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.actionLabel             thrpt   8         5    1  1109285.703    78440.576    ops/s
i.g.j.s.GSONBenchmark.actionLabel             thrpt   8         5    1   429742.283    10097.416    ops/s
i.g.j.s.JacksonASTBenchmark.actionLabel       thrpt   8         5    1   421132.630    10514.598    ops/s
i.g.j.s.JacksonObjectBenchmark.actionLabel    thrpt   8         5    1   403535.453    16382.734    ops/s
i.g.j.s.JsonSmartBenchmark.actionLabel        thrpt   8         5    1   453847.673    25607.331    ops/s
```

Boon over 2x faster

```
menu json.org example
Benchmark                               Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.menu             thrpt   8         5    1  2582429.350   700873.986    ops/s
i.g.j.s.GSONBenchmark.menu             thrpt   8         5    1  1240234.083    22312.822    ops/s
i.g.j.s.JacksonASTBenchmark.menu       thrpt   8         5    1  1242132.793    19273.775    ops/s
i.g.j.s.JacksonObjectBenchmark.menu    thrpt   8         5    1  1141071.207    36489.605    ops/s
i.g.j.s.JsonSmartBenchmark.menu        thrpt   8         5    1  1463778.480    57490.408    ops/s
```

Boon 2x faster. 

```
Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.widget             thrpt   8         5    1  1485476.970    79222.003    ops/s
i.g.j.s.GSONBenchmark.widget             thrpt   8         5    1   810153.490    20079.953    ops/s
i.g.j.s.JacksonASTBenchmark.widget       thrpt   8         5    1   724349.650   284735.196    ops/s
i.g.j.s.JacksonObjectBenchmark.widget    thrpt   8         5    1   705271.907    42304.730    ops/s
i.g.j.s.JsonSmartBenchmark.widget        thrpt   8         5    1   728506.560    29680.028    ops/s
```
2x faster than most. :) Good job GSON!


Various parser modes that ship with Boon JSON parsers
```
Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonAsciiBytes.actionLabel            thrpt   8         5    1   302902.677    21981.467    ops/s
i.g.j.b.BoonAsciiBytes.citmCatalog            thrpt   8         5    1      628.150       26.607    ops/s
i.g.j.b.BoonAsciiBytes.medium                 thrpt   8         5    1   320658.760    38751.800    ops/s
i.g.j.b.BoonAsciiBytes.menu                   thrpt   8         5    1  2081501.213   113660.611    ops/s
i.g.j.b.BoonAsciiBytes.sgml                   thrpt   8         5    1   998463.200    31916.216    ops/s
i.g.j.b.BoonAsciiBytes.small                  thrpt   8         5    1 11095898.987   534428.831    ops/s
i.g.j.b.BoonAsciiBytes.webxml                 thrpt   8         5    1   148348.463     5512.808    ops/s
i.g.j.b.BoonAsciiBytes.widget                 thrpt   8         5    1   879580.747    14598.011    ops/s
i.g.j.b.BoonBenchMarkLax.actionLabel          thrpt   8         5    1   806689.270    28745.917    ops/s
i.g.j.b.BoonBenchMarkLax.citmCatalog          thrpt   8         5    1      633.087       77.455    ops/s
i.g.j.b.BoonBenchMarkLax.medium               thrpt   8         5    1   569042.093    61404.916    ops/s
i.g.j.b.BoonBenchMarkLax.menu                 thrpt   8         5    1  2600248.763   105320.234    ops/s
i.g.j.b.BoonBenchMarkLax.sgml                 thrpt   8         5    1  1476412.973   284184.058    ops/s
i.g.j.b.BoonBenchMarkLax.small                thrpt   8         5    1 13336195.790  1442531.930    ops/s
i.g.j.b.BoonBenchMarkLax.webxml               thrpt   8         5    1   270060.157     6539.573    ops/s
i.g.j.b.BoonBenchMarkLax.widget               thrpt   8         5    1  1262768.937    51676.215    ops/s
i.g.j.b.BoonBenchMarkUTF8Bytes.actionLabel    thrpt   8         5    1   185209.077   670100.163    ops/s
i.g.j.b.BoonBenchMarkUTF8Bytes.citmCatalog    thrpt   8         5    1      379.917       30.037    ops/s
i.g.j.b.BoonBenchMarkUTF8Bytes.medium         thrpt   8         5    1   217107.220     5247.417    ops/s
i.g.j.b.BoonBenchMarkUTF8Bytes.menu           thrpt   8         5    1  1319969.417    79745.189    ops/s
i.g.j.b.BoonBenchMarkUTF8Bytes.sgml           thrpt   8         5    1   688184.650    34033.100    ops/s
i.g.j.b.BoonBenchMarkUTF8Bytes.small          thrpt   8         5    1  7486431.520  1228519.698    ops/s
i.g.j.b.BoonBenchMarkUTF8Bytes.webxml         thrpt   8         5    1   104078.393    15332.908    ops/s
i.g.j.b.BoonBenchMarkUTF8Bytes.widget         thrpt   8         5    1   526663.853   214399.644    ops/s
i.g.j.b.BoonCharArray.actionLabel             thrpt   8         5    1   407056.423   149970.346    ops/s
i.g.j.b.BoonCharArray.citmCatalog             thrpt   8         5    1      391.130       55.374    ops/s
i.g.j.b.BoonCharArray.medium                  thrpt   8         5    1   320601.040    83669.815    ops/s
i.g.j.b.BoonCharArray.menu                    thrpt   8         5    1  1686792.320   112046.346    ops/s
i.g.j.b.BoonCharArray.sgml                    thrpt   8         5    1  1052574.220    44541.919    ops/s
i.g.j.b.BoonCharArray.small                   thrpt   8         5    1  8071292.173   663678.327    ops/s
i.g.j.b.BoonCharArray.webxml                  thrpt   8         5    1   181207.910    32126.919    ops/s
i.g.j.b.BoonCharArray.widget                  thrpt   8         5    1   878541.030   137067.187    ops/s
i.g.j.b.BoonFastParser.actionLabel            thrpt   8         5    1   601141.330    77361.337    ops/s
i.g.j.b.BoonFastParser.citmCatalog            thrpt   8         5    1      429.987      198.559    ops/s
i.g.j.b.BoonFastParser.medium                 thrpt   8         5    1   462712.293   118751.410    ops/s
i.g.j.b.BoonFastParser.menu                   thrpt   8         5    1  1981728.817   239514.140    ops/s
i.g.j.b.BoonFastParser.sgml                   thrpt   8         5    1  1117030.450   209863.168    ops/s
i.g.j.b.BoonFastParser.small                  thrpt   8         5    1 10197156.600   169372.770    ops/s
i.g.j.b.BoonFastParser.webxml                 thrpt   8         5    1   230100.983    62048.894    ops/s
i.g.j.b.BoonFastParser.widget                 thrpt   8         5    1  1242538.033   169654.975    ops/s
i.g.j.b.BoonStringDirect.actionLabel          thrpt   8         5    1   461358.763    45184.611    ops/s
i.g.j.b.BoonStringDirect.citmCatalog          thrpt   8         5    1      332.883       25.544    ops/s
i.g.j.b.BoonStringDirect.medium               thrpt   8         5    1   323354.063    18819.168    ops/s
i.g.j.b.BoonStringDirect.menu                 thrpt   8         5    1  1668149.967    52797.831    ops/s
i.g.j.b.BoonStringDirect.sgml                 thrpt   8         5    1   933777.700    77093.442    ops/s
i.g.j.b.BoonStringDirect.small                thrpt   8         5    1  7111685.283   205942.968    ops/s
i.g.j.b.BoonStringDirect.webxml               thrpt   8         5    1   154376.677    50416.916    ops/s
i.g.j.b.BoonStringDirect.widget               thrpt   8         5    1   575450.757    45103.058    ops/s
```

Build with `mvn clean package`

Run with `java -jar target/microbenchmarks.jar ".*" -wi 1 -i 5 -f 1 -t 8`

12/15/13

```
Benchmark                                        Mode Thr     Count  Sec         Mean   Mean error    Units
char[]/String
i.g.j.b.BoonBenchMarkOverlay.citmCatalog        thrpt   8         5    1      802.893       43.255    ops/s
i.g.j.b.BoonCharArray.citmCatalog               thrpt   8         5    1      691.513       16.613    ops/s
i.g.j.b.BoonBenchMarkLax.citmCatalog            thrpt   8         5    1      678.370       23.839    ops/s
i.g.j.b.BoonCharArrayDoingString.citmCatalog    thrpt   8         5    1      631.620       20.259    ops/s
i.g.j.b.BoonStringDirect.citmCatalog            thrpt   8         5    1      337.493       10.749    ops/s

byte[]
i.g.j.b.BoonAsciiBytes.citmCatalog              thrpt   8         5    1      656.130       19.709    ops/s
i.g.j.b.BoonBenchMarkUTF8Bytes.citmCatalog      thrpt   8         5    1      537.373      129.094    ops/s
i.g.j.b.BoonCharDoingBytes.citmCatalog          thrpt   8         5    1      494.733       82.232    ops/s
```

```
Benchmark                                   Mode Thr     Count  Sec         Mean   Mean error    Units
char[]/String
i.g.j.b.BoonBenchMarkOverlay.medium        thrpt   8         5    1   711,039.187    51517.069    ops/s
i.g.j.b.BoonBenchMarkLax.medium            thrpt   8         5    1   570,147.337     6394.392    ops/s
i.g.j.b.BoonCharArrayDoingString.medium    thrpt   8         5    1   547,487.437     5221.812    ops/s
i.g.j.b.BoonCharArray.medium               thrpt   8         5    1   542,346.703     8568.434    ops/s
i.g.j.b.BoonStringDirect.medium            thrpt   8         5    1   443,719.363    18967.825    ops/s
byte[]
i.g.j.b.BoonAsciiBytes.medium              thrpt   8         5    1   413,414.393     2048.924    ops/s
i.g.j.b.BoonCharDoingBytes.medium          thrpt   8         5    1   393,745.647     9531.639    ops/s
i.g.j.b.BoonBenchMarkUTF8Bytes.medium      thrpt   8         5    1   333,575.097    54997.485    ops/s
```




12/15/13

```
Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
char []/String
i.g.j.b.BoonBenchMarkBasic.citmCatalog        thrpt   8         5    1      731.617       26.171    ops/s
i.g.j.b.BoonBenchMarkOverlay.citmCatalog      thrpt   8         5    1      686.680       49.770    ops/s
i.g.j.b.BoonBenchMarkLax.citmCatalog          thrpt   8         5    1      583.757      118.887    ops/s
i.g.j.b.BoonStringDirect.citmCatalog          thrpt   8         5    1      312.567       23.729    ops/s
byte[]
i.g.j.b.BoonAsciiBytes.citmCatalog            thrpt   8         5    1      649.237       28.284    ops/s
i.g.j.b.BoonBenchMarkUTF8Bytes.citmCatalog    thrpt   8         5    1      526.220       24.329    ops/s
i.g.j.b.BoonCharDoingBytes.citmCatalog        thrpt   8         5    1      489.770       15.138    ops/s
```



```
java -jar target/microbenchmarks.jar ".*buffer.*medium.*" -wi 3 -i 5 -f 1 -t 8
Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
char[]/String
i.g.j.b.BoonBenchMarkBasic.medium        thrpt   8         5    1   628322.313     6665.680    ops/s
i.g.j.b.BoonBenchMarkOverlay.medium      thrpt   8         5    1   624611.943   265091.375    ops/s
i.g.j.b.BoonBenchMarkLax.medium          thrpt   8         5    1   539984.480    12284.623    ops/s
i.g.j.b.BoonStringDirect.medium          thrpt   8         5    1   442453.377     2048.532    ops/s
byte[]
i.g.j.b.BoonAsciiBytes.medium            thrpt   8         5    1   401936.097     1739.060    ops/s
i.g.j.b.BoonCharDoingBytes.medium        thrpt   8         5    1   384948.650    82378.107    ops/s
i.g.j.b.BoonBenchMarkUTF8Bytes.medium    thrpt   8         5    1   320339.980    13740.223    ops/s
```

12/15/13
After refactor (common base class)

```
 java -jar target/microbenchmarks.jar ".*string.*Catalog" -wi 2 -i 5 -f 1 -t 8
Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.citmCatalog             thrpt   8         5    1      742.533       33.295    ops/s
i.g.j.s.GSONBenchmark.citmCatalog             thrpt   8         5    1      447.977      111.037    ops/s
i.g.j.s.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      308.393      110.855    ops/s
i.g.j.s.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      311.140       14.325    ops/s
i.g.j.s.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      361.970       20.862    ops/s
```
Now there is a common base class (between lax and char[], and it still seems very fast actually faster which makes no sense. :)

```
$  java -jar target/microbenchmarks.jar ".*string.*medium" -wi 2 -i 5 -f 1 -t 8
Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.medium             thrpt   8         5    1   605475.707    15700.968    ops/s
i.g.j.s.GSONBenchmark.medium             thrpt   8         5    1   346093.903     4655.647    ops/s
i.g.j.s.JacksonASTBenchmark.medium       thrpt   8         5    1   315064.423    22563.603    ops/s
i.g.j.s.JacksonObjectBenchmark.medium    thrpt   8         5    1   259549.923    40741.134    ops/s
i.g.j.s.JsonSmartBenchmark.medium        thrpt   8         5    1   318939.113    16846.350    ops/s
```

12/15/13

Optimization 3

String 2 MB file
```
  java -jar target/microbenchmarks.jar "(.*string.*Catalog)" -wi 3 -i 5 -f 1 -t 8
Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.citmCatalog             thrpt   8         5    1      727.780       22.415    ops/s
i.g.j.s.GSONBenchmark.citmCatalog             thrpt   8         5    1      471.193      111.817    ops/s
i.g.j.s.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      285.553      123.686    ops/s
i.g.j.s.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      319.627        9.633    ops/s
i.g.j.s.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      357.750       29.280    ops/s
```

Medium String

```
$  java -jar target/microbenchmarks.jar "(.*string.*medium)" -wi 3 -i 5 -f 1 -t 8
Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.medium             thrpt   8         5    1   598872.053    19601.473    ops/s
i.g.j.s.GSONBenchmark.medium             thrpt   8         5    1   339508.123     5777.020    ops/s
i.g.j.s.JacksonASTBenchmark.medium       thrpt   8         5    1   284663.263    89611.523    ops/s
i.g.j.s.JacksonObjectBenchmark.medium    thrpt   8         5    1   280216.273    21818.694    ops/s
i.g.j.s.JsonSmartBenchmark.medium        thrpt   8         5    1   327120.277     6906.100    ops/s
```

12/15/13

3 warm up optimization 2 2mb file

I get different results when I run benchmarks one by on instead of a bunch at a time:

```
$ java -jar target/microbenchmarks.jar "(.*string.*Catalog)" -wi 3 -i 5 -f 1 -t 8

Benchmark                                              Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.citmCatalog                     thrpt   8         5    1      719.670       25.210    ops/s
i.g.j.s.BoonCharacterSequenceBenchMark.citmCatalog    thrpt   8         5    1      663.183      129.054    ops/s
i.g.j.s.GSONBenchmark.citmCatalog                     thrpt   8         5    1      403.197      158.215    ops/s
i.g.j.s.JacksonASTBenchmark.citmCatalog               thrpt   8         5    1      307.490      137.072    ops/s
i.g.j.s.JacksonObjectBenchmark.citmCatalog            thrpt   8         5    1      326.967       21.696    ops/s
i.g.j.s.JsonSmartBenchmark.citmCatalog                thrpt   8         5    1      357.717       42.388    ops/s
```

```
$ java -jar target/microbenchmarks.jar "(.*bytes.*Catalog)" -wi 3 -i 5 -f 1 -t 8
Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchmark.citmCatalog             thrpt   8         5    1      549.787       40.092    ops/s
i.g.j.b.GSONBenchmark.citmCatalog             thrpt   8         5    1      437.003       27.186    ops/s
i.g.j.b.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      321.117      187.151    ops/s
i.g.j.b.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      389.207       33.725    ops/s
i.g.j.b.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      311.343       19.541    ops/s
```

String with String interning of keys:

```
Benchmark                                              Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.citmCatalog                     thrpt   8         5    1      709.717       84.650    ops/s
i.g.j.s.BoonCharacterSequenceBenchMark.citmCatalog    thrpt   8         5    1      703.260       15.344    ops/s
i.g.j.s.GSONBenchmark.citmCatalog                     thrpt   8         5    1      453.080      136.313    ops/s
i.g.j.s.JacksonASTBenchmark.citmCatalog               thrpt   8         5    1      326.667       35.794    ops/s
i.g.j.s.JacksonObjectBenchmark.citmCatalog            thrpt   8         5    1      334.610       11.119    ops/s
i.g.j.s.JsonSmartBenchmark.citmCatalog                thrpt   8         5    1      364.177       14.671    ops/s
```

Before String interning

```
$ java -jar target/microbenchmarks.jar "(.*string.*medium)" -wi 3 -i 5 -f 1 -t 8
Benchmark                                         Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.medium                     thrpt   8         5    1   589537.520    41049.209    ops/s
i.g.j.s.BoonCharacterSequenceBenchMark.medium    thrpt   8         5    1   443545.780     6201.818    ops/s
i.g.j.s.GSONBenchmark.medium                     thrpt   8         5    1   286341.347   161200.888    ops/s
i.g.j.s.JacksonASTBenchmark.medium               thrpt   8         5    1   284281.653    24357.465    ops/s
i.g.j.s.JacksonObjectBenchmark.medium            thrpt   8         5    1   267424.893    14734.771    ops/s
i.g.j.s.JsonSmartBenchmark.medium                thrpt   8         5    1   285039.503    56863.776    ops/s
```

After String interning keys

```
Benchmark                                         Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.medium                     thrpt   8         5    1   582727.517    47410.884    ops/s
i.g.j.s.BoonCharacterSequenceBenchMark.medium    thrpt   8         5    1   384956.587     7407.528    ops/s
i.g.j.s.GSONBenchmark.medium                     thrpt   8         5    1   263178.420   175318.031    ops/s
i.g.j.s.JacksonASTBenchmark.medium               thrpt   8         5    1   274951.733    14374.632    ops/s
i.g.j.s.JacksonObjectBenchmark.medium            thrpt   8         5    1   264349.577    15292.047    ops/s
i.g.j.s.JsonSmartBenchmark.medium                thrpt   8         5    1   312113.530    15802.124    ops/s
```

From byte array

```
Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchmark.medium             thrpt   8         5    1   409905.687     4367.342    ops/s
i.g.j.b.GSONBenchmark.medium             thrpt   8         5    1   274496.707    30539.116    ops/s
i.g.j.b.JacksonASTBenchmark.medium       thrpt   8         5    1   341520.393   117253.177    ops/s
i.g.j.b.JacksonObjectBenchmark.medium    thrpt   8         5    1   308701.053    88054.232    ops/s
i.g.j.b.JsonSmartBenchmark.medium        thrpt   8         5    1   268166.717    59921.730    ops/s
```

12/15/13

3 warm-ups
Optimization 2 2MB file

```
java -jar target/microbenchmarks.jar "(.*string.*Catalog|.*byte.*Catalog|.*inputStream.*Catalog)" -wi 3 -i 5 -f 1 -t 8

Benchmark                                                   Mode Thr     Count  Sec         Mean   Mean error    Units
bytes
i.g.j.bytes.BoonBenchmark.citmCatalog                      thrpt   8         5    1      567.957       28.914    ops/s
i.g.j.bytes.GSONBenchmark.citmCatalog                      thrpt   8         5    1      454.070       37.305    ops/s
i.g.j.bytes.JacksonASTBenchmark.citmCatalog                thrpt   8         5    1      444.917       37.230    ops/s
i.g.j.bytes.JacksonObjectBenchmark.citmCatalog             thrpt   8         5    1      369.067       79.432    ops/s
i.g.j.bytes.JsonSmartBenchmark.citmCatalog                 thrpt   8         5    1      310.707       30.617    ops/s
stream
i.g.j.inputStream.BoonBenchmark.citmCatalog                thrpt   8         5    1      432.913       42.389    ops/s
i.g.j.inputStream.GSONBenchmark.citmCatalog                thrpt   8         5    1      348.263       29.406    ops/s
i.g.j.inputStream.JacksonASTBenchmark.citmCatalog          thrpt   8         5    1      309.323       62.159    ops/s
i.g.j.inputStream.JacksonObjectBenchmark.citmCatalog       thrpt   8         5    1      350.983       21.199    ops/s
string
i.g.j.string.BoonBenchmark.citmCatalog                     thrpt   8         5    1      589.603       32.688    ops/s
i.g.j.string.BoonCharacterSequenceBenchMark.citmCatalog    thrpt   8         5    1      590.683       22.074    ops/s
i.g.j.string.GSONBenchmark.citmCatalog                     thrpt   8         5    1      419.830       40.693    ops/s
i.g.j.string.JacksonASTBenchmark.citmCatalog               thrpt   8         5    1      306.390       15.029    ops/s
i.g.j.string.JacksonObjectBenchmark.citmCatalog            thrpt   8         5    1      318.053       16.880    ops/s
i.g.j.string.JsonSmartBenchmark.citmCatalog                thrpt   8         5    1      355.843       22.255    ops/s

```


1 warm-up
Optimization 2

```
Benchmark                                              Mode Thr     Count  Sec         Mean   Mean error    Units
bytes
i.g.j.bytes.BoonBenchmark.medium                      thrpt   8         5    1   399243.743    62196.133    ops/s
i.g.j.bytes.GSONBenchmark.medium                      thrpt   8         5    1   272056.607    81816.346    ops/s
i.g.j.bytes.JacksonASTBenchmark.medium                thrpt   8         5    1   374466.083    53820.539    ops/s
i.g.j.bytes.JacksonObjectBenchmark.medium             thrpt   8         5    1   301776.590   120239.705    ops/s
i.g.j.bytes.JsonSmartBenchmark.medium                 thrpt   8         5    1   276518.383    45386.617    ops/s
stream
i.g.j.inputStream.BoonBenchmark.medium                thrpt   8         5    1   160257.603    36129.635    ops/s
i.g.j.inputStream.GSONBenchmark.medium                thrpt   8         5    1   113724.713    56064.618    ops/s
i.g.j.inputStream.JacksonASTBenchmark.medium          thrpt   8         5    1   128157.543   134502.152    ops/s
i.g.j.inputStream.JacksonObjectBenchmark.medium       thrpt   8         5    1   126100.847    90562.800    ops/s
string
i.g.j.string.BoonBenchmark.medium                     thrpt   8         5    1   325846.617    92375.586    ops/s
i.g.j.string.BoonCharacterSequenceBenchMark.medium    thrpt   8         5    1   466013.417    62494.732    ops/s
i.g.j.string.GSONBenchmark.medium                     thrpt   8         5    1   268420.253    72867.882    ops/s
i.g.j.string.JacksonASTBenchmark.medium               thrpt   8         5    1   239763.487   119743.263    ops/s
i.g.j.string.JacksonObjectBenchmark.medium            thrpt   8         5    1   239958.903    55348.635    ops/s
i.g.j.string.JsonSmartBenchmark.medium                thrpt   8         5    1   312084.100    28782.277    ops/s
```

Optmization 2 2MB 

```
Benchmark                                                   Mode Thr     Count  Sec         Mean   Mean error    Units
bytes
i.g.j.bytes.BoonBenchmark.citmCatalog                      thrpt   8         5    1      492.520       86.823    ops/s
i.g.j.bytes.GSONBenchmark.citmCatalog                      thrpt   8         5    1      395.413       64.481    ops/s
i.g.j.bytes.JacksonASTBenchmark.citmCatalog                thrpt   8         5    1      373.497      204.279    ops/s
i.g.j.bytes.JacksonObjectBenchmark.citmCatalog             thrpt   8         5    1      364.330      115.620    ops/s
i.g.j.bytes.JsonSmartBenchmark.citmCatalog                 thrpt   8         5    1      300.953      144.286    ops/s
stream
i.g.j.inputStream.BoonBenchmark.citmCatalog                thrpt   8         5    1      398.873       85.204    ops/s
i.g.j.inputStream.GSONBenchmark.citmCatalog                thrpt   8         5    1      331.230       60.375    ops/s
i.g.j.inputStream.JacksonASTBenchmark.citmCatalog          thrpt   8         5    1      271.857      210.069    ops/s
i.g.j.inputStream.JacksonObjectBenchmark.citmCatalog       thrpt   8         5    1      291.733      145.984    ops/s
String
i.g.j.string.BoonBenchmark.citmCatalog                     thrpt   8         5    1      546.653       73.946    ops/s
i.g.j.string.BoonCharacterSequenceBenchMark.citmCatalog    thrpt   8         5    1      551.000       83.382    ops/s
i.g.j.string.GSONBenchmark.citmCatalog                     thrpt   8         5    1      384.077       66.253    ops/s
i.g.j.string.JacksonASTBenchmark.citmCatalog               thrpt   8         5    1      256.113      109.586    ops/s
i.g.j.string.JacksonObjectBenchmark.citmCatalog            thrpt   8         5    1      250.663      124.434    ops/s
i.g.j.string.JsonSmartBenchmark.citmCatalog                thrpt   8         5    1      328.350       44.345    ops/s
```

12/15/13



Optimization 1 2 MB file (From String)
```
Benchmark                                              Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.citmCatalog                     thrpt   8         5    1      634.490      161.698    ops/s
i.g.j.s.BoonCharacterSequenceBenchMark.citmCatalog    thrpt   8         5    1      554.517       36.224    ops/s
i.g.j.s.GSONBenchmark.citmCatalog                     thrpt   8         5    1      398.407       33.769    ops/s
i.g.j.s.JacksonASTBenchmark.citmCatalog               thrpt   8         5    1      311.417        9.404    ops/s
i.g.j.s.JacksonObjectBenchmark.citmCatalog            thrpt   8         5    1      310.427       28.941    ops/s
i.g.j.s.JsonSmartBenchmark.citmCatalog                thrpt   8         5    1      364.003       11.225    ops/s
```

Optimization 1 2 MB file (from bytes)
```
Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchmark.citmCatalog             thrpt   8         5    1      577.847       33.689    ops/s
i.g.j.b.GSONBenchmark.citmCatalog             thrpt   8         5    1      452.947       30.377    ops/s
i.g.j.b.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      389.663      110.508    ops/s
i.g.j.b.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      365.137       71.960    ops/s
i.g.j.b.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      272.030      107.993    ops/s
```

Optimization 1 2 MB file (from input stream)
```
Benchmark                                                Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.inputStream.BoonBenchmark.citmCatalog             thrpt   8         5    1      538.933        7.130    ops/s
i.g.j.inputStream.GSONBenchmark.citmCatalog             thrpt   8         5    1      407.733       42.164    ops/s
i.g.j.inputStream.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      379.237       34.670    ops/s
i.g.j.inputStream.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      349.427       49.306    ops/s
```


Optimization 1 webxml file (from input stream)
```
Benchmark                                           Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.inputStream.BoonBenchmark.webxml             thrpt   8         5    1   153473.453     2432.691    ops/s
i.g.j.inputStream.GSONBenchmark.webxml             thrpt   8         5    1    99381.280     2997.789    ops/s
i.g.j.inputStream.JacksonASTBenchmark.webxml       thrpt   8         5    1   120798.840     1797.505    ops/s
i.g.j.inputStream.JacksonObjectBenchmark.webxml    thrpt   8         5    1   101469.583    26395.522    ops/s
```

Optimization 1 webxml file (from string and bytes)

```
Benchmark                                              Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.bytes.BoonBenchmark.webxml                      thrpt   8         5    1   243897.070     2004.897    ops/s
i.g.j.bytes.GSONBenchmark.webxml                      thrpt   8         5    1   145293.453     2244.048    ops/s
i.g.j.bytes.JacksonASTBenchmark.webxml                thrpt   8         5    1   195156.710     8402.572    ops/s
i.g.j.bytes.JacksonObjectBenchmark.webxml             thrpt   8         5    1   166488.157    21522.238    ops/s
i.g.j.bytes.JsonSmartBenchmark.webxml                 thrpt   8         5    1   153111.840     9095.388    ops/s

i.g.j.string.BoonBenchmark.webxml                     thrpt   8         5    1   249912.307    19361.926    ops/s
i.g.j.string.BoonCharacterSequenceBenchMark.webxml    thrpt   8         5    1   266623.943    10615.374    ops/s
i.g.j.string.GSONBenchmark.webxml                     thrpt   8         5    1   132536.827    15160.406    ops/s
i.g.j.string.JacksonASTBenchmark.webxml               thrpt   8         5    1   148642.550     7133.436    ops/s
i.g.j.string.JacksonObjectBenchmark.webxml            thrpt   8         5    1   148273.823     6390.983    ops/s
i.g.j.string.JsonSmartBenchmark.webxml                thrpt   8         5    1   173956.203     3314.959    ops/s
```


Optimization 1 medium

```
bytes[]
Benchmark                                              Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.bytes.BoonBenchmark.medium                      thrpt   8         5    1   394104.150    71284.602    ops/s
i.g.j.bytes.GSONBenchmark.medium                      thrpt   8         5    1   270688.050    77677.140    ops/s
i.g.j.bytes.JacksonASTBenchmark.medium                thrpt   8         5    1   380602.207    54750.541    ops/s
i.g.j.bytes.JacksonObjectBenchmark.medium             thrpt   8         5    1   343228.970    50054.425    ops/s
i.g.j.bytes.JsonSmartBenchmark.medium                 thrpt   8         5    1   282828.397    31699.294    ops/s

string
i.g.j.string.BoonBenchmark.medium                     thrpt   8         5    1   410202.460    47389.489    ops/s
i.g.j.string.BoonCharacterSequenceBenchMark.medium    thrpt   8         5    1   361550.043    25223.089    ops/s
i.g.j.string.GSONBenchmark.medium                     thrpt   8         5    1   288093.323    77267.217    ops/s
i.g.j.string.JacksonASTBenchmark.medium               thrpt   8         5    1   267662.703    35289.327    ops/s
i.g.j.string.JacksonObjectBenchmark.medium            thrpt   8         5    1   251775.013    55411.458    ops/s
i.g.j.string.JsonSmartBenchmark.medium                thrpt   8         5    1   314237.510    34189.281    ops/s
```

12/12/13

I reversed the logic in an if statement so all of the tests from last time were in fact using Index Overlay.
I was wondering why Boon Original was faster than usual.
Boon wins with and without Index Overlay, but it kills with Index Overlay.

Eagle eye Stephane caught it.

"Iron sharpens iron, and one man sharpens another." Stéphane Landelle keeps me sharp.

In my defense, it was 2:00 AM, and I just spent a lot of time figuring out how to make
the reader and input stream fast for small json objects, which seemed easy at first.
Ok... no excuses. When I err in the future, I will try to not make it so beneficial for Boon in the benchmarks.
Then again, if it had been un-beneficial, I would have investigated more, and been up until 3:00 AM.




```

InputStream:

java -jar target/microbenchmarks.jar ".*inputStream.*Catalog" -wi 1 -i 5 -f 1 -t 8


2 MB file
Benchmark                                                Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.inputStream.BoonBenchmark.citmCatalog             thrpt   8         5    1      519.593       69.776    ops/s
i.g.j.inputStream.GSONBenchmark.citmCatalog             thrpt   8         5    1      451.263       53.521    ops/s
i.g.j.inputStream.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      445.817      103.189    ops/s
i.g.j.inputStream.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      435.343      177.298    ops/s
i.g.j.inputStream.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1        1.520        0.078    ops/s

```

So boon still wins but it is a bit more of a barn burner. It only wins by 10% vs 20% so the index overlay is worth 10% bump.
I don't know why JsonSmart is crapping out with input stream.
Seems like a bug.


```
Reader:

java -jar target/microbenchmarks.jar ".*reader.*Catalog" -wi 1 -i 5 -f 1 -t 8

Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.r.BoonBenchmark.citmCatalog             thrpt   8         5    1      523.957       98.658    ops/s
i.g.j.r.GSONBenchmark.citmCatalog             thrpt   8         5    1      470.943       59.258    ops/s
i.g.j.r.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      348.013      130.373    ops/s
i.g.j.r.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      305.013      224.284    ops/s
i.g.j.r.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      167.630      107.602    ops/s

```
Boon wins.

Here is an area were Jackson probably has some low hanging fruit. I/O should be an easy thing to fix.
Ditto JsonSmart, it should be easy to patch it to go faster with readers.


Doing 2 MB files for I/O is not really Jackson's and JsonSmart's tihng. Boon is not optimized for large JSON files.
Boon will break at some upper level as it reads in the whole file. I can change that for larger files as part of the factory.


String:

```
java -jar target/microbenchmarks.jar ".*string.*Catalog" -wi 1 -i 5 -f 1 -t 8


Benchmark                                              Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.citmCatalog                     thrpt   8         5    1      662.233      183.344    ops/s
i.g.j.s.BoonCharacterSequenceBenchMark.citmCatalog    thrpt   8         5    1      667.513      194.512    ops/s
i.g.j.s.GSONBenchmark.citmCatalog                     thrpt   8         5    1      588.087       75.207    ops/s
i.g.j.s.JacksonASTBenchmark.citmCatalog               thrpt   8         5    1      457.517       45.140    ops/s
i.g.j.s.JacksonObjectBenchmark.citmCatalog            thrpt   8         5    1      433.327      105.863    ops/s
i.g.j.s.JsonSmartBenchmark.citmCatalog                thrpt   8         5    1      493.080       37.880    ops/s

```
This is what Boon was designed for direct buffer parsing so it "should" win.

Byte []:

```

java -jar target/microbenchmarks.jar ".*byte.*Catalog" -wi 1 -i 5 -f 1 -t 8

Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchmark.citmCatalog             thrpt   8         5    1      579.000       64.515    ops/s
i.g.j.b.GSONBenchmark.citmCatalog             thrpt   8         5    1      515.243       64.504    ops/s
i.g.j.b.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      542.937       73.014    ops/s
i.g.j.b.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      537.670      149.332    ops/s
i.g.j.b.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      508.993       50.435    ops/s

```
This one is really close. Jackson and JsonSmart are very good at handling buffers.
Boon barely pulls ahead. It is a squeaker.
If you add more warm-up, then boon does gets a bit more faster


Byte [] with 3 warm-up runs

```

java -jar target/microbenchmarks.jar ".*byte.*Catalog" -wi 3 -i 5 -f 1 -t 8

Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchmark.citmCatalog             thrpt   8         5    1      602.967       32.908    ops/s
i.g.j.b.GSONBenchmark.citmCatalog             thrpt   8         5    1      545.617        7.057    ops/s
i.g.j.b.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      532.730       32.427    ops/s
i.g.j.b.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      552.733       17.726    ops/s
i.g.j.b.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      490.960       25.297    ops/s
```

Boon does have some buffers that it will reuse and they grow to a certain size,
but it is determined at runtime so if it has a longer warm-up, it does a bit better.
It wins with or without warmup by design.



Byte [] with no warm-up runs
```
java -jar target/microbenchmarks.jar ".*byte.*Catalog" -wi 0 -i 5 -f 1 -t 8

Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchmark.citmCatalog             thrpt   8         5    1      501.190      294.544    ops/s
i.g.j.b.GSONBenchmark.citmCatalog             thrpt   8         5    1      465.920      248.137    ops/s
i.g.j.b.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      462.120      330.133    ops/s
i.g.j.b.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      447.237      436.156    ops/s
i.g.j.b.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      422.917      157.837    ops/s
```

But is also does the best with no warm up too. This took a bit of doing, which is why I point it out.
There was some engineering trade-offs to get it to the point where it could win with no warm-up and win with a lot of warm-up.


So how does Boon do for small files? Glad you asked!        (42 byte files)
```
Byte []:
java -jar target/microbenchmarks.jar ".*byte.*small" -wi 1 -i 5 -f 1 -t 8


42 bytes
Benchmark                                Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchmark.small             thrpt   8         5    1 15123035.083   693984.145    ops/s
i.g.j.b.GSONBenchmark.small             thrpt   8         5    1  1192185.707    25317.681    ops/s
i.g.j.b.JacksonASTBenchmark.small       thrpt   8         5    1  9021593.730   793040.461    ops/s
i.g.j.b.JacksonObjectBenchmark.small    thrpt   8         5    1  3541216.870   287244.838    ops/s
i.g.j.b.JsonSmartBenchmark.small        thrpt   8         5    1  8081251.127   530501.696    ops/s


medium      2K file

Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchmark.medium             thrpt   8         5    1   429419.907     5534.696    ops/s
i.g.j.b.GSONBenchmark.medium             thrpt   8         5    1   334178.480      942.534    ops/s
i.g.j.b.JacksonASTBenchmark.medium       thrpt   8         5    1   460427.767    32371.545    ops/s
i.g.j.b.JacksonObjectBenchmark.medium    thrpt   8         5    1   443674.033    20546.285    ops/s
i.g.j.b.JsonSmartBenchmark.medium        thrpt   8         5    1   393696.657     9828.938    ops/s



4K file

Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchmark.webxml             thrpt   8         5    1   245015.280    14697.453    ops/s
i.g.j.b.GSONBenchmark.webxml             thrpt   8         5    1   165580.290    10785.195    ops/s
i.g.j.b.JacksonASTBenchmark.webxml       thrpt   8         5    1   236637.437    29521.703    ops/s
i.g.j.b.JacksonObjectBenchmark.webxml    thrpt   8         5    1   220641.790    14118.598    ops/s
i.g.j.b.JsonSmartBenchmark.webxml        thrpt   8         5    1   189752.833    12327.982    ops/s

```

Jackson does good at this test! Boon wins overall, but Jackson wins the medium by a nose.


```

String parse:

42 byte file
Benchmark                                        Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.small                     thrpt   8         5    1 10398494.800   761673.116    ops/s
i.g.j.s.BoonCharacterSequenceBenchMark.small    thrpt   8         5    1  9182087.223   476059.086    ops/s
i.g.j.s.GSONBenchmark.small                     thrpt   8         5    1  3890901.160    76851.698    ops/s
i.g.j.s.JacksonASTBenchmark.small               thrpt   8         5    1  5194224.027   570461.814    ops/s
i.g.j.s.JacksonObjectBenchmark.small            thrpt   8         5    1  3342081.950   144442.432    ops/s
i.g.j.s.JsonSmartBenchmark.small                thrpt   8         5    1  9044707.127   599709.622    ops/s



2K file
Benchmark                                         Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.medium                     thrpt   8         5    1   616710.030    47455.348    ops/s
i.g.j.s.BoonCharacterSequenceBenchMark.medium    thrpt   8         5    1   587532.047    42655.252    ops/s
i.g.j.s.GSONBenchmark.medium                     thrpt   8         5    1   398540.567    24613.368    ops/s
i.g.j.s.JacksonASTBenchmark.medium               thrpt   8         5    1   363896.803    54004.333    ops/s
i.g.j.s.JacksonObjectBenchmark.medium            thrpt   8         5    1   366004.663    15697.203    ops/s
i.g.j.s.JsonSmartBenchmark.medium                thrpt   8         5    1   410287.210    32399.409    ops/s

4K file
Benchmark                                         Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.webxml                     thrpt   8         5    1   301771.997    30260.172    ops/s
i.g.j.s.BoonCharacterSequenceBenchMark.webxml    thrpt   8         5    1   301385.873    23396.885    ops/s
i.g.j.s.GSONBenchmark.webxml                     thrpt   8         5    1   188973.330    10277.004    ops/s
i.g.j.s.JacksonASTBenchmark.webxml               thrpt   8         5    1   200984.880    24122.348    ops/s
i.g.j.s.JacksonObjectBenchmark.webxml            thrpt   8         5    1   204084.740    13711.697    ops/s
i.g.j.s.JsonSmartBenchmark.webxml                thrpt   8         5    1   217610.740    22550.308    ops/s

```

String parsing is Boon home turf. The original was just working with strings direct.

So how does Boon do for input streams? Glad you asked!

```
Input Stream:

42 byte file
Benchmark                                          Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.inputStream.BoonBenchmark.small             thrpt   8         5    1   200480.753   151900.093    ops/s
i.g.j.inputStream.GSONBenchmark.small             thrpt   8         5    1    49230.283    61934.864    ops/s
i.g.j.inputStream.JacksonASTBenchmark.small       thrpt   8         5    1    78701.830    82360.907    ops/s
i.g.j.inputStream.JacksonObjectBenchmark.small    thrpt   8         5    1    80853.560    87854.756    ops/s
i.g.j.inputStream.JsonSmartBenchmark.small        thrpt   8         5    1     5702.100     2590.905    ops/s

2K file
Benchmark                                           Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.inputStream.BoonBenchmark.medium             thrpt   8         5    1   129235.727   137370.866    ops/s
i.g.j.inputStream.GSONBenchmark.medium             thrpt   8         5    1    30266.503    46403.880    ops/s
i.g.j.inputStream.JacksonASTBenchmark.medium       thrpt   8         5    1    50367.613    68028.710    ops/s
i.g.j.inputStream.JacksonObjectBenchmark.medium    thrpt   8         5    1    38941.223    64478.924    ops/s
i.g.j.inputStream.JsonSmartBenchmark.medium        thrpt   8         5    1       91.240       14.803    ops/s

4K file
Benchmark                                           Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.inputStream.BoonBenchmark.webxml             thrpt   8         5    1    32539.403    42163.956    ops/s
i.g.j.inputStream.GSONBenchmark.webxml             thrpt   8         5    1    23009.150    31557.954    ops/s
i.g.j.inputStream.JacksonASTBenchmark.webxml       thrpt   8         5    1    27000.077    40663.720    ops/s
i.g.j.inputStream.JacksonObjectBenchmark.webxml    thrpt   8         5    1    18180.853    33141.042    ops/s
i.g.j.inputStream.JsonSmartBenchmark.webxml        thrpt   8         5    1       51.310        4.512    ops/s

```

Boon wins all.

```
Reader:

Benchmark                                Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.r.BoonBenchmark.small             thrpt   8         5    1    64920.943    36417.121    ops/s
i.g.j.r.GSONBenchmark.small             thrpt   8         5    1    49324.087    45658.575    ops/s
i.g.j.r.JacksonASTBenchmark.small       thrpt   8         5    1    57271.130    41800.493    ops/s
i.g.j.r.JacksonObjectBenchmark.small    thrpt   8         5    1    51874.413    51769.722    ops/s
i.g.j.r.JsonSmartBenchmark.small        thrpt   8         5    1    58998.330    54932.838    ops/s

Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.r.BoonBenchmark.webxml             thrpt   8         5    1    25590.903    38271.319    ops/s
i.g.j.r.GSONBenchmark.webxml             thrpt   8         5    1    20976.117    27406.970    ops/s
i.g.j.r.JacksonASTBenchmark.webxml       thrpt   8         5    1    19280.653    25890.651    ops/s
i.g.j.r.JacksonObjectBenchmark.webxml    thrpt   8         5    1     9324.493    10121.377    ops/s
i.g.j.r.JsonSmartBenchmark.webxml        thrpt   8         5    1    11982.480    17529.240    ops/s


Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.r.BoonBenchmark.medium             thrpt   8         5    1    38104.587    50422.018    ops/s
i.g.j.r.GSONBenchmark.medium             thrpt   8         5    1    14186.850    15325.914    ops/s
i.g.j.r.JacksonASTBenchmark.medium       thrpt   8         5    1    23821.507    31810.843    ops/s
i.g.j.r.JacksonObjectBenchmark.medium    thrpt   8         5    1    15184.610    20938.918    ops/s
i.g.j.r.JsonSmartBenchmark.medium        thrpt   8         5    1    20156.300    29831.316    ops/s

```
Boon wins all.

The real test is boon vs. boon :)

```
Benchmark                                        Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchMarkBasic.small                thrpt   8         5    1 10061212.913  4015127.331    ops/s
i.g.j.b.BoonBenchMarkDirectBytes.small          thrpt   8         5    1 12372399.087  3663465.705    ops/s
i.g.j.b.BoonBenchMarkOverlay.small              thrpt   8         5    1 20446467.293 10435890.799    ops/s
i.g.j.b.BoonCharacterSequenceBenchMark.small    thrpt   8         5    1 12480818.117  5979164.569    ops/s

Benchmark                                         Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchMarkBasic.medium                thrpt   8         5    1   572797.510   230423.843    ops/s
i.g.j.b.BoonBenchMarkDirectBytes.medium          thrpt   8         5    1   391813.253   195272.691    ops/s
i.g.j.b.BoonBenchMarkOverlay.medium              thrpt   8         5    1   790967.587   257303.284    ops/s
i.g.j.b.BoonCharacterSequenceBenchMark.medium    thrpt   8         5    1   543188.530   218936.620    ops/s

Benchmark                                         Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchMarkBasic.webxml                thrpt   8         5    1   278279.273   111067.899    ops/s
i.g.j.b.BoonBenchMarkDirectBytes.webxml          thrpt   8         5    1   192240.527   113846.316    ops/s
i.g.j.b.BoonBenchMarkOverlay.webxml              thrpt   8         5    1   399702.727   129631.653    ops/s
i.g.j.b.BoonCharacterSequenceBenchMark.webxml    thrpt   8         5    1   269917.560   120388.408    ops/s
```

Boon JSON is really a series of parsers that it picks from depending on what type of stream, buffer, reader you give it.

It can work directly with CharacterBuffer, StringBuilder, String, char[], byte[], etc.



12/11/2013

Cleaned up API and added support for streams and Readers.

```
Now to create you always use:

    private final JsonParser parser = new JsonParserFactory ().create ();

The above should create the fastest version.


Reading from an input stream (no overlay)

        return parser.parse ( Map.class, Files.newInputStream ( IO.path (str) ) );



Benchmark                                                Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.inputStream.BoonBenchmark.citmCatalog             thrpt   8         5    1      591.030       95.022    ops/s
i.g.j.inputStream.GSONBenchmark.citmCatalog             thrpt   8         5    1      454.740       72.404    ops/s
i.g.j.inputStream.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      343.510      130.131    ops/s
i.g.j.inputStream.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      306.750      232.646    ops/s
i.g.j.inputStream.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      170.573      108.242    ops/s


Boon!


Reading from a reader: (1 warm up)

        return parser.parse ( Map.class, Files.newBufferedReader ( IO.path (str), StandardCharsets.UTF_8) );


Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.r.BoonBenchmark.citmCatalog             thrpt   8         5    1      605.507       64.301    ops/s
i.g.j.r.GSONBenchmark.citmCatalog             thrpt   8         5    1      464.417       87.228    ops/s
i.g.j.r.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      346.737      123.593    ops/s
i.g.j.r.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      322.493      140.439    ops/s
i.g.j.r.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      159.227      104.295    ops/s

Boon!




Reading from a byte array

        return parser.parse ( Map.class, bytes );



Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.b.BoonBenchmark.citmCatalog             thrpt   8         5    1      702.777       90.096    ops/s
i.g.j.b.GSONBenchmark.citmCatalog             thrpt   8         5    1      526.280       63.247    ops/s
i.g.j.b.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      549.133       58.235    ops/s
i.g.j.b.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      499.567      106.604    ops/s
i.g.j.b.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      449.580       32.700    ops/s



Reading from a string (just 1 warm up, no overlay)

    private final JsonParser parser = new JsonParserFactory ().create (); //BoonBenchmark
    private final JsonParser parser = new JsonParserFactory ().neverUseDirectBytes ().preferCharSequence ().create ();
                                                                //BoonCharacterSequenceBenchMark


        return parser.parse ( Map.class, str );



Benchmark                                              Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.s.BoonBenchmark.citmCatalog                     thrpt   8         5    1      872.547       54.457    ops/s
i.g.j.s.BoonCharacterSequenceBenchMark.citmCatalog    thrpt   8         5    1      877.577       54.432    ops/s
i.g.j.s.GSONBenchmark.citmCatalog                     thrpt   8         5    1      597.723       44.193    ops/s
i.g.j.s.JacksonASTBenchmark.citmCatalog               thrpt   8         5    1      430.503       55.879    ops/s
i.g.j.s.JacksonObjectBenchmark.citmCatalog            thrpt   8         5    1      427.220       27.186    ops/s
i.g.j.s.JsonSmartBenchmark.citmCatalog                thrpt   8         5    1      491.897       21.479    ops/s



It wins with Stings, char[], reader, input stream and byte [] for large and small files.

The tricky part was getting the reader and input stream to work for both the big files and the small files.


Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.r.BoonBenchmark.medium             thrpt   8         5    1   207489.560     5370.610    ops/s
i.g.j.r.GSONBenchmark.medium             thrpt   8         5    1   158347.813     3512.490    ops/s
i.g.j.r.JacksonASTBenchmark.medium       thrpt   8         5    1   154176.247     8947.828    ops/s
i.g.j.r.JacksonObjectBenchmark.medium    thrpt   8         5    1   148923.023     7604.071    ops/s
i.g.j.r.JsonSmartBenchmark.medium        thrpt   8         5    1    99780.213    35766.399    ops/s


Benchmark                                 Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.j.r.BoonBenchmark.webxml             thrpt   8         5    1   172111.203     5963.459    ops/s
i.g.j.r.GSONBenchmark.webxml             thrpt   8         5    1   110256.410     3945.778    ops/s
i.g.j.r.JacksonASTBenchmark.webxml       thrpt   8         5    1   114400.587    30624.423    ops/s
i.g.j.r.JacksonObjectBenchmark.webxml    thrpt   8         5    1   105170.040    41050.383    ops/s
i.g.j.r.JsonSmartBenchmark.webxml        thrpt   8         5    1    60521.663    23001.652    ops/s

```
12/9/2013

```
Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonBenchmark.actionLabel             thrpt   8         5    1   952181.033    49994.359    ops/s
i.g.b.j.GSONBenchmark.actionLabel             thrpt   8         5    1   454655.750    38697.027    ops/s
i.g.b.j.JacksonASTBenchmark.actionLabel       thrpt   8         5    1   687899.190    92115.124    ops/s
i.g.b.j.JacksonObjectBenchmark.actionLabel    thrpt   8         5    1   631883.253    58187.074    ops/s
i.g.b.j.JsonSmartBenchmark.actionLabel        thrpt   8         5    1   638245.510    28490.542    ops/s
Winner boon

Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonBenchmark.citmCatalog             thrpt   8         5    1      595.320      226.746    ops/s
i.g.b.j.GSONBenchmark.citmCatalog             thrpt   8         5    1      519.460       67.587    ops/s
i.g.b.j.JacksonASTBenchmark.citmCatalog       thrpt   8         5    1      522.447      132.712    ops/s
i.g.b.j.JacksonObjectBenchmark.citmCatalog    thrpt   8         5    1      560.960       70.337    ops/s
i.g.b.j.JsonSmartBenchmark.citmCatalog        thrpt   8         5    1      498.567       20.052    ops/s
Winner boon


Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonBenchmark.medium                  thrpt   8         5    1   717076.143    66137.610    ops/s
i.g.b.j.GSONBenchmark.medium                  thrpt   8         5    1   323030.350    28039.737    ops/s
i.g.b.j.JacksonASTBenchmark.medium            thrpt   8         5    1   466943.663    40722.303    ops/s
i.g.b.j.JacksonObjectBenchmark.medium         thrpt   8         5    1   452389.270    38322.667    ops/s
i.g.b.j.JsonSmartBenchmark.medium             thrpt   8         5    1   385977.377    29823.120    ops/s
Winner boon

Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonBenchmark.menu                    thrpt   8         5    1  3160492.197   280592.358    ops/s
i.g.b.j.GSONBenchmark.menu                    thrpt   8         5    1   821103.300    53954.500    ops/s
i.g.b.j.JacksonASTBenchmark.menu              thrpt   8         5    1  2042108.620   208072.795    ops/s
i.g.b.j.JacksonObjectBenchmark.menu           thrpt   8         5    1  1880851.927   222762.253    ops/s
i.g.b.j.JsonSmartBenchmark.menu               thrpt   8         5    1  2025717.690    85594.849    ops/s
Winner boon

Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonBenchmark.sgml                    thrpt   8         5    1  2008532.590   196291.511    ops/s
i.g.b.j.GSONBenchmark.sgml                    thrpt   8         5    1   718620.370    42423.609    ops/s
i.g.b.j.JacksonASTBenchmark.sgml              thrpt   8         5    1  1323524.563   154470.599    ops/s
i.g.b.j.JacksonObjectBenchmark.sgml           thrpt   8         5    1  1222662.750   140235.072    ops/s
i.g.b.j.JsonSmartBenchmark.sgml               thrpt   8         5    1  1074628.607   118118.963    ops/s
Winner boon

Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonBenchmark.small                   thrpt   8         5    1 15826710.817  1045854.168    ops/s
i.g.b.j.GSONBenchmark.small                   thrpt   8         5    1  1214721.220    26642.421    ops/s
i.g.b.j.JacksonASTBenchmark.small             thrpt   8         5    1  8717521.267   803443.056    ops/s
i.g.b.j.JacksonObjectBenchmark.small          thrpt   8         5    1  3596064.317   109024.645    ops/s
i.g.b.j.JsonSmartBenchmark.small              thrpt   8         5    1  8496899.873   519262.035    ops/s
Winner boon


Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonBenchmark.webxml                  thrpt   8         5    1   371945.473    37984.891    ops/s
i.g.b.j.GSONBenchmark.webxml                  thrpt   8         5    1   166292.277    14117.248    ops/s
i.g.b.j.JacksonASTBenchmark.webxml            thrpt   8         5    1   244590.407    24276.624    ops/s
i.g.b.j.JacksonObjectBenchmark.webxml         thrpt   8         5    1   235309.430    20480.132    ops/s
i.g.b.j.JsonSmartBenchmark.webxml             thrpt   8         5    1   206388.830    20392.364    ops/s
Winner boon

Benchmark                                      Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonBenchmark.widget                  thrpt   8         5    1  1896055.073   122966.480    ops/s
i.g.b.j.GSONBenchmark.widget                  thrpt   8         5    1   655790.267    37677.131    ops/s
i.g.b.j.JacksonASTBenchmark.widget            thrpt   8         5    1  1162009.513   116017.073    ops/s
i.g.b.j.JacksonObjectBenchmark.widget         thrpt   8         5    1  1073394.043    52104.314    ops/s
i.g.b.j.JsonSmartBenchmark.widget             thrpt   8         5    1   893633.533    60634.631    ops/s
Winner boon


```

## Figures


Don't like losing so I wrote a UTF-8 direct decoder.
It is not done yet, but it works for most languages of the world.
It needs some elbow grease.

```
Benchmark                                             Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonUTF8BenchMark.citmCatalog                thrpt   8         5    1      452.143       64.105    ops/s
i.g.b.j.JacksonASTBenchmark.citmCatalog              thrpt   8         5    1      375.823       94.691    ops/s
i.g.b.j.GSONBenchmark.citmCatalog                    thrpt   8         5    1      360.707       50.222    ops/s
i.g.b.j.JacksonObjectBenchmark.citmCatalog           thrpt   8         5    1      325.630      203.290    ops/s
i.g.b.j.BoonOverlayBenchmark.citmCatalog             thrpt   8         5    1      303.947      110.573    ops/s
i.g.b.j.BoonBenchmark.citmCatalog                    thrpt   8         5    1      293.320       78.960    ops/s
i.g.b.j.JsonSmartBenchmark.citmCatalog               thrpt   8         5    1      286.890       51.478    ops/s
i.g.b.j.BoonOverlayUseValuesBenchmark.citmCatalog    thrpt   8         5    1      275.387      102.080    ops/s
```

(When I added more UTF processing, the parser got slower.)


```
Benchmark                                             Mode Thr     Count  Sec         Mean   Mean error    Units

i.g.b.j.UTF8BoonBenchMark.citmCatalog                thrpt   8         5    1      388.137      164.962    ops/s
i.g.b.j.JacksonASTBenchmark.citmCatalog              thrpt   8         5    1      362.200       15.880    ops/s
i.g.b.j.JacksonObjectBenchmark.citmCatalog           thrpt   8         5    1      344.530       19.037    ops/s
i.g.b.j.GSONBenchmark.citmCatalog                    thrpt   8         5    1      330.493       16.969    ops/s
i.g.b.j.BoonOverlayUseValuesBenchmark.citmCatalog    thrpt   8         5    1      293.547       14.697    ops/s
i.g.b.j.BoonOverlayBenchmark.citmCatalog             thrpt   8         5    1      296.190       17.858    ops/s
i.g.b.j.BoonBenchmark.citmCatalog                    thrpt   8         5    1      267.823      120.213    ops/s
i.g.b.j.JsonSmartBenchmark.citmCatalog               thrpt   8         5    1      264.960       51.405    ops/s

```
Boon wins for large files (as long as you are using UTF-8).


Boon 1st, 5th.

Full run....

```
Benchmark                                             Mode Thr     Count  Sec         Mean   Mean error    Units

i.g.b.j.BoonOverlayUseValuesBenchmark.actionLabel    thrpt   8         5    1   700386.517    26057.289    ops/s
i.g.b.j.BoonOverlayBenchmark.actionLabel             thrpt   8         5    1   687795.613    60328.627    ops/s
i.g.b.j.BoonBenchmark.actionLabel                    thrpt   8         5    1   591279.377   217157.451    ops/s
i.g.b.j.UTF8BoonBenchMark.actionLabel                thrpt   8         5    1   469742.763    94292.506    ops/s
i.g.b.j.JacksonObjectBenchmark.actionLabel           thrpt   8         5    1   435435.813     1986.267    ops/s
i.g.b.j.JacksonASTBenchmark.actionLabel              thrpt   8         5    1   435277.763    83070.620    ops/s
i.g.b.j.JsonSmartBenchmark.actionLabel               thrpt   8         5    1   389862.850    21393.479    ops/s
i.g.b.j.GSONBenchmark.actionLabel                    thrpt   8         5    1   334006.553     4034.842    ops/s

```

Boon comes in 1st, 2nd, 3rd, and 4th.

actionLabel is a sample JSON file from json.org.


```
Benchmark                                             Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.UTF8BoonBenchMark.medium                     thrpt   8         5    1   281333.790    40445.658    ops/s
i.g.b.j.BoonOverlayUseValuesBenchmark.medium         thrpt   8         5    1   478665.880    15013.553    ops/s
i.g.b.j.BoonOverlayBenchmark.medium                  thrpt   8         5    1   460493.740     6264.658    ops/s
i.g.b.j.BoonBenchmark.medium                         thrpt   8         5    1   342462.600     6829.679    ops/s
i.g.b.j.JacksonASTBenchmark.medium                   thrpt   8         5    1   299431.113     6196.001    ops/s
i.g.b.j.JsonSmartBenchmark.medium                    thrpt   8         5    1   226984.033    19883.827    ops/s
i.g.b.j.JacksonObjectBenchmark.medium                thrpt   8         5    1   281073.947    27209.735    ops/s
i.g.b.j.GSONBenchmark.medium                         thrpt   8         5    1   170840.277    36009.590    ops/s
```

Boon comes in 1st, 2nd, 3rd, and 4th.

medium is a sample JSON file from json.org.


```
Benchmark                                             Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonOverlayUseValuesBenchmark.menu           thrpt   8         5    1  2202578.033   284081.834    ops/s
i.g.b.j.BoonOverlayBenchmark.menu                    thrpt   8         5    1  2291626.220    70534.694    ops/s
i.g.b.j.BoonBenchmark.menu                           thrpt   8         5    1  1665647.143   131866.242    ops/s
i.g.b.j.JacksonASTBenchmark.menu                     thrpt   8         5    1  1495032.533    15397.196    ops/s
i.g.b.j.UTF8BoonBenchMark.menu                       thrpt   8         5    1  1486328.550   773895.002    ops/s
i.g.b.j.JsonSmartBenchmark.menu                      thrpt   8         5    1  1268697.987    45441.041    ops/s
i.g.b.j.JacksonObjectBenchmark.menu                  thrpt   8         5    1  1304778.207    66882.043    ops/s
i.g.b.j.GSONBenchmark.menu                           thrpt   8         5    1   704230.710    74884.076    ops/s
```

Boon comes in 1st, 2nd, and 3rd (and 5th).
menu is a sample JSON file from json.org.


```
Benchmark                                             Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonOverlayUseValuesBenchmark.sgml           thrpt   8         5    1  1332346.363    20730.967    ops/s
i.g.b.j.BoonOverlayBenchmark.sgml                    thrpt   8         5    1  1189660.957   236957.554    ops/s
i.g.b.j.BoonBenchmark.sgml                           thrpt   8         5    1   980327.000    50314.583    ops/s
i.g.b.j.JacksonASTBenchmark.sgml                     thrpt   8         5    1   849571.953    32276.910    ops/s
i.g.b.j.UTF8BoonBenchMark.sgml                       thrpt   8         5    1   842125.773   248563.659    ops/s
i.g.b.j.JacksonObjectBenchmark.sgml                  thrpt   8         5    1   807085.117    42436.085    ops/s
i.g.b.j.JsonSmartBenchmark.sgml                      thrpt   8         5    1   580780.117    90164.203    ops/s
i.g.b.j.GSONBenchmark.sgml                           thrpt   8         5    1   519062.947   102652.691    ops/s
```

Boon comes 1st, 2nd, 3rd and 5th.


```
Benchmark                                             Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonOverlayBenchmark.small                   thrpt   8         5    1 11088905.173   440024.225    ops/s
i.g.b.j.BoonOverlayUseValuesBenchmark.small          thrpt   8         5    1 10993422.690   603981.371    ops/s
i.g.b.j.UTF8BoonBenchMark.small                      thrpt   8         5    1 10654614.890   234500.853    ops/s
i.g.b.j.BoonBenchmark.small                          thrpt   8         5    1  7530059.907   116605.772    ops/s
i.g.b.j.JsonSmartBenchmark.small                     thrpt   8         5    1  6172540.803   124415.890    ops/s
i.g.b.j.JacksonASTBenchmark.small                    thrpt   8         5    1  6553357.653    86596.741    ops/s
i.g.b.j.JacksonObjectBenchmark.small                 thrpt   8         5    1  3134028.990     8574.558    ops/s
i.g.b.j.GSONBenchmark.small                          thrpt   8         5    1  1024879.003    40824.852    ops/s
```

Boon is pretty damn fast. It comes in first four places by wide margins.
10x faster than GSON.


```
Benchmark                                             Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonOverlayBenchmark.webxml                  thrpt   8         5    1   249220.297    15737.331    ops/s
i.g.b.j.BoonOverlayUseValuesBenchmark.webxml         thrpt   8         5    1   243986.650    15273.389    ops/s
i.g.b.j.BoonBenchmark.webxml                         thrpt   8         5    1   172174.797     2376.368    ops/s
i.g.b.j.UTF8BoonBenchMark.webxml                     thrpt   8         5    1   141293.230     9575.312    ops/s
i.g.b.j.JsonSmartBenchmark.webxml                    thrpt   8         5    1   135640.167     1018.724    ops/s
i.g.b.j.JacksonASTBenchmark.webxml                   thrpt   8         5    1   163216.223     2581.035    ops/s
i.g.b.j.JacksonObjectBenchmark.webxml                thrpt   8         5    1   155777.900     9121.396    ops/s
i.g.b.j.GSONBenchmark.webxml                         thrpt   8         5    1   115457.220     2131.953    ops/s
```

Boon comes in first 4 places.


```
Benchmark                                             Mode Thr     Count  Sec         Mean   Mean error    Units
i.g.b.j.BoonOverlayBenchmark.widget                  thrpt   8         5    1  1214457.967    83969.895    ops/s
i.g.b.j.BoonOverlayUseValuesBenchmark.widget         thrpt   8         5    1  1249334.607    51364.905    ops/s
i.g.b.j.UTF8BoonBenchMark.widget                     thrpt   8         5    1   838309.223     2168.186    ops/s
i.g.b.j.BoonBenchmark.widget                         thrpt   8         5    1   829675.247    94757.843    ops/s
i.g.b.j.JacksonASTBenchmark.widget                   thrpt   8         5    1   783792.747    45841.043    ops/s
i.g.b.j.JacksonObjectBenchmark.widget                thrpt   8         5    1   739040.463    23122.330    ops/s
i.g.b.j.JsonSmartBenchmark.widget                    thrpt   8         5    1   593591.270     7663.080    ops/s
i.g.b.j.GSONBenchmark.widget                         thrpt   8         5    1   495515.850    40145.539    ops/s
```


Boon comes in first 4 places.


```


Historical....

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
