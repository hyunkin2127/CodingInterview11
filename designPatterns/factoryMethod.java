package designPatterns;

/**
 * Created by Heon on 2015-10-31.
 */
public class factoryMethod {

	abstract class Pet{

		abstract public void petSound();
	}

	class Dog extends Pet {

		@Override
		public void petSound() {
			System.out.println("bow bow ");
		}
	}

	class Cat extends Pet{

		@Override
		public void petSound() {
			System.out.println( "Meaw Meaw");
		}
	}

	class PetFactory{

		public Pet getPet(int petType){
			Pet pet = null;

			switch (petType){
				case 0 :
					pet = new Dog();
					break;
				case 1:
					pet = new Cat();
					break;
			}
			return pet;
		}

	}

}
