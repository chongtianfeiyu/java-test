package serializable;

import java.io.IOException;
import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String email;

	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}

	public User() {
		super();
	}

private void writeObject(java.io.ObjectOutputStream out) throws IOException {
	System.out.println("write object start");
	out.defaultWriteObject();
	out.writeUTF(getName());
}

private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
    System.out.println("read object start");
    in.defaultReadObject();
    this.name = in.readUTF();
}
}
