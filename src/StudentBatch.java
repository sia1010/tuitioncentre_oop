import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StudentBatch {
    private int index = 0;
    private Student[] students = new Student[0];

    void addStudent(Student new_student){
        students = studentsWithExtraIndex();
        students[index++] = new_student;
    }

    boolean find(String name_query){
        for (Student s : students){
            if (s.getName().getFirstName().equalsIgnoreCase(name_query)
                    || s.getName().getMiddleName().equalsIgnoreCase(name_query)
                    || s.getName().getLastName().equalsIgnoreCase(name_query)){
                return true;
            }
        }
        return false;
    }

    Student findStudent(String name_query){
        for (Student s : students){
            if (s.getName().getFirstName().equalsIgnoreCase(name_query)
                    || s.getName().getMiddleName().equalsIgnoreCase(name_query)
                    || s.getName().getLastName().equalsIgnoreCase(name_query)){
                return s;
            }
        }
        return new Student("null");
    }

    Student[] studentsWithExtraIndex(){
        Student[] new_arr = new Student[index+1];
        int i = 0;
        for (Student stu : students){
            new_arr[i] = stu;
            i += 1;
        }
        return new_arr;
    }

    Student[] getStudents(){
        return students;
    }

    void saveMarksToFile(){
        File file = new File("Student_File.txt");
        if (!file.exists()){
            try { // create the file
                if (file.createNewFile()) {
                    System.out.println("New file created");
                }
            } catch (IOException ex) {
                System.out.println("ERR: Can't make new file");
                ex.printStackTrace();
            }
        }

        try { // open and write into file
            FileWriter fileWriter = new FileWriter("Student_File.txt");
            fileWriter.write("Average Students Marks Report\n");
            for (Student student : students) {
                fileWriter.write("Student: " + student.getName().getFullName() + "\nAverage Marks: " + student.calcAverage() + "\n\n");
            }
            fileWriter.close();
        }catch (IOException ex){
            System.out.println("ERR: Can't write to file");
            ex.printStackTrace();
        }
    }
}
