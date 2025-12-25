public class Person implements Comparable<Person>{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object p1) {

        if(this.name.equals(((Person) p1).name)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Raj");
        Person p2 = new Person("Raj");

        System.out.println(p1.equals(p2));
        System.out.println(p1.compareTo(p2));
        System.out.println(p1 + " " + p2);
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
