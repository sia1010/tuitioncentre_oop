public class Tutor {
    // attributes
    Name name = new Name();
    private String ic;
    private String address;
    private int numYearExp;
    private String qualification;

    public Tutor(String firstName) {
        name.setFirstName(firstName);
    }
    public Tutor(String firstName, String lastName) {
        name.setFirstName(firstName);
        name.setLastName(lastName);
    }
    public Tutor(String firstName, String middleName, String lastName) {
        name.setFirstName(firstName);
        name.setMiddleName(middleName);
        name.setLastName(lastName);
    }

    // methods

    Name getName(){
        return name;
    }

    void setIc(String ic){
        this.ic = ic;
    }

    void setAddress(String address){
        this.address = address;
    }

    void setNumYearExp(int numYearExp){
        this.numYearExp = numYearExp;
    }

    void setQualification(String qualification){
        this.qualification = qualification;
    }

    String getIc() {
        return ic;
    }

    String getAddress() {
        return address;
    }

    int getNumYearExp() {
        return numYearExp;
    }

    String getQualification() {
        return qualification;
    }
}
