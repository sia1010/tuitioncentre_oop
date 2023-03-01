import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentBatch students_arr = new StudentBatch();
        TutorList tutors_arr = new TutorList();
        int menu_selection = -1;

        while (menu_selection != 0){
            System.out.print("""
                    Sia's Success Tuition Centre Record System
                    1.Add Tutor
                    2.Add Student
                    3.Find Student
                    4.Display Tutor List
                    5.Display Student Report
                    0.Quit
                    >\s""");
            menu_selection = scanner.nextInt();

            switch(menu_selection){
                case 1: // adding tutors
                    System.out.print("Tutor First Name: "); String tutor_fname = scanner.next();
                    System.out.print("Tutor Middle Name: "); String tutor_mname = scanner.next();
                    System.out.print("Tutor Last Name: "); String tutor_lname = scanner.next();
                    Tutor new_tutor = new Tutor(tutor_fname, tutor_mname, tutor_lname);

                    System.out.print("Tutor IC: "); new_tutor.setIc(scanner.next());
                    System.out.print("Tutor Address: "); new_tutor.setAddress(scanner.next());
                    System.out.print("Tutor Number of Year of Experience: "); new_tutor.setNumYearExp(scanner.nextInt());
                    System.out.print("Tutor Qualification: "); new_tutor.setQualification(scanner.next());

                    tutors_arr.addTutor(new_tutor); // add into the array
                    System.out.println(new_tutor.getName().getFullName() + " has been successfully added.");
                    break;

                case 2: // adding students
                    System.out.print("Student First Name: "); String student_fname = scanner.next();
                    System.out.print("Student Middle Name: "); String student_mname = scanner.next();
                    System.out.print("Student Last Name: "); String student_lname = scanner.next();
                    Student new_student = new Student(student_fname, student_mname, student_lname);

                    System.out.print("Student IC: "); new_student.setIc(scanner.next());
                    System.out.print("Student Address: "); new_student.setAddress(scanner.next());
                    System.out.print("Student School: "); new_student.setSchoolName(scanner.next());

                    for (int i = 0; i < 5; i++){ // marks for all the students
                        System.out.print("Enter Mark #"+(i + 1)+": ");
                        new_student.setMark(scanner.nextInt(), i);
                    }

                    while(true){ // assigning a tutor to the student
                        System.out.print("Student Tutor: "); String search_tutor = scanner.next();
                        if (tutors_arr.find(search_tutor)){
                            new_student.setTutor(tutors_arr.findTutor(search_tutor));
                            System.out.println("**TUTOR FOUND**");
                            break;
                        }else{
                            System.out.print("**NOT FOUND**\nTry Again. ");
                        }
                    }

                    students_arr.addStudent(new_student); // add into the array
                    System.out.println(new_student.getName().getFullName() + " has been successfully added.");
                    break;

                case 3:
                    System.out.print("Search Term: "); // get the search term
                    String search_term = scanner.next();

                    if (students_arr.find(search_term)){ // if search term match, display the student
                        Student found_student = students_arr.findStudent(search_term);
                        System.out.println("**FOUND**");
                        System.out.println( "\nName: " + found_student.getName().getFullName() +
                                            "\nIC: " + found_student.getIc() +
                                            "\nAddress: " + found_student.getAddress() +
                                            "\nSchool: " + found_student.getSchoolName() +
                                            "\nAverage Marks: " + found_student.calcAverage() +
                                            "\nMinimum Marks: " + found_student.calcMin() +
                                            "\nTutor: " + found_student.getTutor().getName().getFullName());
                    }else{
                        System.out.println("**MISSING**");
                    }
                    break;

                case 4:
                    for (Tutor t : tutors_arr.getTutors()){
                        System.out.println( "\nName: " + t.getName().getFullName() +
                                "\nIC: " + t.getIc() +
                                "\nAddress: " + t.getAddress() +
                                "\nNumber of Year of Experience: " + t.getNumYearExp() +
                                "\nQualification: " + t.getQualification());
                    }
                    break;

                case 5:
                    for (Student s : students_arr.getStudents()){
                        System.out.println( "\nName: " + s.getName().getFullName() +
                                            "\nIC: " + s.getIc() +
                                            "\nAddress: " + s.getAddress() +
                                            "\nSchool: " + s.getSchoolName() +
                                            "\nAverage Marks: " + s.calcAverage() +
                                            "\nMinimum Marks: " + s.calcMin() +
                                            "\nTutor: " + s.getTutor().getName().getFullName());
                    }
                    break;

                case 0:
                    students_arr.saveMarksToFile();
                    System.out.println("--- System shutting down ---");

            }
        }
    }
}