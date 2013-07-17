public class Inheritance {
	public static void main (String[] args) {
		System.out.println("Hello!\n");

		Animal _animal = new Animal();
		Canine _canine = new Canine();
		Wolf     _wolf = new Wolf();
		Dog       _dog = new Dog();

		_animal.make_sound();
		_canine.make_sound();
		_wolf.make_sound();
		_dog.make_sound();

		System.out.println("\nDone.");

	}
}

class Animal {
	boolean has_fur;
	boolean has_tail;
	int claws;
	boolean hungry;
	boolean tamed;

	public void make_sound () {
		System.out.println("Noise");
	}

	public void eat () {
		hungry = false;
	}

	public void run () {
		hungry = true;
	}
}

class Canine extends Animal {
	Canine () {
		has_fur = true;
		has_tail = true;
	}

}

class Dog extends Canine {
	Dog () {
		claws = 4;
		tamed = true;
	}
	public void make_sound () {
		System.out.println("Wulf");
	}
}

class Wolf extends Canine {
	Wolf () {
		claws = 5;
		tamed = false;
	}
	public void make_sound () {
		System.out.println("Howl");
	}
}

