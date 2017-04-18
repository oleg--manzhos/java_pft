package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by omanzhos on 4/14/2017.
 */
public class PrimeTests {

    @Test
    public void PrimeTest(){
        Assert.assertEquals(Primes.isPrime(6), true);
    }
}
