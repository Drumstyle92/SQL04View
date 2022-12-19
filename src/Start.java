import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Drumstyle92
 * Class that contains the heart of the program.
 */
public class Start {
    /**
     * @param args main parameter.
     * Main method which contains a database connection,
     * viewing, querying, arraylists and printing the obtained results.
     */
    public static void main(String[] args) {
        // Connection initialization
        Connection conn = null;

        try{
            // Database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb",
                                              "root","Confusione1992");

            Statement statement = conn.createStatement();

            // Creation of the italian_students view
            /*
            String viewItalianStudents = "CREATE VIEW italian_students " +
            "AS SELECT first_name, last_name FROM newdb.students WHERE country = 'Italy';";
            statement.execute(viewItalianStudents);
            */
            // Query N°1
            String queryItalianStudents = "SELECT * FROM italian_students;";
            ResultSet resultItalianStudents = statement.executeQuery(queryItalianStudents);

            // Creation and updating of the ItalianStudents list
            List<Student> listItalianStudents = new ArrayList<>();
            while(resultItalianStudents.next()){
                Student italianStudents = new Student(resultItalianStudents.getString("first_name"),
                                                      resultItalianStudents.getString("last_name"));
                listItalianStudents.add(italianStudents);
            }

            System.out.println("----------The Italian students----------");
            for(Student student:listItalianStudents){
                System.out.println(student.getName() + " " + student.getSurname());
            }

            // Creation of germany_students view
            /*String viewGermanyStudents = "CREATE VIEW germany_students NOT ALREADY EXISTS" +
            " AS SELECT first_name, last_name FROM newdb.students WHERE country = 'Germany';";
            statement.execute(viewGermanyStudents);*/

            // Query N°2
            String queryGermanyStudents = "SELECT * FROM germany_students;";
            ResultSet resultGermanyStudents = statement.executeQuery(queryGermanyStudents);

            // Creation and updating of the listGermanyStudents
            List<Student> listGermanyStudents = new ArrayList<>();
            while(resultGermanyStudents.next()){
                Student germanyStudents = new Student(resultGermanyStudents.getString("first_name"),
                                                      resultGermanyStudents.getString("last_name"));
                listGermanyStudents.add(germanyStudents);
            }

            System.out.println("----------The Germany students----------");
            for(Student student:listGermanyStudents){
                System.out.println(student.getName() + " " + student.getSurname());
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
