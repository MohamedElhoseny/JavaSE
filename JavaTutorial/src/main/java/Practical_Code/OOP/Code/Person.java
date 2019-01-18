package Practical_Code.OOP.Code;
/**
 *
 * @author Tamer A.Yassen
 */
public abstract class Person
{
    protected int id;
    protected String userName;
    protected String pass;
    protected String fname;
    protected String lname;
    protected int age;
    protected Department myDept;
    protected FileManger FManger = new FileManger();

    public Person() {
    }

    public Person(String user, String pass, int id, String fname, String lname, int age, Department dept)
    {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.userName = user;
        this.pass = pass;
        this.myDept = dept;
    }

    @Override
    public abstract String toString();

    //setter
    public void setID(int id) {
        this.id = id;
    }

    public void setFName(String fname) {
        this.fname = fname;
    }

    public void setLName(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setDept(Department dept) {
        this.myDept = dept;
    }

    //getter
    public String getuserName() {
        return this.userName;
    }

    public String getPass() {
        return this.pass;
    }

    public int getID() {
        return this.id;
    }

    public String getFName() {
        return this.fname;
    }

    public String getLName() {
        return this.lname;
    }

    public int getAge() {
        return this.age;
    }

    public boolean login(String userName, String Pass) {
        if (userName.equals("Admin") && Pass.equals("123")) {
            return true;
        }
        return false;
    }
}
