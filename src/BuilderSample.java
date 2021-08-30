public class BuilderSample {
    public static void main(String[] args) {
        Person person = new PersonBuilderImpl()
                .setName("Alex")
                .build();
        person.print();
    }
}

class Person{
    String name;
    Integer age;
    String eyeColor;
    void print(){
        System.out.println(String.format("name:%s, age:%d, eyeColor=%s", name, age, eyeColor));
    }
}

interface PersonBuilder{
    PersonBuilder setName(String name);
    PersonBuilder setAge(Integer age);
    PersonBuilder setEyeColor(String eyeColor);
    Person build();
}

class PersonBuilderImpl implements PersonBuilder{
    private Person person = new Person();

    @Override
    public PersonBuilder setName(String name) {
        person.name = name;
        return this;
    }

    @Override
    public PersonBuilder setAge(Integer age) {
        person.age = age;
        return this;
    }

    @Override
    public PersonBuilder setEyeColor(String eyeColor) {
        person.eyeColor = eyeColor;
        return this;
    }

    @Override
    public Person build() {
        return person;
    }
}
