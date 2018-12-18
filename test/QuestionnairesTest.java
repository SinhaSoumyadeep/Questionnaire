import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import questionnaires.Likert;
import questionnaires.MultiAnswer;
import questionnaires.MultipleChoice;
import questionnaires.Questionnaires;
import questionnaires.YesNo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * This Test Class is used to test the correctness of the Implementation of the Questionnaire
 * Classes.
 */
public class QuestionnairesTest {

  Questionnaires q0;
  Questionnaires q1;
  Questionnaires q2;
  Questionnaires q3;
  Questionnaires q4;
  Questionnaires q5;
  Questionnaires q6;
  Questionnaires q7;
  Questionnaires q8;
  Questionnaires q9;
  Questionnaires q10;
  Questionnaires q11;

  /**
   * This method is used to instantiate various objects of the Questionnaire class.
   */
  @Before
  public void setUp() {
    q0 = new MultiAnswer("Naruto's Friend",
            "Gara Sakura Orochimaru Sasuke", "1 2 4");
    q1 = new MultipleChoice("What is Naruto's last name?",
            "Uzumaki Minato Ucchiha Sasuke", "1");
    q2 = new Likert("Was Sakura annoying?");
    q3 = new MultiAnswer("Who was Naruto's teacher?",
            "kakashi jaraya sasuke sakura", "1 2");
    q4 = new YesNo("Naruto defeted Madara Ucchiha", "Yes");
    q5 = new MultiAnswer("Naruto's power",
            "Rasengan ChakraManipulation Amaturasu Sharingan", "1 2");
    q6 = new Likert("Itachi was a traitor");
    q7 = new MultipleChoice("How did Sasuke kill Itachi",
            "Amaturasu Sharingan NOoooo....", "3");
    q8 = new Likert("AWas Sakura annoying?");
    q9 = new Likert("BWas Sakura annoying?");
    q10 = new YesNo("CNaruto defeted Madara Ucchiha", "Yes");
    q11 = new YesNo("DNaruto defeted Madara Ucchiha", "Yes");

  }

  //professor's perspective.

  /**
   * This method tests the instantiation of the Multiple Answer Question.
   */
  @Test
  public void testMultipleAnswerNormalCase() {
    assertEquals("Naruto's Friend\n1. Gara.\n2. Sakura.\n3. Orochimaru.\n4. Sasuke.",
            q0.printQuestionText());
    assertEquals(q0, q0);
  }

  /**
   * This method tests the instantiation of the Multiple Choice Question.
   */
  @Test
  public void testMultipleChoiceNormalCase() {
    assertEquals("What is Naruto's last name?\n1. Uzumaki.\n2. Minato.\n3." +
            " Ucchiha.\n4. Sasuke.", q1.printQuestionText());
    assertEquals(q1, q1);
  }

  /**
   * This method tests the instantiation of the Likert Question.
   */
  @Test
  public void testLikertNormalCase() {
    assertEquals("Was Sakura annoying?\n1. Strongly Agree.\n2. Agree.\n3. Neither" +
            " Agree nor Disagree.\n4. Disagree.\n5. Strongly Disagree.", q2.printQuestionText());
    assertEquals(q2, q2);
  }

  /**
   * This method tests the instantiation of the Yes No Question.
   */
  @Test
  public void testYesNoNormalCase() {
    assertEquals("Naruto defeted Madara Ucchiha", q4.printQuestionText());
    assertEquals(q4, q4);
  }

  /**
   * This method is used to test question that have empty question text or correct answer.
   */
  @Test
  public void testForEmptyCases() {

    try {
      Questionnaires qemptytext = new MultiAnswer("",
              "Gara Sakura Orochimaru Sasuke", "1 2 4");
      fail();
    } catch (Exception e) {
      assertEquals("One of the argument is empty or Incorrect!", e.getMessage());
    }


    try {
      Questionnaires oneOption = new MultipleChoice("",
              "Uzumaki Minato Ucchiha Sasuke", "1");
      fail();
    } catch (Exception e) {
      assertEquals("One of the argument is empty or Incorrect!", e.getMessage());
    }


    try {
      Questionnaires oneOption = new Likert("");
      fail();
    } catch (Exception e) {
      assertEquals("One of the argument is empty or Incorrect!", e.getMessage());
    }


    try {
      Questionnaires oneOption = new YesNo("", "Yes");
      fail();
    } catch (Exception e) {
      assertEquals("One of the argument is empty or Incorrect!", e.getMessage());
    }


    try {
      Questionnaires qemptyAnswer = new MultiAnswer("Naruto's Friend",
              "Gara Sakura Orochimaru Sasuke", "");
      fail();
    } catch (Exception e) {
      assertEquals("One of the argument is empty or Incorrect!", e.getMessage());
    }


  }


