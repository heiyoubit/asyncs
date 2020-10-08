package com.example.helloservice.test;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;
import site.ycsb.generator.Generator;

public class BitTest {

    /*@Benchmark
    @Warmup(iterations = 0)
    @Measurement(iterations = 300)
    public void multiply2_n_shift_not_overflow(Generator generator) {
        int result = 0;
        int y = 0;
        for (int j = 0; j < generator.divide.length; j++) {
            //被乘数x为2^n - j
            int x = generator.divide[j] - j;
            int ri = generator.divide.length - j - 1;
            y = generator.divide[ri];
            result += x * y;
            //为了和移位测试保持一致所以加上这一步
            result += y;
        }
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Measurement(iterations = 300)
    public void multiply2_n_mul_not_overflow(Generator generator) {
        int result = 0;
        int y = 0;
        for (int j = 0; j < generator.divide.length; j++) {
            int x = generator.divide[j] - j;
            int ri = generator.divide.length - j - 1;
            //为了防止乘法多了读取导致性能差异，这里虽然没必要，也读取一下
            y = generator.divide[ri];
            result += x << ri;
            //为了防止虚拟机优化代码将上面的给y赋值踢出循环，加上下面这一步
            result += y;
        }
    }*/

}
