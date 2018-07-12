package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.exception.AnswerFormatIncorrectException;
import tw.core.model.Record;
import static org.hamcrest.core.Is.is;
import java.util.ArrayList;
import java.util.List;

//import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by jxzhong on 2017/9/23.
 */
public class AnswerTest {
    private Answer actualAnswer;

    @BeforeEach
    public void setUp() {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void should_not_throw_the_exception_given_a_correct_formatted_answer_when_call_validate(){
        try {
            actualAnswer.validate();
        } catch (AnswerFormatIncorrectException answerFormatIncorrectException){
            fail("should not throw the exception");
        }
    }
    @Test
    public void should_throw_the_exception_given_a_answer_number_is_bigger_than_9_when_call_validate(){
        Answer incorrectAnswer = Answer.createAnswer("1 2 3 10");
        try {
            incorrectAnswer.validate();
            fail("should not throw the exception");
        } catch (AnswerFormatIncorrectException answerFormatIncorrectException){

        }
    }
    @Test
    public void should_throw_the_exception_given_a_repeated_number_when_call_validate(){
        Answer incorrectAnswer = Answer.createAnswer("1 2 3 3");
        try {
            incorrectAnswer.validate();
            fail("should not throw the exception");
        } catch (AnswerFormatIncorrectException answerFormatIncorrectException){

        }
    }
    @Test
    public void should_return_2A1B_when_call_check_given_input_answer_is_1245(){
        Answer inputAnswer = Answer.createAnswer("1 2 4 5");

        Record result = actualAnswer.check(inputAnswer);

        assertEquals("2A1B", result.getValue());
    }

    @Test
    public void should_getIndexOfNum_given_a_num(){
        int returnValue = actualAnswer.getIndexOfNum("2");
        assertThat(returnValue,is(1));
    }



}