  /**
   * This method test if multiple spaces in option can be handled.
   */
  @Test
  public void testForMultipleSpacesInOption() {

    Questionnaires qspaceTestMAQ = new MultiAnswer("Naruto's Friend",
            "Gara    Sakura     Orochimaru         Sasuke",
            "1 2 4");
    assertEquals("Naruto's Friend\n1. Gara.\n2. Sakura.\n3. Orochimaru.\n4. Sasuke.",
            qspaceTestMAQ.printQuestionText());

    Questionnaires qspaceTestMCQ = new MultipleChoice("What is Naruto's last name?",
            "Uzumaki    Minato       Ucchiha    Sasuke", "1");
    assertEquals("What is Naruto's last name?\n1. Uzumaki.\n2. Minato.\n3." +
            " Ucchiha.\n4. Sasuke.", qspaceTestMCQ.printQuestionText());


  }


  /**
   * This method tests if the number of option less than 3 condition is handled.
   */
  @Test
  public void testForOptionsLessThanThree() {

    try {
      Questionnaires qemptyOption = new MultiAnswer("Naruto's Friend",
              "", "1 2 4");
      fail();
    } catch (Exception e) {
      assertEquals("invalid option!!", e.getMessage());
    }

    try {
      Questionnaires twoOption = new MultipleChoice("Naruto's Friend",
              "Gara", "1");
      fail();
    } catch (Exception e) {
      assertEquals("invalid option!!", e.getMessage());
    }


    try {
      Questionnaires twoOption = new MultiAnswer("Naruto's Friend",
              "Gara Sakura", "1 2 4");
      fail();
    } catch (Exception e) {
      assertEquals("invalid option!!", e.getMessage());
    }


  }

  /**
   * This method tests if the number of option more than 8 condition is handled.
   */
  @Test
  public void testForOptionsMoreThanEight() {

    try {
      Questionnaires qnineOption = new MultiAnswer("Naruto's Friend",
              "gh hjg gjghj gjgjh hggj gjghj jhgj gjgj hgjgj", "1 2 4");
      fail();
    } catch (Exception e) {
      assertEquals("invalid option!!", e.getMessage());
    }

    try {
      Questionnaires qnineOption = new MultipleChoice("Naruto's Friend",
              "gh hjg gjghj gjgjh hggj gjghj jhgj gjgj hgjgj fjhfj", "1");
      fail();
    } catch (Exception e) {
      assertEquals("invalid option!!", e.getMessage());
    }

  }

  /**
   * This method tests if the Implementation handles the boundary condition of the number of
   * options.
   */
  @Test
  public void testForOptionsBoundary() {
    Questionnaires qboundaryTestMAQ = new MultiAnswer("Naruto's Friend",
            "Gara Sakura Orochimaru", "1 2 ");
    assertEquals("Naruto's Friend\n1. Gara.\n2. Sakura.\n3. Orochimaru.",
            qboundaryTestMAQ.printQuestionText());

    Questionnaires qboundaryTestMCQ = new MultipleChoice("Naruto's Friend",
            "Gara Sakura Orochimaru sdfh sjdhfk dssdfhk dsjkfh dsdfs", "1");
    assertEquals("Naruto's Friend\n1. Gara.\n2. Sakura.\n3. Orochimaru.\n" +
                    "4. sdfh.\n5. sjdhfk.\n6. dssdfhk.\n7. dsjkfh.\n8. dsdfs.",
            qboundaryTestMCQ.printQuestionText());

  }

