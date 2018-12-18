package questionnaires;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is the Abstract implementation of the Questions. This class provides various methods
 * which is used to compare various classes by using double dispatch.
 */
public abstract class AbstractQuestionnaires implements Questionnaires {

  protected String questionText;
  protected String correctAnswer;

  /**
   * This is an abstract method which will be implemented by all the subclasses. This methods
   * compares the YesNo Question with other Class.
   *
   * @param obj this takes in the yes no object.
   * @return an integer which determines whether it is greater or not.
   */
  protected abstract int compareToYesNo(YesNo obj);

  /**
   * This is an abstract method which will be implemented by all the subclasses. This methods
   * compares the Likert Question with other Class.
   *
   * @param obj this takes in the yes no object.
   * @return an integer which determines whether it is greater or not.
   */
  protected abstract int compareToLikert(Likert obj);

  /**
   * This is an abstract method which will be implemented by all the subclasses. This methods
   * compares the MultipleChoice Question with other Class.
   *
   * @param obj this takes in the yes no object.
   * @return an integer which determines whether it is greater or not.
   */
  protected abstract int compareToMC(MultipleChoice obj);

  /**
   * This is an abstract method which will be implemented by all the subclasses. This methods
   * compares the MultipleAnswer Question with other Class.
   *
   * @param obj this takes in the yes no object.
   * @return an integer which determines whether it is greater or not.
   */
  protected abstract int compareToMA(MultiAnswer obj);


  /**
   * This method takes in a text abd validates if the text is empty.
   *
   * @param text any string and determines if its empty.
   * @return the same string if its not empty.
   */
  protected String validateIfEmpty(String text) {
    Pattern pattern = Pattern.compile("^[\\W|_]*$");
    Matcher match = pattern.matcher(text);
    if (text.length() == 0 || match.find()) {
      throw new IllegalArgumentException("One of the argument is empty or Incorrect!");
    }

    return text;
  }


  /**
   * This method prints the question text.
   *
   * @return the question text.
   */
  public String printQuestionText() {
    return questionText;
  }

  /**
   * This method is the default implementation of the evaluate answer.
   *
   * @param userAnswer this is the user input.
   * @return Correct or Incorect after evaluation.
   */
  public String checkAnswer(String userAnswer) {
    if (userAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
      return "Correct";
    }
    return "InCorrect";
  }


}
