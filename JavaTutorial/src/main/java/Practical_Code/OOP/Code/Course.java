package Practical_Code.OOP.Code;
import java.util.ArrayList;

/**
 *
 * @author Tamer A.Yassen
 */
public class Course
{
    private String CName, CId;
    private int CreditHours;

    FileManger FManger = new FileManger();
    private final String CourseFileName = "Courses.txt";

    Department dept;
    Exam finalExame;
    
     public static ArrayList<Course> Courses = new ArrayList<Course>();

    
    public Course(){
    }
    
    public Course(String Cname, String CId, int CreditHours, Department dept) {
        this.CName = Cname;
        this.CId = CId;
        this.CreditHours = CreditHours;
        
        this.dept = dept;
        
        finalExame = new Exam(Cname + " Final Exam", CId + " 01", 100);
        System.out.println("\n"+finalExame.toString() + "Added Successfully ... !");
        finalExame.addExam();
    }

    public void setCId(String Id) {
        this.CId = Id;
    }

    public void setCname(String name) {
        this.CName = name;
    }

    public void setCreditHours(int CreditHours) {
        this.CreditHours = CreditHours;
    }

    public String getCId() {
        return this.CId;
    }

    public String getCname() {
        return this.CName;
    }

    public int getCreditHours() {
        return this.CreditHours;
    }

    public boolean addCourse() {
        if (FManger.write(getCourseData(), CourseFileName, true)) {
            return true;
        } else {
            return false;
        }
    }

    private String getCourseData() {
        return this.CName + "@" + this.CId + "@" + this.CreditHours + "@";
    }

      
    private void commitToFile() {
        FManger.write(Courses.get(0).getCourseData(), CourseFileName, false);
        for (int i = 1; i < Courses.size(); i++) {
            FManger.write(Courses.get(i).getCourseData(), CourseFileName, true);
        }

    }

    private int getCourseIndex(String id){
        for (int i = 0; i < Courses.size(); i++)
            if(Courses.get(i).getCId().equals(id))
                return i;
        
        return -1;
    }
    
    private void loadFromFile()
    {
        Courses = (ArrayList<Course>) (Object) FManger.read(CourseFileName);
    }

    public String displayAllCourses() {
        loadFromFile();
        String S = "\nAll Courses Data:\n";
        for (Course x : Courses) {
            S = S + x.toString();
        }
        return S;
    }
    
    public String searchCourse(String id){
        loadFromFile();
        int index = getCourseIndex(id);
        if(index != -1)
            return "\nFound ...!" + Courses.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    
    public void updateCourse(String oldID, Course x){
        loadFromFile();
        int index = getCourseIndex(oldID);
        Courses.set(index, x);
        commitToFile();
    } 
    
    public void deleteCourse(String id){
        loadFromFile();
        int index = getCourseIndex(id);
        Courses.remove(index);
        commitToFile();
    } 
  
    
    @Override
    public String toString() {
        return "\nCourse Name : " + CName + "\t" + "Course ID : " + CId + "\n" + "Course Credit Hours : " + CreditHours + "\n";
    }
}
