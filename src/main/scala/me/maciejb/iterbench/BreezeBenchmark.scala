package me.maciejb.iterbench

import java.util.concurrent.TimeUnit

import breeze.linalg.DenseVector
import org.openjdk.jmh.annotations._
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.{OptionsBuilder, Options}

@State(Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
class BreezeBenchmark {


  val size = 20 * 1000 * 1000
  val random = new scala.util.Random(System.currentTimeMillis)

  var vec: DenseVector[Float] = _

  @Setup
  def setup(): Unit = {
    vec = DenseVector.fill(size)(random.nextFloat())
  }

  @Benchmark
  def breezeSum(): Float = breeze.linalg.sum(vec)

}

object BreezeBenchmarkApp {

  def main(args: Array[String]) {
    val opt: Options = new OptionsBuilder()
      .include(classOf[BreezeBenchmark].getSimpleName)
      .forks(1)
      .warmupIterations(10)
      .build
    new Runner(opt).run
  }

}
