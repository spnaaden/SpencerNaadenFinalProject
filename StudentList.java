/**
 * Author: Spencer Naaden
 * This class holds the constructor for a StudentList (LinkList), and all of the variables and methods to operate the StudentList.
 */

public class StudentList { // Referencing class StudentList.

	// Creating private Student variables for StudentList operations.
	private Student firstStudent;
	private Student currentStudent;
	private Student previousStudent;
	int SIZE = 100;

	public StudentList() { // Creating constructor for StudentList.
		firstStudent = null;
	}

	/**
	 * Method isEmpty
	 * This method returns a boolean value based on whether a StudentList is empty or not. 
	 * This is a boolean method, so it returns a true or false the user based on whether the StudentList is empty. It does not accept any arguments.
	 */
	public boolean isEmpty() { // Creating boolean method isEmpty to check if a StudentList is Empty.
		System.out.println();
		return (firstStudent == null);	
	}

	/**
	 * Method searchStudent
	 * This method searches a StudentList for a student with a specified last name, and then displays that student's record if they exist.
	 * This is a void method, so it does not return a value. It accepts one argument, which is the last name the user want to search for in the StudentList.
	 */
	public void searchStudent(String studentLastName) { // Creating void method searchStudent to search for a specific student in a StudentList (using a last name from a student) returning the Student's position in memory if they exist.
		currentStudent = firstStudent;
		while (studentLastName.compareTo(currentStudent.lastName) != 0) {
			if (currentStudent.next == null) {
				System.out.println("Student was Not Found!");
				return;
			} else {
				currentStudent = currentStudent.next;
			}

		}

		System.out.println("Student Found:");
		System.out.println();
		currentStudent.displayStudent();
		System.out.println();

	}

	/**
	 * Method modifyStudent
	 * This methods searches a StudentList for a last name of a student, and if it finds the student, then it allows the user to submit new values to modify the existing student.
	 * This method is a void method, so it does not return any values. It does accept four arguments, the first being the old last name of the student that the user wants to modify, and the three other values are the new values the user would like to set for the student.
	 */
	public void modifyStudent(String oldStudentLastName, String newFirstName, String newLastName, double newGPA) { // Creating void method modifyStudent to search for a specific student (using a last name from a student) and to modify that student's values with passed in values if they exist.

		String tempFirstName = "";
		String tempLastName = "";
		double tempGPA = 0;
		boolean tempIsDeansList = false;
		boolean tempIsPresidentsList = false;
		
		boolean flag = false;
		int numberOfStudents = 0;
		
		if (newGPA < 0 || newGPA > 4) {
			System.out.println("Error, GPA cannot be lower than zero or higher than 4.");
			return;
		}

		currentStudent = firstStudent;
		while (oldStudentLastName.compareTo(currentStudent.lastName) != 0) {
			if (currentStudent.next == null) {
				System.out.println("Student Specified to Modify was Not Found!");
				return;
			} else {
				currentStudent = currentStudent.next;
			}
		}	
			currentStudent.firstName = newFirstName;
			currentStudent.lastName = newLastName;
			currentStudent.GPA = newGPA;
			
			currentStudent = firstStudent;
			
			while (flag == false ) {
				if (currentStudent == null) {
					flag = true;
				} else {
					numberOfStudents++;
					currentStudent = currentStudent.next;
				}
			} 
			
			for (int i = 0; i < numberOfStudents; i++) {
				currentStudent = firstStudent;
				for (int j = i + 1; j < numberOfStudents; j++){
					if (currentStudent.lastName.compareTo(currentStudent.next.lastName) > 0){
						
						tempFirstName = currentStudent.next.firstName;
						tempLastName = currentStudent.next.lastName;
						tempGPA = currentStudent.next.GPA;
						tempIsDeansList = currentStudent.next.isDeansList;
						tempIsPresidentsList = currentStudent.next.isPresidentsList;
						
						currentStudent.next.firstName = currentStudent.firstName;
						currentStudent.next.lastName = currentStudent.lastName;
						currentStudent.next.GPA = currentStudent.GPA;
						currentStudent.next.isDeansList = currentStudent.isDeansList;
						currentStudent.next.isPresidentsList = currentStudent.isPresidentsList;
						
						currentStudent.firstName = tempFirstName;
						currentStudent.lastName = tempLastName;
						currentStudent.GPA = tempGPA;
						currentStudent.isDeansList = tempIsDeansList;
						currentStudent.isPresidentsList = tempIsPresidentsList;
					}
					currentStudent = currentStudent.next;
				}
			}
		

		if (currentStudent.GPA == 4.00) {
			currentStudent.isPresidentsList = true;
			currentStudent.isDeansList = true;

		} else if (currentStudent.GPA >= 3.50) {
			currentStudent.isPresidentsList = false;
			currentStudent.isDeansList = true;

		} else {
			currentStudent.isPresidentsList = false;
			currentStudent.isDeansList = false;
		}

		System.out.println("Modified Student Results:");
		System.out.println();
		currentStudent.displayStudent();
		System.out.println();
	}

