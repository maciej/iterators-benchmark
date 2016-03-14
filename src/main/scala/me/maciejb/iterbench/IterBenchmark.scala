package me.maciejb.iterbench

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.{OptionsBuilder, Options}

@State(Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
class IterBenchmark {

  @Param(Array("2", "20", "40"))
  var sizeInMega: Int = _

  var size: Int = _

  val random = new scala.util.Random(System.currentTimeMillis)

  var data: Array[Float] = _

  @Setup
  def setup(): Unit = {
    size = sizeInMega * 1000 * 1000
    data = Array.fill(size)(random.nextFloat)
  }

  @Benchmark
  def whileLoop(): Float = {
    var k = 0
    var sum = 0.0f
    val len = data.length
    while (k < len) {
      sum += data(k)
      k += 1
    }
    sum
  }

  @Benchmark
  def sumMethod(): Float = data.sum

  @Benchmark
  def fold(): Float = data.fold(0.0f)(_ + _)

  @Benchmark
  def foreach(): Float = {
    var sum = 0.0f
    data.foreach(sum += _)
    sum
  }

}

object IterBenchmarkApp {

  def main(args: Array[String]) {
    val opt: Options = new OptionsBuilder()
      .include(classOf[IterBenchmark].getSimpleName)
      .forks(1)
      .warmupIterations(10)
      .build
    new Runner(opt).run
  }

}
