
public class StudentList { //Referencing class StudentList.

	//Creating private Student variables for StudentList operations.
	private Student firstStudent;
	private Student currentStudent;
	private Student previousStudent;
	IllegalArgumentException iae = new IllegalArgumentException();
	
	public StudentList() { //Creating constructor for StudentList.
		firstStudent = null;
	}
	
	public boolean isEmpty() { //Creating boolean method isEmpty to check if a StudentList is Empty.
		return (firstStudent == null);
	}
	
	public Student searchStudent(String studentLastName) { //Creating Student method searchStudent to search for a specific student in a StudentList (using a lastname from a student) returning the Student's position in memory if they exist.
		 currentStudent = firstStudent;
		while (studentLastName.compareTo(currentStudent.lastName) != 0) {
			if (currentStudent.next == null) {
				return null;
			} else {
				currentStudent = currentStudent.next;
			}

		}
		return currentStudent;
	}
	
	public Student deleteStudent(String studentLastName) { //Creating Student method deleteStudent to to search for a specific Student in a StudentList (using a lastname from a student), and then deleting the Student from the StudentList if they exist.
		if (isEmpty() == true){
			 throw iae;		
		}
		
		currentStudent = firstStudent;
		previousStudent = firstStudent;
		while (currentStudent.lastName != studentLastName) {
			if (currentStudent.next == null) {
				return null;
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
		return currentStudent;
	}
	
	/*public void insertStudent(char keyData, char newData) { //Creating void method insertLink to search the LinkList for a specific link (using specified cData), and then inserting a new link right after that one with another cData value that was passed in.
		if(isEmpty() == true) {
			throw iae;		
		}
		
		currentLink = first;
		while (currentLink != null && !(currentLink.cData == (keyData))) {
			currentLink = currentLink.next;
		}
		if (currentLink != null) {
			currentLink.next = new Link(newData, currentLink.next);
		}
	} */
	
	
	
	
}
