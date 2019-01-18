package Practical_Code.OOP.Code;
import java.util.ArrayList;

/**
 *
 * @author Tamer A.Yassen
 */
public class Professor extends Staff
{
    private String officeHours;
    private final String professorFileName = "Professor.txt";
    public static ArrayList<Professor> Professors = new ArrayList<>();

    public Professor() {
    }

    public Professor(String user, String pass, int id, String fname,
                     String lname, int age, double salary, String officeHours, Department dept) {
        super(user, pass, id, fname, lname, age, salary, dept);
        this.officeHours = officeHours;
    }

    public void setOfficeHours(String h) {
        this.officeHours = h;
    }
    public String getOfficeHours() {
        return this.officeHours;
    }

    public boolean addProf(){
        return FManger.write(getProfData(), professorFileName, true);
    }
    private String getProfData(){
        return this.id + "@" + this.fname + "@" + this.lname + "@" + this.age + "@" + this.salary + "@" + this.officeHours + "@" + this.myDept.getDeptName() + "@" + this.userName + "@" + this.pass + "@";
    }
    
    private void commitToFile() {
        FManger.write(Professors.get(0).getProfData(), professorFileName, false);
        for (int i = 1; i < Professors.size(); i++) {
            FManger.write(Professors.get(i).getProfData(), professorFileName, true);
        }
    }

    private int getProfIndex(int id){
        for (int i = 0; i < Professors.size(); i++)
            if(Professors.get(i).getID() == id)
                return i;
        return -1;
    }
    
    private void loadFromFile() {
            Professors = (ArrayList<Professor>) (Object) FManger.read(professorFileName);
    }

    public String displayAllProfs() {
        loadFromFile();
        StringBuilder S = new StringBuilder("\nAll Professors Data:\n");
        for (Professor x : Professors) {
            S.append(x.toString());
        }
        return S.toString();
    }
    
    public String searchProf(int id){
        loadFromFile();
        int index = getProfIndex(id);
        if(index != -1)
            return "\nFound ...!" + Professors.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    
    public void updateProf(int oldID, Professor x){
        loadFromFile();
        int index = getProfIndex(oldID);
        Professors.set(index, x);
        commitToFile();
    } 
    
    public void deleteProf(int id){
        loadFromFile();
        int index = getProfIndex(id);
        Professors.remove(index);
        commitToFile();
    } 
    
    
    @Override
    public String toString() {
        return "\nI'm Prof : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + " Salary : " + officeHours + "\n" + "Dept. : " + myDept.getDeptName() + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

    public void teach() {
        System.out.println("I'm Teaching all Lectures !");
    }
}
