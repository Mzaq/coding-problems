/*
3.6 - Animal Shelter

	An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
	out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
	or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
	that type). They cannot select which specific animal they would like. Create the data structures to
	maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
	and dequeueCat. You may use the built-in Linked List data structure.
*/

class AnimalShelter {
    List<Dog> dogs;
    List<Cat> cats;
    int size;

    public AnimalShelter(){
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        int size = 0;
    }

    public void enqueue(Animal animal){
        if (animal instanceof Dog) {
            dogs.add(0, (Dog) animal);
        } else {
            cats.add(0, (Cat) animal);
        }
        size++;
    }

    public Animal dequeueAny() {
        if (size == 0) return null;
        size--;
        if (cats.size() == 0) return dogs.remove(dogs.size() - 1);
        if (dogs.size() == 0) return cats.remove(cats.size() - 1);
        return dogs.get(dogs.size() - 1).getDate() < cats.get(cats.size() - 1).getDate()
                ? dogs.remove(dogs.size() - 1)
                : cats.remove(cats.size() - 1);
    }

    public Dog dequeueDog() {
        size--;
        return dogs.isEmpty() ? dogs.remove(dogs.size() - 1) : null;
    }

    public Cat dequeueCat() {
        size--;
        return cats.isEmpty() ? cats.remove(cats.size() - 1) : null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Dog dog : dogs) {
            sb.append(dog.getName()).append(",");
        }
        sb.append("\n");
        for (Cat cat : cats) {
            sb.append(cat.getName()).append(",");
        }
        return sb.toString();
    }
}

class Animal {
    private String name;
    private int date;

    Animal(String name, int date) {
        this.name = name;
        this.date = date;
    }

    public Animal() {
        name = "";
        date = 0;
    }

    public String getName() {
        return name;
    }

    public int getDate() {
        return date;
    }
}

class Dog extends Animal {
    String name;
    int date;

    public Dog(String name, int date) {
        super(name, date);
    }
}

class Cat extends Animal {
    String name;
    int date;

    public Cat(String name, int date) {
        super(name, date);
    }
}