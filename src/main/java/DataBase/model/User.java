package DataBase.model;

public class User {

	private int id,salary;
	private String name,password;
	
	
    public User() {
    }
    
    public User(String name, int salary, String password) {
		super();
		this.salary = salary;
		this.name = name;
		this.password = password;
	}
    
	public User(int id, String name, int salary, String password) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
