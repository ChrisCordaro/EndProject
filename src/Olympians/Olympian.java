package Olympians;
import Main.Sex;



/**
 * The Olympian class represents a single olympian in the games
 */
public class Olympian {
    private String name;
    private Sex sex;
    private int age;

    /**
     * Construct a new olympian
     *
     * @param name the name of the olympian
     * @param sex the sex of the olympian
     * @param age the age of the olympian
     */
    public Olympian(String name, Sex sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    /**
     * Retrieve the name of the olympian
     *
     * @return the name of the olympian
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the olympian
     *
     * @param name the name of the olympian
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieve the sex of the olympian
     *
     * @return the sex of the olympian
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Set the sex of the olympian
     *
     * @param sex the sex of the olympian
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * Retrieve the age of the olympian
     *
     * @return the age of the olympian
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the age of the olympian
     *
     * @param age the age of the olympian
     */
    public void setAge(int age) {
        this.age = age;
    }
}
