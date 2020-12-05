package logic;

import java.util.ArrayList;
import java.util.List;

public class PrimeCalculator {

    private List<Integer> primes = new ArrayList<>();

    public PrimeCalculator(int n) {
        boolean[] eratosfen = eratosfen(n);
        for (int i = 2; i < eratosfen.length; i++) {
            if (eratosfen[i]) primes.add(i);
        }
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    private boolean[] eratosfen(int max) {
        boolean[] primes = new boolean[max];
        for (int i = 0; i < max; i++) primes[i] = true;
        for (int i = 2; i*i <= max; i++)
            if (primes[i])
                for (int j = i * i; j < max; j += i) primes[j] = false;
        return primes;
    }
}
