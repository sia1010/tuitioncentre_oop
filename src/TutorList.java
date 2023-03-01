public class TutorList {
    private int index = 0;
    private Tutor[] tutors = new Tutor[0];

    void addTutor(Tutor new_tutor){
        tutors = tutorsWithExtraIndex();
        tutors[index++] = new_tutor;
    }

    boolean find(String name_query){
        for (Tutor t : tutors){
            if (t.getName().getFirstName().equalsIgnoreCase(name_query)
                    || t.getName().getMiddleName().equalsIgnoreCase(name_query)
                    || t.getName().getLastName().equalsIgnoreCase(name_query)){
                return true;
            }
        }
        return false;
    }

    Tutor findTutor(String name_query){
        for (Tutor t : tutors){
            if (t.getName().getFirstName().equalsIgnoreCase(name_query)
                    || t.getName().getMiddleName().equalsIgnoreCase(name_query)
                    || t.getName().getLastName().equalsIgnoreCase(name_query)){
                return t;
            }
        }
        return new Tutor("null");
    }

    Tutor[] tutorsWithExtraIndex(){
        Tutor[] new_arr = new Tutor[index+1];
        int i = 0;
        for (Tutor stu : tutors){
            new_arr[i] = stu;
            i += 1;
        }
        return new_arr;
    }

    Tutor[] getTutors(){
        return tutors;
    }
}
