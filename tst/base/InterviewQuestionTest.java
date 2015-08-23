package base;

import org.junit.Test;

public class InterviewQuestionTest {

    InterviewQuestion interviewQuestion;

    @Test
    public void evaluate() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String testClassName = this.getClass().getName();
        String className = testClassName.substring(0, testClassName.length() - 4);
        InterviewQuestion interviewQuestion = (InterviewQuestion) Class.forName(className).newInstance();
        interviewQuestion.evaluate();
    }

    public void setInterviewQuestion(InterviewQuestion interviewQuestion) {
        this.interviewQuestion = interviewQuestion;
    }
}
