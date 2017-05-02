package by.mmjava.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by User on 5/2/2017.
 */
public class Primestests {
    @Test
    public void testPrimes ()
    {
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimes1 ()
    {
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
    }
    @Test
    public void testPrimesWhile ()
    {
        Assert.assertTrue(Primes.isPrimeWhile(Integer.MAX_VALUE));
    }
    @Test (enabled = false)
    public void testPrimesLong ()
    {
        long n=Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));
    }

}
