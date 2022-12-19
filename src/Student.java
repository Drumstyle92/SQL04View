/**
 * @author Drumstyle92
 * Class that contains variables referring to students.
 */
public class Student {
    /**
     * Student name variable.
     */
    private String name;
    /**
     * Student last name variabile.
     */
    private String surname;

    /**
     * @param name Parameter where you will enter the names of the students in the database.
     * @param surname Parameter where you will enter the last names of the students in the database.
     * Class builder.
     */
    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * @return Returns the student's name.
     * Encapsulation method.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Parameter to be able to change the student's name.
     * Encapsulation method.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the student's last name.
     * Encapsulation method.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname Parameter to be able to change the student's last name.
     * Encapsulation method.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

}
