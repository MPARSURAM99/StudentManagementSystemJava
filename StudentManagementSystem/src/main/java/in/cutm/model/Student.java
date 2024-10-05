package in.cutm.model;

public class Student {
	
	private int id;
	private String fullName;
	private String dob;
	private String address;
	private String qualification;
	private String email;
	
//	Super class constructor;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

public Student(int id, String fullName, String dob, String address, String qualification, String email) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.address = address;
		this.qualification = qualification;
		this.email = email;
	}

	//	Private class constructor;
	public Student(String fullName, String dob, String address, String qualification, String email) {
		super();

		this.fullName = fullName;
		this.dob = dob;
		this.address = address;
		this.qualification = qualification;
		this.email = email;
	}

	
//	Getters and setters;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
//	Generate to string method
	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", address=" + address
				+ ", qualification=" + qualification + ", email=" + email + "]";
	}
	
	
	
}
