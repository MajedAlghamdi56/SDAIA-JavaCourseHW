package Day3HW;


public class Person extends PersonRecord{
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        setName(name);
        setAge(age);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    //part1.3
    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150.");
        }
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Address: " + address;
    }
//part 2.1
    @Override
    public String getDetails() {
        return "Name: " + getName() + ", Age: " + getAge() + ", Address: " + getAddress();

    }


}

