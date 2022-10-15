import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age, String address){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge(){return age != null;}
    public boolean hasAddress(){return address != null;}

    public String getName(){return name;}
    public String getSurname(){return surname;}
    public int getAge(){return age;}
    public String getAddress(){return hasAddress() ? address : "Адрес неизвестен";}

    public PersonBuilder newChildBuilder(){
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }


    public void setAddress(String address){this.address = address;}
    public void happyBirthday(){
        if (hasAge()){
            age++;
        } else System.out.println("Возраст неизвестен");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name) && surname.equals(person.surname) && age.equals(person.age) && address.equals(person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