  /**
   * This method checks if he implementation handles the situation when the correct answer entered
   * is not among the options available.
   */
  @Test
  public void testCorrectAnswers() {

    try {
      Questionnaires qspaceTestMAQ = new MultiAnswer("Naruto's Friend",
              "Gara Sakura Orochimaru hjgkj", "1 2 5 ");
      fail();
    } catch (Exception e) {
      assertEquals("invalid correct answer!", e.getMessage());
    }


    try {
      Questionnaires qspaceTestMCQ = new MultipleChoice("Naruto's Friend",
              "Gara Sakura Orochimaru sdfh sjdhfk", "7");
    } catch (Exception e) {
      assertEquals("invalid correct answer!", e.getMessage());
    }


  }

  /**
   * This method tests if the implementation handles if the user enters more than one correct answer
   * in Multiple choice Question.
   */
  @Test
  public void testNumberOfOptionsInMultipleChoice() {

    try {
      Questionnaires qspaceTestMCQ = new MultipleChoice("Naruto's Friend",
              "Gara Sakura Orochimaru sdfh sjdhfk", " 1 2 3 ");
    } catch (Exception e) {
      assertEquals("you are suppose to enter just one option!", e.getMessage());
    }

  }

  /**
   * This method handles if there are duplicates in the correct answer provided.
   */
  @Test
  public void testForDuplicatesInCorrectAnswer() {

    try {
      Questionnaires qspaceTestMAQ = new MultiAnswer("Naruto's Friend",
              "Gara Sakura Orochimaru sdfh sjdhfk", " 1 2 1");
    } catch (Exception e) {
      assertEquals("There are duplicates in your answer", e.getMessage());
    }

  }

  /**
   * This method tests if there are invalid characters or if the correct answer provided is
   * invalid.
   */
  @Test
  public void testForInvalidCorrectAnswer() {

    try {
      Questionnaires qspaceTestMAQ = new MultiAnswer("Naruto's Friend",
              "Gara Sakura Orochimaru sdfh sjdhfk", " 1 2 a");
    } catch (Exception e) {
      assertEquals("Invalid answer!", e.getMessage());
    }

    try {
      Questionnaires qspaceTestMCQ = new MultipleChoice("Naruto's Friend",
              "Gara Sakura Orochimaru sdfh sjdhfk", "a");
    } catch (Exception e) {
      assertEquals("Invalid answer!", e.getMessage());
    }

  }

  /**
   * This method tests if the correct answer provided to the yes and no is vaild.
   */
  @Test
  public void testCorrectAnswerYesNo() {

    try {
      Questionnaires qtestCorrectAnswer = new YesNo("Naruto defeted Madara Ucchiha",
              "Y");
      fail();
    } catch (Exception e) {
      assertEquals("The value can only be yes and no.", e.getMessage());
    }

    try {
      Questionnaires qtestCorrectAnswer = new YesNo("Naruto defeted Madara Ucchiha",
              "Noo");
      fail();
    } catch (Exception e) {
      assertEquals("The value can only be yes and no.", e.getMessage());

    }

  }


  //students perspective

  /**
   * This method evaluates all possible Multiple Answer Question's answer.
   */
  @Test
  public void testEvaluateMAQAnswer() {
    assertEquals("Correct", q0.checkAnswer("1 2 4"));

    assertEquals("Correct", q0.checkAnswer(" 1   2     4"));

    assertEquals("Correct", q0.checkAnswer("4 2 1"));

    assertEquals("Correct", q0.checkAnswer("4   2        1"));

    assertEquals("InCorrect", q0.checkAnswer("1 2 3"));

    assertEquals("InCorrect", q0.checkAnswer("1 2 3 4"));

    assertEquals("InCorrect", q0.checkAnswer("4 2 1 3"));

    assertEquals("InCorrect", q0.checkAnswer("1 1 1"));

    assertEquals("InCorrect", q0.checkAnswer("1 2"));

    assertEquals("InCorrect", q0.checkAnswer("1 "));

    assertEquals("InCorrect", q0.checkAnswer("a "));

    assertEquals("InCorrect", q0.checkAnswer("1 2 4 a"));

    assertEquals("InCorrect", q0.checkAnswer("   x   1 2 3"));

    assertEquals("InCorrect", q0.checkAnswer(" a   b       c"));

  }


