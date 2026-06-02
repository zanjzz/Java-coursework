package week_7;

public class StudentGradeManager {

    public static void main(String[] args) {

        int[][] studentGrades = {
            {101, 85},
            {102, 92},
            {103, 78},
            {104, 88}
        };

        StudentManager bsit = new StudentManager(studentGrades);

        int searchStudent = 103;
        int foundGrade = bsit.searchGrade(searchStudent);

        bsit.displayGrade();

        // Condition if grade was found
        if (foundGrade != -1) {
            System.out.printf(
                "Grade for Student ID %d: %d\n",
                searchStudent,
                foundGrade
            );
        } else {
            System.out.printf(
                "Student ID %d not found.\n",
                searchStudent
            );
        }
    }
}

class StudentManager {

    private int[][] studentGrades;

    StudentManager(int[][] studentGrades) {
        this.studentGrades = studentGrades;
    }

    void displayGrade() {
        System.out.printf(
            "Average Grade: %.2f\n" +
            "Highest Grade: %d\n" +
            "Lowest Grade: %d\n",
            averageGrade(),
            highestGrade(),
            lowestGrade()
        );
    }

    double averageGrade() {
        double total = 0;

        // Using a loop to accumulate the grades in the array
        for (int[] student : studentGrades) {
            total += student[1];
        }

        // Dividing the total to get the average
        return total / studentGrades.length;
    }

    int highestGrade() {
        int max = studentGrades[0][1];

        // Find the largest grade
        for (int[] student : studentGrades) {
            if (student[1] > max) {
                max = student[1];
            }
        }

        return max;
    }

    int lowestGrade() {
        int min = studentGrades[0][1];

        // Find the smallest grade
        for (int[] student : studentGrades) {
            if (student[1] < min) {
                min = student[1];
            }
        }

        return min;
    }

    int searchGrade(int studentId) {

        // Using simple linear search
        for (int[] student : studentGrades) {
            if (student[0] == studentId) {
                return student[1];
            }
        }

        return -1;
    }
}
