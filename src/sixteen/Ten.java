package sixteen;

import base.InterviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ten implements InterviewQuestion {

    /**
     * An n-bit Gray code is a permutation of {0,1,2,..2^n - 1} such that the binary
     * representations of successive integers in the sequence differ in only one place.
     * (This is with wraparound, i.e., the last and first elements must also differ in only
     * one place.) For example, both <(000),(100),(101),(111),(110),(010),(011),(001)> =
     * <0,4,5,7,6,2,3,1> and <0,1,3,2,6,7,5,4> are Gray codes for n = 3.
     *
     * Write a program which takes n as input and returns an n-bit Gray code.
     *
     * n = 2
     * <(00),(10),(11),(01)>
     *    (10),(01),(10)
     * n = 3
     * <(000),(100),(101),(111),(110),(010),(011),(001)>
     *     (100),(001),(010),(001),(100),(001),(010)
     * <(000),(010),(011),(001),(101),(111),(110),(100)
     * n = 4
     * <((0000),(1000),(1001),(1011),(1111),(0111),(0011),(0001),(0000),(1000),(0011),(0001),(0000),
     *      (1000),(0001),(0010),(0100),(1000),(0100),(0010),(0001),(1000),(0001),(0010),(0100),(1000),(0100),(0010)
     */
    @Override
    public void evaluate() {
        generateNBitGrayCodes(3).stream().forEach(grayCode -> System.out.println(Integer.toBinaryString(grayCode)));
    }

    public List<Integer> generateNBitGrayCodes(int n) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(0));
        }

        if (n == 1) {
            return new ArrayList<>(Arrays.asList(0, 1));
        }

        List<Integer> nMinusOneBitGrayCodes = generateNBitGrayCodes(n - 1);
        int leadingBitOne = 1 << (n - 1);
        List<Integer> newBits = new ArrayList<>();

        for (int i = nMinusOneBitGrayCodes.size() - 1; i >= 0; --i) {
            newBits.add(leadingBitOne | nMinusOneBitGrayCodes.get(i));
        }

        nMinusOneBitGrayCodes.addAll(newBits);
        return nMinusOneBitGrayCodes;
    }

    public List<String> getNBitGrayCodes(int n) {
        List<String> results = new ArrayList<>();
        List<String> intermediateResults = new ArrayList<>(Arrays.asList(""));
        getNBitGrayCodes(n, intermediateResults, results);
        System.out.println(results);
        return results;
    }

    public void getNBitGrayCodes(int num, List<String> intermediateResults, List<String> results) {
        if (num == 0) {
            results.addAll(intermediateResults);
            return;
        }

        List<String> newIntermediateResults = new ArrayList<>();

        for (String intermediateResult: intermediateResults) {
            newIntermediateResults.add("0" + intermediateResult);
        }

        Collections.reverse(intermediateResults);
        for (String intermediateResult: intermediateResults) {
            newIntermediateResults.add("1" + intermediateResult);
        }

        getNBitGrayCodes(num -1, newIntermediateResults, results);
    }
}
