
public class Student { //Referencing class Student
	
	//Creating private variables for each Student
	private String firstName;
	private String lastName;
	private double GPA;
	private boolean isDeansList; //3.50 GPA or Above
	private boolean isPresidentsList; //4.00 GPA
	private Student next;
	
	public Student (String firstname, String lastname, double gpa, Student nxt) { //Creating constructor for Students that includes a passed in first name, last name, and GPA value.
		this.firstName = firstname;
		this.lastName = lastname;
		this.GPA = gpa;
		this.next = nxt;
	}
	
	public void displayStudent() { // Creating method displayStudent to display the values of a single student
		System.out.print("[ First Name: " + this.firstName + " || Last Name: " + this.lastName + " || GPA: " + this.GPA + "  ]");
	}
		
	

}
