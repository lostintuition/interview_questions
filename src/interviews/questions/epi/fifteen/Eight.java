package interviews.questions.epi.fifteen;

import base.InterviewQuestion;

import java.util.*;

public class Eight implements InterviewQuestion {

    private List<ABSqrt> getKSmallestNumbers(int k) {
        SortedSet<ABSqrt> candidates = new TreeSet<>();
        List<ABSqrt> results = new LinkedList<>();

        candidates.add(new ABSqrt(0, 0));

        while (results.size() < k) {
            ABSqrt nextValue = candidates.first();
            results.add(nextValue);

            candidates.add(new ABSqrt(nextValue.getA() + 1, nextValue.getB()));
            candidates.add(new ABSqrt(nextValue.getA(), nextValue.getB() + 1));
            candidates.remove(nextValue);
        }

        return results;
    }

    public void evaluate() {
        List<ABSqrt> results = getKSmallestNumbers(5);
        results.stream().forEach(System.out::println);
    }

    private class ABSqrt implements Comparable<ABSqrt> {

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public double getVal() {
            return val;
        }

        private int a;
        private int b;
        private double val;

        public ABSqrt(int a, int b) {
            this.a = a;
            this.b = b;
            this.val = a + b * Math.sqrt(2);
        }

        @Override
        public int compareTo(ABSqrt other) {
            return Double.compare(this.getVal(), other.getVal());
        }

        @Override
        public String toString() {
            return a + ", " + b;
        }
    }
}
