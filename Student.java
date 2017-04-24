
public class Student { //Referencing class Student
	
	//Creating private variables for each Student
	public String firstName;
	public String lastName;
	public double GPA;
	public boolean isDeansList; //3.50 GPA or Above
	public boolean isPresidentsList; //4.00 GPA
	public Student next;
	
	public Student(String firstname, String lastname, double gpa) { //Creating constructor for a Link with cData variable passed in.
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.GPA = gpa;
	}
	
	public Student (String firstname, String lastname, double gpa, Student nxt) { //Creating constructor for Students that includes a passed in first name, last name, and GPA value.
		this.firstName = firstname;
		this.lastName = lastname;
		this.GPA = gpa;
		this.next = nxt;
	}
	
	public void displayStudent() { // Creating method displayStudent to display the values of a single student
		System.out.print("[ First Name: " + this.firstName + " || Last Name: " + this.lastName + " || GPA: " + this.GPA + " || On the Dean's List: " + this.isDeansList + " || On President's List: " + this.isPresidentsList + " ]");
	}
}
