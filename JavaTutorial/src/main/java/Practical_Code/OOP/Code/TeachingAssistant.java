package Practical_Code.OOP.Code;

import java.util.ArrayList;

/**
 *
 * @author Tamer A.Yassen
 */
public class TeachingAssistant extends Staff {

    private String academicHours;

    private final String TAFileName = "TA.txt";
    
    public static ArrayList<TeachingAssistant> TAs = new ArrayList<TeachingAssistant>();

    public TeachingAssistant() {
    }

    public TeachingAssistant(String user, String pass, int id, String fname, String lname, int age, double salary, String academicHours, Department dept) {
        super(user, pass, id, fname, lname, age, salary, dept);
        this.academicHours = academicHours;
    }

    public void setacademicHours(String h) {
        this.academicHours = h;
    }

    public String getacademicHours() {
        return this.academicHours;
    }

    public boolean addTA() {
        if (FManger.write(getTAData(), TAFileName, true)) {
            return true;
        } else {
            return false;
        }
    }

    private String getTAData() {
        return this.id + "@" + this.fname + "@" + this.lname + "@" + this.age + "@" + this.salary + "@" + this.academicHours + "@" + this.myDept.getDeptName() + "@" + this.userName + "@" + this.pass + "@";
    }

      
    private void commitToFile() {
        FManger.write(TAs.get(0).getTAData(), TAFileName, false);
        for (int i = 1; i < TAs.size(); i++) {
            FManger.write(TAs.get(i).getTAData(), TAFileName, true);
        }

    }

    private int getTAIndex(int id){
        for (int i = 0; i < TAs.size(); i++)
            if(TAs.get(i).getID() == id)
                return i;
        
        return -1;
    }
    
    private void loadFromFile() {
            TAs = (ArrayList<TeachingAssistant>) (Object) FManger.read(TAFileName);
    }

    public String displayAllTAs() {
        loadFromFile();
        String S = "\nAll TAs Data:\n";
        for (TeachingAssistant x : TAs) {
            S = S + x.toString();
        }
        return S;
    }
    
    public String searchTA(int id){
        loadFromFile();
        int index = getTAIndex(id);
        if(index != -1)
            return "\nFound ...!" + TAs.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    
    public void updateTA(int oldID, TeachingAssistant x){
        loadFromFile();
        int index = getTAIndex(oldID);
        TAs.set(index, x);
        commitToFile();
    } 
    
    public void deleteTA(int id){
        loadFromFile();
        int index = getTAIndex(id);
        TAs.remove(index);
        commitToFile();
    } 
    

    @Override
    public String toString() {
        return "\nI'm Teaching Assistant : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + " Salary : " + salary + "\n" + "Dept. : " + myDept.getDeptName() + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

    public void teach() {
        System.out.println("I'm Teaching all Sections!");
    }

    public void study() {
        System.out.println("I'm Studying Postgraduate Courses @ FCIH :) ");
    }

}