	/**
	 * Method searchDeansStudents
	 * This method searches a StudentList for all students with a GPA values equal or greater than 3.50, and displays all students that match that criteria.
	 * This method is a void method, so it does not return a value. It accepts one argument which is the last name of the student that the user wants to delete from the StudentList.
	 */
	public void searchDeansStudents() { // Creating void method searchDeansStudents that searches the StudentList for all students that have a GPA higher or equal to 3.50,  and then it displays those students if there are any that match the criteria.
		
		int deansStudentsCounter = 0;
		currentStudent = firstStudent;
		
		System.out.println("Current Students on the Dean's List:");
		System.out.println();
	
		while (currentStudent != null) {
			if (currentStudent.isDeansList == true) {
				deansStudentsCounter++;
				currentStudent.displayStudent();
				System.out.println();
				currentStudent = currentStudent.next;
			} else {
				currentStudent = currentStudent.next;
			}
		}
			if (deansStudentsCounter == 0){
				System.out.println("No Students Matching Requirements for the Dean's List were Found!");
			}
	}

	/**
	 * Method searchPresidentsStudents
	 * This method searches a StudentList for all students with a GPA values equal to 4.00, and displays all students that match that criteria.
	 * This method is a void method, so it does not return any values. It also does not accept any arguments. 
	 */
	public void searchPresidentsStudents() { // Creating void method searchPresidentsStudents that searches the StudentList for all students that have a GPA equal to 4.00, and then it displays those students if there are any that match the criteria.
		
		int presidentStudentsCounter = 0;
		currentStudent = firstStudent;
		
		System.out.println("Current Students on the President's List:");
		System.out.println();
	
		while (currentStudent != null) {
			if (currentStudent.isPresidentsList == true) {
				presidentStudentsCounter++;
				currentStudent.displayStudent();
				System.out.println();
				currentStudent = currentStudent.next;
			} else {
				currentStudent = currentStudent.next;
			}
		}
			if (presidentStudentsCounter == 0){
				System.out.println("No Students Matching Requirements for the President's List were Found!");
			}
	}

	/**
	 * Method deleteStudent
	 * This method searches for a student in the StudentList based on their last name, and if it finds a student with that last name, it deletes them from the StudentList.
	 * This method is a void method, so it does not return a value. It accepts one argument which is the last name of the student that the user wants to delete from the StudentList.
	 */
	public void deleteStudent(String studentLastName) { // Creating void method deleteStudent to search for a specific Student in a StudentList (using a last name from a student), and then delete the Student from the StudentList if they exist.
		if (isEmpty() == true) {
			System.out.println("The StudentList is Empty!");
			return;
		}

		currentStudent = firstStudent;
		previousStudent = firstStudent;
		while (currentStudent.lastName != studentLastName) {
			if (currentStudent.next == null) {
				System.out.println("Student Specified to Delete was Not Found!");
				return;
			} else {
				previousStudent = currentStudent;
				currentStudent = currentStudent.next;
			}
		}
		if (currentStudent == firstStudent) {
			firstStudent = firstStudent.next;
		} else {
			previousStudent.next = currentStudent.next;
		}

		System.out.println("Student Successfully Deleted!");
		System.out.println();
	}
	

	/**
	 * Method insertFirstStudent
	 * This method inserts a new student into the StudentList as the first student in the list. 
	 * This method is a void method, so it does not return a value. It accepts three arguments which are used as values for the new student being inserted into the StudentList.
	 */
	public void insertFirstStudent(String studentFirstName, String studentLastName, double studentGPA) { // Creating void method insertFirstStudent to insert a new Student at the start of a StudentList, and assigning it passed in values.

		if (isEmpty() != true) {
			System.out.println("Error, use the 'insertStudent' method to insert a student into a non-empty StudentList.");
			return;
		}

		if (studentGPA < 0 || studentGPA > 4) {
			System.out.println("Error, GPA cannot be lower than zero or higher than 4.");
			return;
		}

		Student newStudent = new Student(studentFirstName, studentLastName, studentGPA);

		if (newStudent.GPA >= 3.50) {
			newStudent.isDeansList = true;
		}

		if (newStudent.GPA == 4) {
			newStudent.isPresidentsList = true;
		}
		newStudent.next = firstStudent;
		firstStudent = newStudent;
		
		System.out.println("First Student Successfully Created:");
		System.out.println();
		firstStudent.displayStudent();
		System.out.println();
	}

	

