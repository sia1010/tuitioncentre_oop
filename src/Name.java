public class Name {
    private String f_name;
    private String m_name;
    private String l_name;

    public Name(){
        f_name = "";
        m_name = "";
        l_name = "";
    }

    void setFirstName(String f_name){
        this.f_name = f_name;
    }
    void setMiddleName(String m_name){
        this.m_name = m_name;
    }
    void setLastName(String l_name){
        this.l_name = l_name;
    }

    String getFirstName(){
        return f_name;
    }
    String getMiddleName(){
        return m_name;
    }
    String getLastName(){
        return  l_name;
    }
    String getFullName(){
        return f_name + " " + m_name + " " + l_name;
    }
}
