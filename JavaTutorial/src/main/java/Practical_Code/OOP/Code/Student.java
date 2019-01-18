package Practical_Code.OOP.Code;

import java.util.ArrayList;

/**
 *
 * @author Tamer A.Yassen
 */
public class Student extends Person {
	private int level;
	private double GPA;
	private final String studentFileName = "Students.txt";
	public static ArrayList<Student> Students = new ArrayList<>();

	public Student() {
	}

	public Student(String user, String pass, int id, String fname, String lname, int age, int level, double GPA,
			Department dept) {
		super(user, pass, id, fname, lname, age, dept);
		this.level = level;
		this.GPA = GPA;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

	public int getLevel() {
		return this.level;
	}

	public double getGPA() {
		return this.GPA;
	}

	public boolean addStudent() {
		return FManger.write(getStudentData(), studentFileName, true);
	}

	private String getStudentData() {
		return this.id + "@" + this.fname + "@" + this.lname + "@" + this.age + "@" + this.level + "@" + this.GPA + "@"
				+ myDept.getDeptName() + "@" + this.userName + "@" + this.pass + "@";
	}

	private void commitToFile() {
		// Clean up existing data first then append others
		FManger.write(Students.get(0).getStudentData(), studentFileName, false);
		for (int i = 1; i < Students.size(); i++) {
			FManger.write(Students.get(i).getStudentData(), studentFileName, true);
		}

	}

	private int getStudentIndex(int id) {
		for (int i = 0; i < Students.size(); i++)
			if (Students.get(i).getID() == id)
				return i;

		return -1;
	}

	@SuppressWarnings("unchecked")
	private void loadFromFile() {
		Students = (ArrayList<Student>) (Object) FManger.read(studentFileName);
	}

	public String displayAllStudents() {
		loadFromFile();
		String S = "\nAll Student Data:\n";
		for (Student x : Students) {
			S = S + x.toString();
		}
		return S;
	}

	public String searchStudent(int id) {
		loadFromFile();
		int index = getStudentIndex(id);
		if (index != -1)
			return "\nFound ...!" + Students.get(index).toString();
		else
			return "\nNot Found ...!";
	}

	public void updateStudent(int oldID, Student x) {
		loadFromFile();
		int index = getStudentIndex(oldID);
		Students.set(index, x);
		commitToFile();
	}

	public void deleteStudent(int id) {
		loadFromFile();
		int index = getStudentIndex(id);
		Students.remove(index);
		commitToFile();
	}

	@Override
	public String toString() {
		return "\nI'm Eng : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + "\n" + "Level : " + level
				+ " GPA : " + GPA + "\nDept: " + myDept.getDeptName() + "\nUserName: " + userName + "\t Password: "
				+ pass + "\n";
	}

	public void study() {
		System.out.println("I'm Studying Undergraduate Courses @ FCIH :) ");
	}
}
