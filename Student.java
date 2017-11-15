import java.util.ArrayList;
/**
 * A class that creates a student with a name and student number 
 * @author Temi Oduyale 100456825
 *
 */
public class Student {
	 private String id; 
	 private String name;
	 private ArrayList<Course> courses; // contains all courses the student is registered in

	  public String getName() {
		  return name;
	  }

	  public String getId() {
		  return id;
	  }

	  // constructor 
	  public Student(String id, String name) { 
	     // initialize name and id. Also initialize the arraylist
		 this.name = name;
		 this.id = id;
		 courses = new ArrayList<Course>();
	  }
	  
	  //Registers a Student for a specified course 
	  public void registerFor(Course course){
		  boolean result = false;
		  boolean result2 = false;
		  
		  for(Course x : courses){
			  if(x.equals(course)){
				  result = true;
			  } 
		  }
		  if(!result){
			  courses.add(course);
			  course.classList.add(this);
			  
			  for(Student y : course.dept.registerList){
				  if(this.equals(y)){
					  result2 = true;
				  }
			  }
			  if(!result2){
				  course.dept.registerList.add(this);
			  }
		  }
	 }
	 
	  //Checks if a student is registered for a specific course
	 public Boolean isRegisteredInCourse(Course course){
		  boolean result = false;
		  for (Course x : courses){
			  if(x.equals(course)){
				  result = true;
				  break;
			  }
		  }
		  return result;
	  }
	  

	  public String toString() {
	     // return a string representation of a student using the following format:
	     // 100234546 John McDonald
	     // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850
		 ArrayList<String> coursesf = new ArrayList<String>();
		 for(Course x : courses){
			 String a = x.getCode();
			 coursesf.add(a);			 
		 }
		  return id + " " + name + "\nRegistered courses: " + coursesf;		  
	  }
}
