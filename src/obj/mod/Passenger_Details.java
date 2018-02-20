package obj.mod;

public class Passenger_Details { // Class

	private String name; // Instance variable
	private int age;
	private String contact;
	private String gender;

	public String getName() { // Encapsulation using getters and setters
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void display() {
		System.out.println("Passenger name is " + name);
		System.out.println("Passenger contact is " + contact);
		System.out.println("Passenger age is " + age);
		System.out.println("Passenger gender is " + gender);
	}

}