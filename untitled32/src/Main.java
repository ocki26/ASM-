import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numStudents = 0;
        while (true){



            System.out.println("Enter number of students:");
            try {
                numStudents = sc.nextInt();
                sc.nextLine();
                if (numStudents > 0) {
                    break;
                } else {
                    System.out.println("Number of students must be greater than 0. Please re-enter.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please re-enter.");
                sc.nextLine();
            }
        }

        StudentManager studentManager = new StudentManager(numStudents);
        boolean running = true;

        while (running) {
            System.out.println("\nSelect one of the following options:");
            System.out.println("1. Add students");
            System.out.println("2. Search for students");
            System.out.println("3. Delete student");
            System.out.println("4. Print student list");
            System.out.println("5. exit");
            System.out.print("Enter your selection:");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("name: ");
                            String name = sc.nextLine();

                            System.out.print("mark: ");
                            int mark = sc.nextInt();
                            sc.nextLine();

                            Student student = new Student(id, name, mark);
                            studentManager.addStudent(student);
                            System.out.println("Added student.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please re-enter.");
                            sc.nextLine();
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Enter the student ID you want to search for: ");
                            int searchId = sc.nextInt();
                            sc.nextLine();

                            Student foundStudent = studentManager.searchStudent(searchId);
                            if (foundStudent != null) {
                                System.out.println("Find student with ID" + searchId + ": " + foundStudent.name + ", mark: " + foundStudent.mark + ", rank: " + foundStudent.rank);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please re-enter.");
                            sc.nextLine();
                        }
                        break;
                    case 3:
                        try {
                            System.out.print("Enter the student ID you want to delete for ");
                            int deleteId = sc.nextInt();
                            studentManager.deleteStudent(deleteId);
                            System.out.println("Student deleted.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please re-enter");
                            sc.nextLine();
                        }
                        break;
                    case 4:
                        studentManager.printStudents();
                        break;
                    case 5:
                        running = false;
                        System.out.println("The program ends.");
                        break;
                    default:
                        System.out.println("Invalid selection. Please re-enter..");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid selection. Please re-enter..");
                sc.nextLine();
            }
        }

        sc.close();
    }
}
