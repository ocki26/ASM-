//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class StudentManager {
    private Student[] students;
    private int size;

    public StudentManager(int capacity) {
        this.students = new Student[capacity];
        this.size = 0;
    }

    public void addStudent(Student student) {
        if (this.size < this.students.length) {
            this.students[this.size] = student;
            ++this.size;
            this.bubbleSortAndUpdateRanks();
        } else {
            System.out.println("Cannot add student. Array is full.");
        }

    }

    public void deleteStudent(int id) {
        try {
            int index = this.findStudentIndexById(id);
            if (index == -1) {
                throw new Exception("No student found with ID " + id);
            }

            for(int i = index; i < this.size - 1; ++i) {
                this.students[i] = this.students[i + 1];
            }

            this.students[this.size - 1] = null;
            --this.size;
            this.bubbleSortAndUpdateRanks();
        } catch (Exception var4) {
            Exception e = var4;
            System.out.println("Error deleting student: " + e.getMessage());
        }

    }

    public Student searchStudent(int id) {
        try {
            int index = this.findStudentIndexById(id);
            if (index != -1) {
                return this.students[index];
            } else {
                throw new Exception("No student found with ID" + id);
            }
        } catch (Exception var3) {
            Exception e = var3;
            System.out.println("Error searching for students: " + e.getMessage());
            return null;
        }
    }

    private int findStudentIndexById(int id) {
        for(int i = 0; i < this.size; ++i) {
            if (this.students[i].id == id) {
                return i;
            }
        }

        return -1;
    }

    private void bubbleSortAndUpdateRanks() {
        int i;
        for(i = 0; i < this.size - 1; ++i) {
            boolean swapped = false;

            for(int j = 0; j < this.size - i - 1; ++j) {
                if (this.students[j].mark < this.students[j + 1].mark) {
                    Student temp = this.students[j];
                    this.students[j] = this.students[j + 1];
                    this.students[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        for(i = 0; i < this.size; ++i) {
            this.students[i].rank = this.getRank(this.students[i].mark);
        }

    }

    private String getRank(int mark) {
        if (mark >= 0 && (double)mark < 5.0) {
            return "Fail";
        } else if ((double)mark >= 5.0 && (double)mark < 6.5) {
            return "Medium";
        } else if ((double)mark >= 6.5 && (double)mark < 7.5) {
            return "Good";
        } else if ((double)mark >= 7.5 && (double)mark < 9.0) {
            return "Very Good";
        } else {
            return (double)mark >= 9.0 && (double)mark <= 10.0 ? "Excellent" : "Unknown";
        }
    }

    public void printStudents() {
        for(int i = 0; i < this.size; ++i) {
            int var10001 = this.students[i].id;
            System.out.println("ID: " + var10001 + ", Name: " + this.students[i].name + ", mark: " + this.students[i].mark + ", rank: " + this.students[i].rank);
        }

    }
}
