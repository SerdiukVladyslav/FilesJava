package files.classes.task5;

class Employee {
    private String lastName;
    private int age;

    public Employee(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Фамилия: " + lastName + ", Возраст: " + age;
    }
}
