package Server.Model;

import java.util.ArrayList;

public class School {
   private String Name;
   private String Adress;
   private ArrayList<Curriculum> curriculum;
   private ArrayList<Course> courses;
   private ArrayList<Teacher> teachers;
   private ArrayList<Student>students;

   public School(String name, String adress) {
      Name = name;
      Adress = adress;
      this.curriculum = new ArrayList<Curriculum>();
      this.courses =new ArrayList<Course>();
      this.teachers =new ArrayList<Teacher>();
      this.students = new ArrayList<Student>();
   }

    public void addTeacher(String firstName,String lastName,String email,String password,int birthyear,int salary,String knownSubject){
        for (int i = 0; i < this.teachers.size(); i++) {
            if (this.teachers.get(i).getEmail().equals(email)) {
                return;
            }
        }
        Teacher newTeacher = new Teacher(firstName,lastName,email,password,birthyear,salary,knownSubject);
        this.teachers.add(newTeacher);


    }

    public void addTeacher(String firstName,String lastName,String email,String password,int birthyear,int salary,ArrayList<String> knownSubject){
        for (int i = 0; i < this.teachers.size(); i++) {
            if (this.teachers.get(i).getEmail().equals(email)) {
                return;
            }
        }
        Teacher newTeacher = new Teacher(firstName,lastName,email,password,birthyear,salary,knownSubject);
        this.teachers.add(newTeacher);


    }


    public void addStudent(String firstName,String lastName,String email,String password,int birthyear, ArrayList<Course> currentCourses,ArrayList<Course> completedCourses,ArrayList<Course> failedCourses){
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getEmail().equals(email)) {
                return;
            }
        }
        Student newStudent = new Student(firstName, lastName, email, password, birthyear, currentCourses, completedCourses, failedCourses);
        this.students.add(newStudent);


    }


   public void addStudent(String firstName,String lastName,String email,String password,int birthyear){
       for (int i = 0; i < this.students.size(); i++) {
           if (this.students.get(i).getEmail().equals(email)) {
               return;
           }
       }
       Student newStudent= new Student(firstName,lastName,email,password,birthyear);
       this.students.add(newStudent);

   }


    public void addCource(String name,String subject,int points,int numberOfStudents){
        for (int i = 0; i < this.courses.size(); i++) {
            if (this.courses.get(i).getName().equals(name)) {
                return;
            }
        }
        Course newCourse= new Course(name,subject,points,numberOfStudents);
        this.courses.add(newCourse);


    }



    public void addCurriclum(Course course){
       for (int i = 0; i <this.curriculum.size(); i++) {
           if(this.curriculum.get(i).getCourse().getName().equals(course.getName())){
               return;
           }
       }
       Curriculum newCurriculum= new Curriculum(course);
       this.curriculum.add(newCurriculum);
   }

    public void addCurriclum(Course course,Teacher teacher) {
        for (int i = 0; i < this.curriculum.size(); i++) {
            if (this.curriculum.get(i).getCourse().getName().equals(course.getName())) {
                return;
            }
        }
        Curriculum newCurriculum= new Curriculum(course,teacher);
        this.curriculum.add(newCurriculum);
    }
    public void addCurriclum(Course course,Teacher teacher,ArrayList<Student> students) {
        for (int i = 0; i < this.curriculum.size(); i++) {
            if (this.curriculum.get(i).getCourse().getName().equals(course.getName())) {
                return;
            }
        }
        Curriculum newCurriculum= new Curriculum(course,teacher,students);
        this.curriculum.add(newCurriculum);
    }

    public String getName() {
        return Name;
    }

    public String getAdress() {
        return Adress;
    }

    public ArrayList<Curriculum> getCurriculum() {
        return curriculum;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    //EJ KLAR
   public static void saveUsers(Student studets){
      try {
         FileOutputStream fileOut =
                 new FileOutputStream("students.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(ArrayList<Student>);
         out.close();
         fileOut.close();
      } catch (IOException i) {

      }
   }

}

