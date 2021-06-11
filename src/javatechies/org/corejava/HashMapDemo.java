package javatechies.org.corejava;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
	
	
	
	//put
	//get
	//Null as the Key
	//Values with same Key
	//Remove a value
	//Check If a Key or Value Exists in the Map
	//putIfAbsent()
	//compute

	public static void main(String[] args) {
		
		Map<Employee, Integer> testMap = new HashMap();
		Employee java = new Employee("Java", 1, 10000.00);
		Employee techies = new Employee("Techies", 2, 20000.00);
		testMap.put(new Employee("Java", 1, 10000.00), 1);
		testMap.put(new Employee("Techies", 2, 20000.00), 2);
		testMap.put(new Employee("Techies", 2, 20000.00), 3);
		testMap.put(new Employee("Techies", 2, 20000.00), 4);
		testMap.put(null, 5);
		testMap.put(null, 6);
	//	testMap.putIfAbsent(techies, 7);
		testMap.remove(null);

	
		System.out.println("Contains key: techies: " +testMap.containsKey(techies));
		System.out.println("Contains Value: 4: " + testMap.containsValue(4));
		
		testMap.compute(techies, (k, v) -> {
			
			if(v!= null) {
				return v.intValue() + 5;
			}
			else
			return 1;
		});
		
		for (Map.Entry entry : testMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());

		}


	}

}

class Employee {

	String name;
	int Id;
	double salary;

	/**
	 * @param name
	 * @param id
	 * @param salary
	 */
	public Employee(String name, int id, double salary) {
		super();
		this.name = name;
		Id = id;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", Id=" + Id + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Id != other.Id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

}