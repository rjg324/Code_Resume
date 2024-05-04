package Exam2Prep;

public class Student
{
   private String firstName, lastName;
   private String homeAddress;
   private int test1, test2, test3;
   private final static double NUM_TESTS = 3.0;
   private int credits;


   public Student (String first, String last, String home,
                   int testScore1, int testScore2,
                   int testScore3, int incredits )
   {
      firstName = first;
      lastName = last;
      homeAddress = home;
      test1 = testScore1;
      test2 = testScore2;
      test3 = testScore3;
      credits = incredits;
   }


   public Student (String first, String last, String home)
   {
      firstName = first;
      lastName = last;
      homeAddress = home;
      test1 = test2 = test3 = 0;
   }


   public void setTestScore(int testNumber, int score)
   {
      switch (testNumber)
      {
         case 1 :
               test1 = score;
               break;
         case 2 :
               test2 = score;
               break;
         case 3 :
               test3 = score;
      }
   }


   public double average()
   {
      double average = test1 + test2 + test3;
      return average / NUM_TESTS;

   }


   public int getTestScore(int testNumber)
   {
      switch (testNumber)
      {
         case 1 : return test1;
         case 2 : return test2;
         case 3 : return test3;
         default : return 0;
      }
   }

   public String testLength(double time)
   {
       return "This student has " + time + " minutes to take the test.";
   }


   public String toString()
   {
      String result = "";

      result += firstName + " " + lastName + "\n";
      result += "Home Address:\n" + homeAddress;
      result += "\nTest 1 score: " + test1;
      result += "\nTest 2 score: " + test2;
      result += "\nTest 3 score: " + test3;

      result += "\nAverage test score: " + average() + "\n";

      return result;
   }
}
