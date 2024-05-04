/** *****************************************************************************
 * Assignment5, BIS 335, Business Application Development, Fall 2023
 *
 * Author: Burak Eskici
 * Created on: October 07, 2023
 * Updated on: October 17, 2023
 * 
 * A Java program that reads the patients.txt file, and performs the following:
 * 
 * (1) reads in patients and prints them out in the same format
 * (2) stores the data in a 2D array of Strings
 * (3) Calculates the BMI for each patient (and stores that in the 2D array)
 * (4) Displays the names of the patients who has a BMI larger than 25.0
 * (5) Calculates the average BMI of the male patients
 * (6) Prints out the information of the female patients into a file, named FemalePatients.txt
 * using two subroutines:
 * -readFile()
 * -calculateBMI()
 **************************************************************************** */
package Assignment5;

public class MyBMI
{
    public static void main(String[] args) 
    {  
        
        String line;                                // each line that is read from the file
        String[] split;                             // array of Strings to hold the information for each patient
        String[][] myData = new String [40][10];    // 2D array to hold the data, with an additional column to hold BMI data for each patient
        double BMI, height, weight;                 // variables to hold BMI, height, and weight values for each patient during calculation
        double totalMaleBMI = 0, avgMaleBMI;        // total of BMI values of male patients to calculate the average
        int patientNo = 40, totalmalePatient = 0;    // patient counter, to be used while reading data and as an index for the 2D array
                

        myData = readFile();
        //function 1
        for (int i = 0; i < 40; i++){
            for (int k = 0; k < 8; k++)
                System.out.print(myData[i][k] + ",");
            System.out.println();
        }
        for (int i = 0; i < patientNo; i++){
            BMI = calculateBMI (myData, i);
            myData[i][9] = Double.toString(BMI);
            if (myData[i][3].equals("M"))
                totalmalePatient++;
        }
        
        //printing out the names of the patients with BMI larger than 25
        System.out.println("Here is the list of patients with a BMI larger than 25:");
        for (int k = 0; k < patientNo; k++)
        {
            if (Double.parseDouble(myData[k][9]) >= 25)
                System.out.println(myData[k][0] + " " + myData[k][1]);
        }
        
        System.out.println();
        //calculating the average BMI for male patients
        System.out.print("The average BMI of male patients is:");
        for (int k = 0; k < patientNo; k++)
        {
            if (myData[k][3].equals("M"))
                totalMaleBMI = totalMaleBMI + Double.parseDouble(myData[k][9]);
        }
        avgMaleBMI = totalMaleBMI / totalmalePatient;
        System.out.printf("%.2f \n", avgMaleBMI);
                
        //printing out the data of female patients in file
        TextIO.writeFile("FemalePatients.txt");
        for (int k = 0; k < patientNo; k++)
        {
            if (myData[k][3].equals("F"))
            {
                for (int i = 0; i<9; i++)
                 TextIO.put(myData[k][i]+ ",");
                TextIO.putf("%.2f \n", Double.parseDouble(myData[k][9]));
            }
           //TextIO.putln();
        }
    }
    public static String[][] readFile ()
    {
        TextIO.readFile("Patients.txt"); //set the input file
        String line;                                // each line that is read from the file
        String[] split;                             // array of Strings to hold the information for each patient
        String[][] returnArray = new String[40][10];
        int pNo = 0; 
        double height, weight;
        
        while(!TextIO.eof())                        // loop to read each line of the text file, split it, and store in 2D array
        {                                           // in each iteration (ie for each patient)
            line = TextIO.getln();                  // read one line, consisting of data of the patient
            pNo++;                                 // increase the patient number
            split = line.split(",");           // put the data of the patient into a String array
            
            for (int i = 0; i<9; i++)               // for loop to put the patient data into the 2D array, in corresponding row
                returnArray[pNo-1][i] = split[i];      // the index is (patientNo-1) because we started at 1

        }                                           // at the end of this loop, I have all the information in myData array.
        return returnArray;
    }
    
    public static double calculateBMI (String[][] data, int ind){
        double height = Double.parseDouble(data[ind][7]);  // heigth of the patient
        double weight = Double.parseDouble(data[ind][8]);   // weigth of the patient
        double BMI = (weight/(height*height)) * 703;   // BMI calculation: BMI = Weight (in pounds)/(height [in inches])2 x 703 
        return BMI;
    }
}

