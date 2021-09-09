public class PrototypeSample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("str", 66);
        Person1 person = new Person1("Mike", address);
//        Person1 clone = person.clone();
        Person1 clone = new Person1(person);
        System.out.println(person != clone);
        System.out.println(person.name.equals(clone.name));
        System.out.println(person.address.street.equals(clone.address.street));
        person.name = "Den";
        System.out.println(clone.name);
        person.address.street = "new str";
        System.out.println(clone.address.street);
    }
}

class Address implements Cloneable{
    String street;
    int number;

    Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    Address(Address address) {
        street = address.street;
        number = address.number;
    }

    //JDK impl
    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}

class Person1 implements Cloneable{
    String name;
    Address address;

    Person1(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    Person1(Person1 person) {
        name = person.name;
        address =  new Address(person.address);
    }

    @Override
    protected Person1 clone() throws CloneNotSupportedException {
        Person1 clone = (Person1) super.clone();
        clone.address = this.address.clone();
        return clone;
    }
}

