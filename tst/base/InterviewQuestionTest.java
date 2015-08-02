package base;

import org.junit.Test;

/**
 * Created by garrettsato on 8/1/15.
 */
public class InterviewQuestionTest {

    InterviewQuestion interviewQuestion;

    @Test
    public void evaluate() {
        this.interviewQuestion.evaluate();
    }

    public void setInterviewQuestion(InterviewQuestion interviewQuestion) {
        this.interviewQuestion = interviewQuestion;
    }
}
