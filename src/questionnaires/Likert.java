package questionnaires;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the concrete implementation of the Likert type of Question.
 */
public class Likert extends AbstractQuestionnaires {

  /**
   * This enum is the various options that are abailable for the Likert type of question.
   */
  private enum LikertOption {
    SA("Strongly Agree."),
    A("Agree."),
    NAD("Neither Agree nor Disagree."),
    D("Disagree."),
    SD("Strongly Disagree.");

    private final String name;

    /**
     * This is the private constructor of the enum option.
     */
    private LikertOption(String s) {
      name = s;
    }

    /**
     * The toString method is overridden to get the actual string against the options.
     *
     * @return the String value against the option.
     */
    @Override
    public String toString() {
      return this.name;
    }
  }

  /**
   * This is the parameterized constructor that takes in the question text and creates the Likert
   * type of question.
   */
  public Likert(String questionText) {
    this.questionText = validateIfEmpty(questionText);
  }

  /**
   * This method prints the question text and option if there is one.
   *
   * @return the question text and option.
   */
  public String printQuestionText() {
    return questionText
            + "\n1. " + LikertOption.SA
            + "\n2. " + LikertOption.A
            + "\n3. " + LikertOption.NAD
            + "\n4. " + LikertOption.D
            + "\n5. " + LikertOption.SD;
  }


  /**
   * This method checks if the user has entered the correct option i.e th eoption entered is between
   * the given range of options.
   *
   * @param userAnswer this is the user input.
   * @return Correct or Incorrect based on evaluation.
   */
  @Override
  public String checkAnswer(String userAnswer) {
    Pattern pat = Pattern.compile("^[1-5]$");
    Matcher mat = pat.matcher(userAnswer.trim());
    if (mat.find()) {
      return "Correct";
    } else {
      return "InCorrect";
    }
  }


  /**
   * This method takes in the Questionnaire obj and compares the Likert object with other type of
   * question object.
   *
   * @param obj this can be any object of Questionnaires.
   * @return the integer value that determines which object is greater after comparision.
   */
  @Override
  public int compareTo(Questionnaires obj) {
    if (obj instanceof AbstractQuestionnaires) {
      AbstractQuestionnaires ques = (AbstractQuestionnaires) obj;
      return ques.compareToLikert(this);
    }

    return -1;

  }

  /**
   * This method takes in the YesNo obj and compares the likert object with yes no object.
   *
   * @param obj this can be any object of YesNo.
   * @return the integer value that determines which object is greater after comparision.
   */
  @Override
  protected int compareToYesNo(YesNo obj) {
    return -1;
  }


  /**
   * This method takes in the Likert obj and compares the Likert object with another Likert object.
   *
   * @param obj this can be any object of Likert.
   * @return the integer value that determines which object is greater lexicographically.
   */
  @Override
  protected int compareToLikert(Likert obj) {
    return obj.questionText.compareToIgnoreCase(this.questionText);
  }

  /**
   * This method takes in the Multiple Choice obj and compares the likert object with Multiple
   * Choice object.
   *
   * @param obj this can be any object of Multiple Choice.
   * @return the integer value that determines which object is greater after comparision.
   */
  @Override
  protected int compareToMC(MultipleChoice obj) {
    return 1;
  }

  /**
   * This method takes in the Multi Answer obj and compares the likert object with Multi Answer
   * object.
   *
   * @param obj this can be any object of Multi Answer.
   * @return the integer value that determines which object is greater after comparision.
   */
  @Override
  protected int compareToMA(MultiAnswer obj) {
    return 1;
  }
}
