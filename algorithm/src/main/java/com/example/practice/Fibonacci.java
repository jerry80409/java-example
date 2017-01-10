package com.example.practice;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jerry on 2017/1/10.
 */
public class Fibonacci {
    static Map<Integer, BigInteger> dp = new HashMap();
    static {
        dp.put(0, BigInteger.ZERO);
        dp.put(1, BigInteger.ONE);
        dp.put(2, BigInteger.ONE);
        // ... init some com.example.practice.Fibonacci result
    }

    public BigInteger getResult(int n) {
        // return cache value
        if (dp.containsKey(n)) return dp.get(n);

        // recursive
        if (n <= 0) return BigInteger.ZERO;
        if (n == 1 || n == 2) return BigInteger.ONE;

        // add to cache
        dp.put(n, getResult(n - 1).add(getResult(n - 2)));

        return dp.get(n);
    }
}
