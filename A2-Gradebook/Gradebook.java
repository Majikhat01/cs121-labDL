import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Lesson 13: Activity - Gradebook
 *
 * @author CS121 Instructors
 * @version Fall 2020
 * @author Calvin Hatfield
 */
public class Gradebook
{
	public static void main(String[] args)
	{	
		/* TODO: 1. Create a new ArrayList of Student objects called gradebook. */
		ArrayList<Student> gradebook = new ArrayList<Student>();
		
		/* TODO: 2. Create a new File object for gradebook.csv and 
		 * a new Scanner object to parse it. Catch any required 
		 * exceptions and display a useful message to the user.
		 */
		File gradebookFile = new File("gradebook.csv");
		
		try
		{
			Scanner fileScanner = new Scanner(gradebookFile);
			/* TODO: 3. Use a while loop and the Scanner created above to iterate 
			 * through the lines in the gradebook.csv file.
			 */
			while (fileScanner.hasNextLine())
			{
				String line = fileScanner.nextLine();

				/* TODO: 4. For each line (student record), use a second 
				 * Scanner object to tokenize the line using a comma (',')
				 * as the delimiter, extract values for lastName, firstName,
				 * id and grade and store them to local variables.
			 	 */
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter(",");

				String lastName = lineScanner.next();
				String firstName = lineScanner.next();
				int id = lineScanner.nextInt();
				int grade = lineScanner.nextInt();

			 	/* TODO: 5. Create a new Student object using the local variables
			 	 * create above, set the student's grade, and finally add the 
			 	 * new Student object to the gradebook ArrayList. 
				 */
				Student student = new Student(firstName, lastName, id);
				student.setGrade(grade);
				gradebook.add(student);

				lineScanner.close();
			}
			fileScanner.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Unable to open file: " + gradebookFile);
			System.out.println(e.getMessage());
			System.exit(1);
		}

		/* TODO: 6. Use a foreach loop to print out contents of the gradebook */
		for (Student student : gradebook)
		{
			System.out.println(student);
		}
	}

}