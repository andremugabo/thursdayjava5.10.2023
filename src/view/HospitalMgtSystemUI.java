
package view;

import DAO.PatientDao;
import java.util.Scanner;
import model.Patient;

/**
 *
 * @author jeremie
 */
public class HospitalMgtSystemUI {
    public static void main(String[] args) {
        boolean condition = true;
        int patientId;
        String names;
        Patient thePatient = new Patient();
        PatientDao dao = new PatientDao();
        String feedBack;
        String answer;
        while (condition) {
            System.out.println("=================");
            System.out.println("1. Create a Patient");
            System.out.println("2. Update a Patient");
            System.out.println("3. Delete a Patient");
            System.out.println("4. Retrieve all Patient");
            System.out.println("5. Search Patient by Id ");
            System.out.println("6. Insert Patient By Prepared Statement ");
            System.out.println("0. Exit");
            System.out.println("Choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    patientId = sc.nextInt();
                    System.out.print("Enter Names     :");
                    names = sc.next();
                    // create Model Object
                    thePatient.setPatientId(patientId);
                    thePatient.setPatientNames(names);
                    // create DAO Object

                    feedBack = dao.createPatient(thePatient);
                    System.out.println(feedBack);
                    System.out.println("Enter Yes or No to quit");
                    answer = sc.next();
                    if (answer.equalsIgnoreCase("yes")) {
                        condition = true;
                    } else {
                        System.out.println("Thank you for using the system");
                        condition = false;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.print("Enter Patient ID: ");
                    patientId = sc.nextInt();
                    System.out.print("Enter Names     :");
                    names = sc.next();
                    // create Model Object

                    thePatient.setPatientId(patientId);
                    thePatient.setPatientNames(names);
                    // create DAO Object
                    feedBack = dao.createPatientPrepared(thePatient);
                    System.out.println(feedBack);
                    System.out.println("Enter Yes or No to quit");
                    answer = sc.next();
                    if (answer.equalsIgnoreCase("yes")) {
                        condition = true;
                    } else {
                        System.out.println("Thank you for using the system");
                        condition = false;
                    }
                    break;
                case 0:
                    System.out.println("Thank you for using the system");
                    System.exit(0);
                    break;
                default:

            }
        }
    }
}
