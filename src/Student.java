public class Student {
    // attributes
    private final Name name = new Name();
    private String ic;
    private String address;
    private String schoolName;
    float[] marks = new float[5];
    private Tutor tutor;

    public Student(String firstName) {
        name.setFirstName(firstName);
    }
    public Student(String firstName, String lastName) {
        name.setFirstName(firstName);
        name.setLastName(lastName);
    }
    public Student(String firstName, String middleName, String lastName) {
        name.setFirstName(firstName);
        name.setMiddleName(middleName);
        name.setLastName(lastName);
    }

    // methods

    Name getName(){
        return name;
    }

    void setMark(float mark, int index){
        marks[index] = mark;
    }
    float calcAverage(){
        int total = 0;
        for (int i =0; i < 5; i++){
            total += marks[i];
        }
        return total / 5.0f;
    }

    float calcMin(){
        float min = 99999f;
        for (int i =0; i < 5; i++){
            if (min > marks[i]){
                min = marks[i];
            }
        }
        return min;
    }

    void setIc(String ic){
        this.ic = ic;
    }

    void setAddress(String address){
        this.address = address;
    }

    void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    void setTutor(Tutor tutor){
        this.tutor = tutor;
    }

    String getIc(){
        return ic;
    }

    String getAddress() {
        return address;
    }

    String getSchoolName() {
        return schoolName;
    }

    Tutor getTutor() {
        return tutor;
    }
}
