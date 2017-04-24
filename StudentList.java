
public class StudentList { // Referencing class StudentList.

	// Creating private Student variables for StudentList operations.
	private Student firstStudent;
	private Student currentStudent;
	private Student previousStudent;
	int SIZE = 100;

	public StudentList() { // Creating constructor for StudentList.
		firstStudent = null;
	}

	public boolean isEmpty() { // Creating boolean method isEmpty to check if a StudentList is Empty.
		System.out.println();
		return (firstStudent == null);	
	}

	public void searchStudent(String studentLastName) { // Creating void method searchStudent to search for a specific student in a StudentList (using a lastname from a student) returning the Student's position in memory if they exist.
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

	public void modifyStudent(String oldStudentLastName, String newFirstName, String newLastName, double newGPA) { // Creating void method modifyStudent to search for a specific student (using a lastname from a student) and to modify that student's values with passed in values if they exist.

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

	public void deleteStudent(String studentLastName) { // Creating void method deleteStudent to search for a specific Student in a StudentList (using a lastname from a student), and then delete the Student from the StudentList if they exist.
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

	public void insertStudent(String studentToPlaceNewStudentAfter, String studentFirstName, String studentLastName, double studentGPA) { // Creating void method insertStudent to search a StudentList for a specific student(using a specific lastname), and then inserting a new Student right after that one with another lastname value that was passed in.
		
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