  /**
   * This method evaluates all possible Multiple Choice Question's answer.
   */
  @Test
  public void testEvaluateMCQAnswer() {
    assertEquals("Correct", q1.checkAnswer("1"));

    assertEquals("Correct", q1.checkAnswer("  1  "));

    assertEquals("InCorrect", q1.checkAnswer("2"));

    assertEquals("InCorrect", q1.checkAnswer("a"));

    assertEquals("InCorrect", q1.checkAnswer("a b"));

    assertEquals("InCorrect", q1.checkAnswer("  1 2  "));

  }


  /**
   * This method evaluates all possible Yes No type Question's answer.
   */
  @Test
  public void testEvaluateYesNoAnswer() {

    assertEquals("Correct", q4.checkAnswer("Yes"));

    assertEquals("Correct", q4.checkAnswer("yes"));

    assertEquals("Correct", q4.checkAnswer(" yes "));

    assertEquals("InCorrect", q4.checkAnswer("No"));

    assertEquals("InCorrect", q4.checkAnswer("no"));

    assertEquals("InCorrect", q4.checkAnswer(" no "));

    assertEquals("InCorrect", q4.checkAnswer(" true "));

    assertEquals("InCorrect", q4.checkAnswer(" false "));

    assertEquals("InCorrect", q4.checkAnswer("1"));

    assertEquals("InCorrect", q4.checkAnswer("a b"));

  }


  /**
   * This method evaluates all possible Likert type Question's answer.
   */
  @Test
  public void testEvaluateLikertAnswer() {

    assertEquals("Correct", q2.checkAnswer("1"));

    assertEquals("Correct", q2.checkAnswer(" 1 "));

    assertEquals("Correct", q2.checkAnswer("2"));

    assertEquals("Correct", q2.checkAnswer("3"));

    assertEquals("Correct", q2.checkAnswer("4"));

    assertEquals("Correct", q2.checkAnswer("5"));

    assertEquals("InCorrect", q2.checkAnswer(" 1 2 "));

    assertEquals("InCorrect", q2.checkAnswer(" 0 "));

    assertEquals("InCorrect", q2.checkAnswer(" 6 "));

    assertEquals("InCorrect", q2.checkAnswer(" a "));

  }

  /**
   * This method tests if the yes no type question is sorted properly.
   */
  @Test
  public void testYesNoSort() {
    Questionnaires[] questionnaireArr = {q0, q1, q2, q4};
    Arrays.sort(questionnaireArr);
    Questionnaires[] questionSorted = {q4, q2, q1, q0};

    assertArrayEquals(questionSorted, questionnaireArr);


  }

  /**
   * This method tests if the Likert type question is sorted properly.
   */
  @Test
  public void testLikertSort() {

    Questionnaires[] questionnaireArr = {q0, q1, q2};
    Arrays.sort(questionnaireArr);
    Questionnaires[] questionSorted = {q2, q1, q0};

    assertArrayEquals(questionSorted, questionnaireArr);

    Questionnaires[] questionnaireArr1 = {q2, q4};
    Arrays.sort(questionnaireArr1);
    Questionnaires[] questionSorted1 = {q4, q2};

    assertArrayEquals(questionSorted1, questionnaireArr1);

    Questionnaires[] questionnaireArr2 = {q2,q1,q4};
    Arrays.sort(questionnaireArr2);
    Questionnaires[] questionSorted2 = {q4,q2,q1};

    assertArrayEquals(questionSorted2, questionnaireArr2);


  }


  /**
   * This method tests if the MCQ type question is sorted properly.
   */
  @Test
  public void testMCQSort() {
    Questionnaires[] questionnaireArr = {q0, q1};
    Arrays.sort(questionnaireArr);
    Questionnaires[] questionSorted = {q1, q0};

    assertArrayEquals(questionSorted, questionnaireArr);

    Questionnaires[] questionnaireArr1 = {q1, q2};
    Arrays.sort(questionnaireArr1);
    Questionnaires[] questionSorted1 = {q2, q1};

    assertArrayEquals(questionSorted1, questionnaireArr1);

    Questionnaires[] questionnaireArr2 = {q1, q4};
    Arrays.sort(questionnaireArr2);
    Questionnaires[] questionSorted2 = {q4, q1};

    assertArrayEquals(questionSorted2, questionnaireArr2);

    Questionnaires[] questionnaireArr3 = {q1, q0,q2};
    Arrays.sort(questionnaireArr3);
    Questionnaires[] questionSorted3 = {q2, q1,q0};

    assertArrayEquals(questionSorted3, questionnaireArr3);


  }


