package questionnaires;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the concrete implementation of the Multi Answer type of Question.
 */
public class MultiAnswer extends AbstractQuestionnaires {
  protected String option;


  /**
   * This is the parameterized constructor that takes in the question text, option and correct
   * answer to creates the MultiAnswer type of question.
   */
  public MultiAnswer(String questionText, String option, String correctAnswers) {
    this.questionText = validateIfEmpty(questionText.trim());


    if (validateOption(option.trim())) {

      this.option = option.trim();
    } else {
      throw new IllegalArgumentException("invalid option!!");
    }


    if (validateCorrectAnswer(correctAnswers.trim())) {
      this.correctAnswer = correctAnswers.trim();
    } else {
      throw new IllegalArgumentException("invalid correct answer!");
    }

  }

  /**
   * This method prints the question text and option if there is one.
   *
   * @return the question text and option.
   */
  public String printQuestionText() {
    ArrayList<String> options = new ArrayList<String>(Arrays.asList(this.option.split("[ ]+")));


    String optionPrint = "";
    int count = 1;
    for (String opt : options) {
      optionPrint = optionPrint + count + ". " + opt + ".\n";

      count++;
    }

    return questionText + "\n" + optionPrint.trim();
  }

  /**
   * This method determines the length of the option entered by the user.
   *
   * @param option this method takes in an option String.
   * @return the size of the option
   */
  private int sizeOfOption(String option) {
    String[] options = option.split("[ ]+");
    return options.length;
  }

  /**
   * This method is used to check if the options entered by the user is valid.
   *
   * @param option this method takes in an option String.
   * @return true if its a valid option else return false.
   */
  private boolean validateOption(String option) {

    int length = sizeOfOption(option);
    return ((length >= 3) && (length <= 8));
  }

  /**
   * This method is used to determine if the correct answer entered by the user is actually valid.
   *
   * @param correct takes in a correct answer String.
   * @return a True if the correct answer is valid else return false.
   */
  private boolean validateCorrectAnswer(String correct) {

    correct = validateIfEmpty(correct);

    List<String> list = Arrays.asList(correct.trim().split(" "));

    Set<String> uniqueWords = new HashSet<String>(list);
    for (String word : uniqueWords) {

      Integer frequency = Collections.frequency(list, word);

      if (frequency > 1 || frequency < 1) {
        throw new IllegalArgumentException("There are duplicates in your answer");
      }
    }

    int length = sizeOfOption(option.trim());
    ArrayList<Boolean> storeAnswer = new ArrayList<Boolean>();

    String[] opt = correct.split("[ ]+");

    for (int i = 0; i < opt.length; i++) {

      if (!Character.isDigit(opt[i].trim().charAt(0))) {
        throw new IllegalArgumentException("Invalid answer!");
      }

      if (Integer.parseInt(opt[i].trim().charAt(0) + "") >= 1
              && Integer.parseInt(opt[i].trim().charAt(0) + "") <= length) {
        storeAnswer.add(true);
      } else {
        storeAnswer.add(false);
      }
    }


    return (!storeAnswer.contains(false));
  }


  /**
   * This is to check if the option entered has anything other than digits in it.
   *
   * @param option this method takes in option as string
   * @return True if there are only digits in the option else returns false.
   */
  private boolean isDigit(String option) {

    String[] options = option.split("[ ]+");


    for (int i = 0; i < options.length; i++) {

      if (!Character.isDigit(options[i].charAt(0))) {
        return false;
      }

    }

    return true;

  }

  /**
   * This is an overloaded method which provides a gateway for the subclasses extending this class
   * to use the default check answer in the grand parent class.
   *
   * @param userAnswer this method takes in the user answer.
   * @return Correct or Incorrect based on evaluation.
   */
  protected String checkAnswer(StringBuilder userAnswer) {
    return super.checkAnswer(userAnswer.toString());
  }

  /**
   * This method evaluates the answer provided and based on the evaluation returns Correct or
   * Incorrect.
   *
   * @param userAnswer this is the user input.
   * @return This method returns Correct or InCorrect based on evaluation.
   */
  public String checkAnswer(String userAnswer) {
    boolean ch = false;
    StringTokenizer correctAnswers = new StringTokenizer(correctAnswer, " ");
    ArrayList<Boolean> storeAnswer = new ArrayList<Boolean>();
    if (!isDigit(userAnswer.trim())) {
      return "InCorrect";
    }
    String userAns = "";
    String correctAns = correctAnswer.replace(" ", "");
    Pattern pat = Pattern.compile("[ ]*([0-9])");
    Matcher mat = pat.matcher("," + userAnswer.trim());
    while (mat.find()) {

      userAns = userAns + mat.group(1);
    }

    if (userAns.length() != correctAns.length()) {
      return "InCorrect";
    }

    while (correctAnswers.hasMoreTokens()) {
      String ca = correctAnswers.nextToken();
      if (userAns.contains(ca)) {
        storeAnswer.add(true);
      } else {
        storeAnswer.add(false);
      }

    }

    if (storeAnswer.contains(false)) {
      return "InCorrect";
    }

    return "Correct";
  }

  /**
   * This method takes in the Questionnaire obj and compares the Multiple Answer object with other
   * type of question object.
   *
   * @param obj this can be any object of Questionnaires.
   * @return the integer value that determines which object is greater after comparision.
   */
  public int compareTo(Questionnaires obj) {
    if (obj instanceof AbstractQuestionnaires) {
      AbstractQuestionnaires ques = (AbstractQuestionnaires) obj;
      return ques.compareToMA(this);
    }

    return -1;

  }


  /**
   * This method takes in the YesNo obj and compares the MultipleAnswer object with yes no object.
   *
   * @param obj this can be any object of YesNo.
   * @return the integer value that determines which object is greater after comparision.
   */
  @Override
  protected int compareToYesNo(YesNo obj) {
    return -1;
  }

  /**
   * This method takes in the Likert obj and compares the MultipleAnswer object with Likert object.
   *
   * @param obj this can be any object of Likert.
   * @return the integer value that determines which object is greater after comparision.
   */
  @Override
  protected int compareToLikert(Likert obj) {
    return -1;
  }

  /**
   * This method takes in the MultipleChoice obj and compares the MultipleAnswer object with
   * MultipleChoice object.
   *
   * @param obj this can be any object of MultipleChoice.
   * @return the integer value that determines which object is greater after comparision.
   */
  @Override
  protected int compareToMC(MultipleChoice obj) {
    return -1;
  }

  /**
   * This method takes in the MultiAnswer obj and compares the MultipleAnswer object with
   * MultiAnswer object.
   *
   * @param obj this can be any object of MultiAnswer.
   * @return value that determines which object is greater after comparision lexicographically.
   */
  @Override
  protected int compareToMA(MultiAnswer obj) {
    return obj.questionText.compareToIgnoreCase(this.questionText);
  }
}
