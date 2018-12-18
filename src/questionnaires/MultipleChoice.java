package questionnaires;

/**
 * This is the concrete implementation of the Multiple Choice type of Question which extends the
 * Multi Answer Question..
 */
public class MultipleChoice extends MultiAnswer {


  /**
   * This is the parameterized constructor that takes in the question text, option and correct
   * answer to creates the Multiple Choice type of question. It makes call to the super constructor
   * to create the object.
   */
  public MultipleChoice(String questionText, String options, String correctAnswers) {
    super(questionText, options, correctAnswers);
    if (!validateCorrectAnswer(this.correctAnswer)) {
      throw new IllegalArgumentException("you are suppose to enter just one option!");
    }

  }

  /**
   * This method is used to determine if the correct answer entered by the user is actually valid.
   *
   * @param correct takes in a correct answer String.
   * @return a true if the correct answer is valid else return false.
   */

  private boolean validateCorrectAnswer(String correct) {
    return (correct.length() == 1);

  }

  /**
   * This method evaluates the answer provided and based on the evaluation returns Correct or
   * Incorrect. It calls the overloaded method in the super class which uses the default
   * implementation of the check anwser.
   *
   * @param userAnswer this is the user input.
   * @return This method returns Correct or InCorrect based on evaluation.
   */
  @Override
  public String checkAnswer(String userAnswer) {
    return super.checkAnswer(new StringBuilder(userAnswer));
  }


  /**
   * This method takes in the Questionnaire obj and compares the MultipleChoice object with other
   * type of question object.
   *
   * @param obj this can be any object of Questionnaires.
   * @return the integer value that determines which object is greater after comparision.
   */
  @Override
  public int compareTo(Questionnaires obj) {
    if (obj instanceof AbstractQuestionnaires) {
      AbstractQuestionnaires ques = (AbstractQuestionnaires) obj;
      return ques.compareToMC(this);
    }

    return -1;

  }

  /**
   * This method takes in the YesNo obj and compares the MultipleChoice object with yes no object.
   *
   * @param obj this can be any object of YesNo.
   * @return the integer value that determines which object is greater after comparision.
   */
  @Override
  protected int compareToYesNo(YesNo obj) {
    return -1;
  }

  /**
   * This method takes in the Likert obj and compares the MultipleChoice object with Likert object.
   *
   * @param obj this can be any object of Likert.
   * @return the integer value that determines which object is greater after comparision.
   */
  @Override
  protected int compareToLikert(Likert obj) {
    return -1;
  }

  /**
   * This method takes in the MultipleChoice obj and compares the MultipleChoice object with
   * MultipleChoice object.
   *
   * @param obj this can be any object of MultipleChoice.
   * @return the integer value that determines which object is greater after comparision.
   */
  @Override
  protected int compareToMC(MultipleChoice obj) {
    return obj.questionText.compareToIgnoreCase(this.questionText);
  }

  /**
   * This method takes in the MultiAnswer obj and compares the MultipleChoice object with
   * MultiAnswer object.
   *
   * @param obj this can be any object of MultiAnswer.
   * @return value that determines which object is greater after comparision lexicographically.
   */
  @Override
  protected int compareToMA(MultiAnswer obj) {
    return 1;
  }
}