  /**
   * This method tests if the MAQ type question is sorted properly.
   */
  @Test
  public void testMAQSort() {
    Questionnaires[] questionnaireArr = {q0, q4};
    Arrays.sort(questionnaireArr);
    Questionnaires[] questionSorted = {q4, q0};

    assertArrayEquals(questionSorted, questionnaireArr);

    Questionnaires[] questionnaireArr1 = {q0, q1};
    Arrays.sort(questionnaireArr1);
    Questionnaires[] questionSorted1 = {q1, q0};

    assertArrayEquals(questionSorted1, questionnaireArr1);

    Questionnaires[] questionnaireArr2 = {q0, q2};
    Arrays.sort(questionnaireArr2);
    Questionnaires[] questionSorted2 = {q2, q0};

    assertArrayEquals(questionSorted2, questionnaireArr2);

    Questionnaires[] questionnaireArr3 = {q0, q2, q4};
    Arrays.sort(questionnaireArr3);
    Questionnaires[] questionSorted3 = {q4, q2, q0};

    assertArrayEquals(questionSorted3, questionnaireArr3);

    Questionnaires[] questionnaireArr4 = {q0, q2, q1, q4};
    Arrays.sort(questionnaireArr4);
    Questionnaires[] questionSorted4 = {q4, q2, q1, q0};

    assertArrayEquals(questionSorted4, questionnaireArr4);


  }

  /**
   * This method is to check if the implementation sorts properly if there are multiple instances of
   * same object in the mix.
   */
  @Test
  public void testMultipleInstancesSort() {
    Questionnaires[] questionnaireArr = {q0, q1, q2, q3, q4, q5, q6, q7};
    Arrays.sort(questionnaireArr);
    Questionnaires[] questionSorted = {q4, q6, q2, q7, q1, q0, q5, q3};

    assertArrayEquals(questionSorted, questionnaireArr);


  }

  /**
   * This method tests if the lexicographical sort works form Multiple Answer Type Question.
   */
  @Test
  public void testLexicographicMultiAnswerSort() {
    Questionnaires[] questionnaireArr = {q0, q3, q5};
    Arrays.sort(questionnaireArr);
    Questionnaires[] questionSorted = {q0, q5, q3};

    assertArrayEquals(questionSorted, questionnaireArr);

  }

  /**
   * This method tests if the lexicographical sort works form Multiple Answer Type Question.
   */
  @Test
  public void testLexicographicMultiChoiceSort() {
    Questionnaires[] questionnaireArr = {q1, q7};
    Arrays.sort(questionnaireArr);
    Questionnaires[] questionSorted = {q7, q1};

    assertArrayEquals(questionSorted, questionnaireArr);

  }

  /**
   * This method tests if the lexicographical sort works form Likert Type Question.
   */
  @Test
  public void testLexicographicLikertSort() {
    Questionnaires[] questionnaireArr = {q2, q9, q8};
    Arrays.sort(questionnaireArr);
    Questionnaires[] questionSorted = {q8, q9, q2};

    assertArrayEquals(questionSorted, questionnaireArr);

  }

  /**
   * This method tests if the lexicographical sort works form YesNo Type Question.
   */
  @Test
  public void testLexicographicYesNoSort() {
    Questionnaires[] questionnaireArr = {q4, q11, q10};
    Arrays.sort(questionnaireArr);
    Questionnaires[] questionSorted = {q10, q11, q4};

    assertArrayEquals(questionSorted, questionnaireArr);

  }

  /**
   * This method tests lexicographical sort as well as object sort.
   */
  @Test
  public void testAllSort() {
    Questionnaires[] questionnaireArr = {q0, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11};
    Arrays.sort(questionnaireArr);
    Questionnaires[] questionSorted = {q10, q11, q4, q8, q9, q6, q2, q7, q1, q0, q5, q3};

    assertArrayEquals(questionSorted, questionnaireArr);
  }


}