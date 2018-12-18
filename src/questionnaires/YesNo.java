package questionnaires;

/**
 * This is the concrete implementation of the Yes No type of Question.
 */
public class YesNo extends AbstractQuestionnaires {

  /**
   * This enum is the various options that are abailable for the Yes no type of question.
   */
  private enum options {
    Yes, No;
  }


  /**
   * This is the parameterized constructor that takes in the question text and correct answer and
   * creates the yes and no type of question.
   */
  public YesNo(String questionText, String correctAnswer) {


    this.questionText = validateIfEmpty(questionText);
    if (validateAnswer(correctAnswer.trim())) {
      this.correctAnswer = validateIfEmpty(correctAnswer);
    } else {
      throw new IllegalArgumentException("The value can only be yes and no.");
    }

  }

  /**
   * This method determines if the correct answer passed is yes or no.
   *
   * @param correctAnswer takes in the correct answer provided.
   * @return boolean value that determines if the correct answer passed is actually correct.
   */
  private boolean validateAnswer(String correctAnswer) {

    return (correctAnswer.equalsIgnoreCase(options.Yes.toString())
            || correctAnswer.equalsIgnoreCase(options.No.toString()));
  }


  /**
   * This method takes in the Questionnaire obj and compares the yes and no object with other type
   * of question object.
   *
   * @param obj this can be any object of Questionnaires.
   * @return the integer value that determines which object is greater after comparision.
   */
  @Override
  public int compareTo(Questionnaires obj) {
    if (obj instanceof AbstractQuestionnaires) {
      AbstractQuestionnaires ques = (AbstractQuestionnaires) obj;
      return ques.compareToYesNo(this);
    }

    return -1;

  }


  /**
   * This method takes in the YesNo obj and compares the yes no object with another yes no object.
   *
   * @param obj this can be any object of YesNo.
   * @return the integer value that determines which object is greater lexicographically.
   */
  @Override
  protected int compareToYesNo(YesNo obj) {
    return obj.questionText.compareToIgnoreCase(this.questionText);
  }

  /**
   * This method takes in the Likert obj and compares the yes no object with Likert object.
   *
   * @param obj this can be any object of Likert.
   * @return the integer value that determines which object is greater.
   */
  @Override
  protected int compareToLikert(Likert obj) {
    return 1;
  }

  /**
   * This method takes in the Multiple choice obj and compares the yes no object with Multiple
   * choice object.
   *
   * @param obj this can be any object of MultipleChoice.
   * @return the integer value that determines which object is greater.
   */
  @Override
  protected int compareToMC(MultipleChoice obj) {
    return 1;
  }

  /**
   * This method takes in the MultiAnswer obj and compares the yes no object with MultiAnswer
   * object.
   *
   * @param obj this can be any object of MultiAnswer.
   * @return the integer value that determines which object is greater .
   */
  @Override
  protected int compareToMA(MultiAnswer obj) {
    return 1;
  }
}
