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
