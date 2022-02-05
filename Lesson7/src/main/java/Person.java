public class Person {

    public static final String MALE = "male";
    public static final String FEMALE = "woman";

    private String name;
    private int age;
    private String sex;
    private Address address;

    public Person(String name, int age, String sex, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.sex = sex;
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

    public void setAge(int age) {
        if (age >= 18 && age < 27) {
            this.age = age;
        } else
            System.out.println("Возраст не подходит для службы!");
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", sex='" + address + '\'' +
                '}';
    }
}
