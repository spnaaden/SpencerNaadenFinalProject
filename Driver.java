
public class Driver { //Referencing class Driver.

	public static void main(String[] args) { //Constructing main method.
		
		StudentList testList = new StudentList(); //Creating new StudentList object called testList.
		
		System.out.println(testList.toString()); //Calling the toString method for testList to check if the StudentList exists in memory.
		
		System.out.println(testList.isEmpty()); //Calling the isEmpty method for testList to check if the StudentList is empty.
		
		testList.insertFirstStudent("Spencer", "Naaden", 3.50); //Calling the insertFirstStudent method for testList to insert the first student into the StudentList.
		
		System.out.println(testList.isEmpty()); //Calling the isEmpty method for testList.
		
		testList.insertStudent("Naaden", "Cameron", "Miller", 4.00); //Calling the insertStudent method for testList to insert a new student after a specified already created student.
		
		testList.insertStudent("Miller", "Cole", "Larson", 3.00); //Calling the insertStudent method for testList.
		
		testList.displayStudentList(); //Calling the displayStudentList method for testList to display the contends of testList.
		
		testList.searchStudent("Miller"); //Calling the searchStudent method for testList to search for specific student in the testList.
		
		testList.searchDeansStudents(); //Calling the searchDeansStudents method for testList to search for all students that have a GPA equal to or higher than 3.50.
		
	    testList.searchPresidentsStudents(); //Calling the searchDeansStudents method for testList to search for all students that have a GPA equal to 4.00.
		
		testList.modifyStudent("Miller", "Michael", "Karnes", 3.50); //Calling the modifyStudent method for testList to modify a specified student's values.
		
		testList.modifyStudent("Larson", "Carson", "Duryee", 4.00); //Calling the modifyStudent method for testList.
		
		testList.displayStudentList(); //Calling the displayStudentList for testList.
		
		testList.deleteStudent("Karnes"); //Calling the deleteStudent for testList to delete a student from the testList.
		
		testList.displayStudentList();  //Calling the displayStudentList method for testList.
	}
}
