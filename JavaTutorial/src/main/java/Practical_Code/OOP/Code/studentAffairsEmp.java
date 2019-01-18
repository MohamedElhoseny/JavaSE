package Practical_Code.OOP.Code;

import java.util.ArrayList;

/**
 *
 * @author Tamer A.Yassen
 */
public class studentAffairsEmp extends Staff {

    private final String EmpFileName = "Employee.txt";

    public static ArrayList<studentAffairsEmp> Employees = new ArrayList<studentAffairsEmp>();

    public studentAffairsEmp() {
    }

    public studentAffairsEmp(String user, String pass, int id, String fname, String lname, int age, double salary, Department dept) {
        super(user, pass, id, fname, lname, age, salary, dept);
    }

    public boolean addEmp() {
        if (FManger.write(getEmpData(), EmpFileName, true)) {
            return true;
        } else {
            return false;
        }
    }

    private String getEmpData() {
        return this.id + "@" + this.fname + "@" + this.lname + "@" + this.age + "@" + this.salary + "@" + this.myDept.getDeptName() + "@" + this.userName + "@" + this.pass + "@";
    }

          
    private void commitToFile() {
        FManger.write(Employees.get(0).getEmpData(), EmpFileName, false);
        for (int i = 1; i < Employees.size(); i++) {
            FManger.write(Employees.get(i).getEmpData(), EmpFileName, true);
        }

    }

    private int getEmpIndex(int id){
        for (int i = 0; i < Employees.size(); i++)
            if(Employees.get(i).getID() == id)
                return i;
        
        return -1;
    }
    
    private void loadFromFile() {
            Employees = (ArrayList<studentAffairsEmp>) (Object) FManger.read(EmpFileName);
    }

    public String displayAllEmp() {
        loadFromFile();
        String S = "\nAll Employees Data:\n";
        for (studentAffairsEmp x : Employees) {
            S = S + x.toString();
        }
        return S;
    }
    
    public String searchEmp(int id){
        loadFromFile();
        int index = getEmpIndex(id);
        if(index != -1)
            return "\nFound ...!" + Employees.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    
    public void updateEmp(int oldID, studentAffairsEmp x){
        loadFromFile();
        int index = getEmpIndex(oldID);
        Employees.set(index, x);
        commitToFile();
    } 
    
    public void deleteEmp(int id){
        loadFromFile();
        int index = getEmpIndex(id);
        Employees.remove(index);
        commitToFile();
    } 
    
    @Override
    public String toString() {
        return "\nI'm Student Affairs Emp : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + " Salary : " + salary + "\n" + "Dept. : " + myDept.getDeptName() + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

}
