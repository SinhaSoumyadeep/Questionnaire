package questionnaires;

/**
 * Many online questionnaire tools like SurveyMonkey, Doodle Poll, etc. (even Blackboard and
 * Bottlenose) allow creating a questionnaire made of several questions. Questions are of different
 * types: those with yes/no answers, to larger freeform-text type questions. This Interface tries to
 * simulate the same functionality. This Interface also extends Comparable which makes the classes
 * implementing this interface sortable or make comparisions. This Interface provides two methods
 * one is to check the Answer or to evaluate it and to print the question text.
 */
public interface Questionnaires extends Comparable<Questionnaires> {

  /**
   * This method takes in the user input and evaluates the answers whether it is correct or not.
   *
   * @param userAnswer this is the user input.
   * @return correct or Incorrect based on the evaluation.
   */
  public String checkAnswer(String userAnswer);

  /**
   * This method prints the question text and option if there is one.
   *
   * @return the question text and option.
   */
  public String printQuestionText();

}
