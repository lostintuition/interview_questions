package sixteen;

import base.InterviewQuestion;

import javax.sound.midi.SysexMessage;
import java.util.*;

/**
     * Strings in which parens are matched are defined by the following three rules:
     * The empty string, "", is a string in which parens are matched
     * The addition of a leading left parens and a trailing right parens to a string in which parens are matched results
     * in a string in which parens are matched. For example, since "(())()" is a string with matched parens, so is "((())())"
     * The concatenation of two strings in which parens are matched is itself a string in which parens are matched. For example,
     * since "(())()" and "()" are strings with matches parens, so is "(())()()".
     *
     * The set of 1 is: [()]
     * For example, the set of 2 is: [(()), ()()]
     * The set of 3 is: [((())), (()()), (())(), ()(()), ()()()]
     *
     * Write a program that takes as input a number and returns all the strings with that number of matched pairs of parens.
 */
public class Six implements InterviewQuestion {

    @Override
    public void evaluate() {
        System.out.println(generateMatchedParens(5));
        System.out.println(generateMatchedParens(5).size());
        System.out.println(getMatchedParensStrings(5));
        System.out.println(getMatchedParensStrings(5).size());
    }

    private Set<String> generateMatchedParens(int num) {
        Set<String> results = new HashSet<>();
        generateMatchedParensHelper(num, num, "", results);
        return results;
    }

    private void generateMatchedParensHelper(int leftBrackets, int rightBrackets, String prefix, Set<String> results) {
        if (leftBrackets == 0 && rightBrackets == 0) {
            results.add(prefix);
        }

        if (leftBrackets > 0) {
            generateMatchedParensHelper(leftBrackets - 1, rightBrackets, prefix + "(", results);
        }

        if (leftBrackets < rightBrackets) {
            generateMatchedParensHelper(leftBrackets, rightBrackets - 1, prefix + ")", results);
        }
    }

    /**
     * Failed here. This does not generate all possible Strings
     */
    private Set<String> getMatchedParensStrings(int num) {
        Set<String> matchedParenStrings = new HashSet<>(Arrays.asList(""));
        return getMatchedParensStringsHelper(num, matchedParenStrings);
    }

    private Set<String> getMatchedParensStringsHelper(int num, Set<String> matchedParensStrings) {
        if (num == 0) {
            return matchedParensStrings;
        }

        Set<String> newMatchedParensStrings = new HashSet<>();
        for (String matchedParensString: matchedParensStrings) {
            newMatchedParensStrings.add("(" + matchedParensString + ")");
            newMatchedParensStrings.add("()" + matchedParensString);
            newMatchedParensStrings.add(matchedParensString + "()");
        }

        return getMatchedParensStringsHelper(num - 1, newMatchedParensStrings);
    }

}
