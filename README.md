# Scala iterators benchmark

Benchmark like in [this article][sml-article], but on newer Scala (2.11.7).

[sml-article]: http://www.scalaformachinelearning.com/2013/06/comparative-performance-of-scala.html


## Results
Running on late 2013 15’ MBP, Intel(R) Core(TM) i7-4960HQ CPU @ 2.60GHz, 16GiB .
Scala 2.11.8, JDK 1.8.0_65, VM 25.65-b0.

### IterBenchmark
```
Benchmark                (sizeInMega)  Mode  Cnt    Score   Error  Units
IterBenchmark.fold                  2  avgt   20    6.266 ± 0.144  ms/op
IterBenchmark.fold                 20  avgt   20   66.995 ± 1.060  ms/op
IterBenchmark.fold                 40  avgt   20  138.450 ± 4.701  ms/op
IterBenchmark.foreach               2  avgt   20    1.901 ± 0.025  ms/op
IterBenchmark.foreach              20  avgt   20   19.220 ± 0.406  ms/op
IterBenchmark.foreach              40  avgt   20   41.479 ± 1.325  ms/op
IterBenchmark.sumMethod             2  avgt   20    6.364 ± 0.259  ms/op
IterBenchmark.sumMethod            20  avgt   20   69.025 ± 0.733  ms/op
IterBenchmark.sumMethod            40  avgt   20  144.225 ± 5.743  ms/op
IterBenchmark.whileLoop             2  avgt   20    1.900 ± 0.018  ms/op
IterBenchmark.whileLoop            20  avgt   20   19.132 ± 0.189  ms/op
IterBenchmark.whileLoop            40  avgt   20   40.776 ± 0.621  ms/op
```

### BreezeBenchmark
(20M element `DenseVector`)
```
Benchmark                  Mode  Cnt   Score   Error  Units
BreezeBenchmark.breezeSum  avgt   20  19.158 ± 0.371  ms/op
```