	/**
	 * Method insertStudent
	 * This method takes in the values for a new student, inserts the student into the StudentList, and then sorts the whole StudentList.
	 * This method is a void method, so it does not return any value. It has four arguments: the first argument is used to find a student based on their last name to insert a student after, and the rest of the arguments are values for the new student.
	 */
	public void insertStudent(String studentToPlaceNewStudentAfter, String studentFirstName, String studentLastName, double studentGPA) { // Creating void method insertStudent to search a StudentList for a specific student(using a specific last name), and then inserting a new Student right after that one with another last name value that was passed in.
		
		String tempFirstName = "";
		String tempLastName = "";
		double tempGPA = 0;
		boolean tempIsDeansList = false;
		boolean tempIsPresidentsList = false;
		boolean flag = false;
		int numberOfStudents = 0;
		
		
		if (isEmpty() == true) {
			insertFirstStudent(studentFirstName, studentLastName, studentGPA);
			return;
		}

		if (studentGPA < 0 || studentGPA > 4) {
			System.out.println("Error, GPA cannot be lower than zero or higher than 4.");
			return;
		}

		currentStudent = firstStudent;
		while (currentStudent != null /*&& !(currentStudent.lastName.equals((studentToPlaceNewStudentAfter)))*/) {
			if(currentStudent.lastName.equals((studentToPlaceNewStudentAfter))){
				break;
			} else {
			currentStudent = currentStudent.next;
			}
		}
		
		if (currentStudent == null){
			System.out.println("Error, Could Not Locate Student to Place the New Student After.");
			return;
		}
			Student temp = currentStudent.next;
			currentStudent.next = new Student(studentFirstName, studentLastName, studentGPA, temp);

		if (currentStudent.next.GPA == 4) {
			currentStudent.next.isPresidentsList = true;
			currentStudent.next.isDeansList = true;
		} else if (currentStudent.next.GPA >= 3.50) {
			currentStudent.next.isPresidentsList = false;
			currentStudent.next.isDeansList = true;
		} else {
			currentStudent.next.isPresidentsList = false;
			currentStudent.next.isDeansList = false;
		}
		
		System.out.println("Student Successfully Created:");
		System.out.println();
		currentStudent.next.displayStudent(); 
		System.out.println();

		
		currentStudent = firstStudent;
		
		while (flag == false ) {
			if (currentStudent == null) {
				flag = true;
			} else {
				numberOfStudents++;
				currentStudent = currentStudent.next;
			}
		} 
		
		for (int i = 0; i < numberOfStudents; i++) {
			currentStudent = firstStudent;
			for (int j = i + 1; j < numberOfStudents; j++){
				if (currentStudent.lastName.compareTo(currentStudent.next.lastName) > 0){
					
					tempFirstName = currentStudent.next.firstName;
					tempLastName = currentStudent.next.lastName;
					tempGPA = currentStudent.next.GPA;
					tempIsDeansList = currentStudent.next.isDeansList;
					tempIsPresidentsList = currentStudent.next.isPresidentsList;
					
					currentStudent.next.firstName = currentStudent.firstName;
					currentStudent.next.lastName = currentStudent.lastName;
					currentStudent.next.GPA = currentStudent.GPA;
					currentStudent.next.isDeansList = currentStudent.isDeansList;
					currentStudent.next.isPresidentsList = currentStudent.isPresidentsList;
					
					currentStudent.firstName = tempFirstName;
					currentStudent.lastName = tempLastName;
					currentStudent.GPA = tempGPA;
					currentStudent.isDeansList = tempIsDeansList;
					currentStudent.isPresidentsList = tempIsPresidentsList;
				}
				currentStudent = currentStudent.next;
			}
		}
	}

	/**
	 * Method displayStudentList.
	 * This method displays the contents of a StudentList.
	 * This method is a void method, so it does not return a value. It also does not accept any arguments to be used in the method.
	 */
	public void displayStudentList() { // Creating void method displayStudentList to print the contents of a StudentList.
		
		if (isEmpty() == true) {
			System.out.println("The StudentList is empty.");
			return;
		}

		System.out.println("StudentList Contents: (");
		currentStudent = firstStudent;
		while (currentStudent != null) {
			currentStudent.displayStudent();
			System.out.println(",");
			currentStudent = currentStudent.next;
		}
		System.out.println(")");
		System.out.println();
	}

}
