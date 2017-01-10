package com.example.practice;

import static org.junit.Assert.assertEquals;

import com.example.practice.Fibonacci;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by jerry on 2017/1/10.
 */
public class FibonacciTest {

    @Test
    public void testN1() {
        BigInteger expected = BigInteger.ZERO;
        BigInteger actual = new Fibonacci().getResult(-1);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test0() {
        BigInteger expected = BigInteger.ZERO;
        BigInteger actual = new Fibonacci().getResult(0);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test1() {
        BigInteger expected = BigInteger.ONE;
        BigInteger actual = new Fibonacci().getResult(1);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test2() {
        BigInteger expected = BigInteger.ONE;
        BigInteger actual = new Fibonacci().getResult(2);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test3() {
        BigInteger expected = new BigInteger("2");
        BigInteger actual = new Fibonacci().getResult(3);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test21() {
        BigInteger expected = new BigInteger("10946");
        BigInteger actual = new Fibonacci().getResult(21);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test40() {
        BigInteger expected = new BigInteger("102334155");
        BigInteger actual = new Fibonacci().getResult(40);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test50() {
        BigInteger expected = new BigInteger("12586269025");
        BigInteger actual = new Fibonacci().getResult(50);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test100() {
        BigInteger expected = new BigInteger("354224848179261915075");
        BigInteger actual = new Fibonacci().getResult(100);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test200() {
        BigInteger expected = new BigInteger("280571172992510140037611932413038677189525");
        BigInteger actual = new Fibonacci().getResult(200);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test201() {
        BigInteger expected = new BigInteger("453973694165307953197296969697410619233826");
        BigInteger actual = new Fibonacci().getResult(201);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test300() {
        BigInteger expected = new BigInteger("222232244629420445529739893461909967206666939096499764990979600");
        BigInteger actual = new Fibonacci().getResult(300);
        assertEquals(expected.toString(), actual.toString());
    }
}
