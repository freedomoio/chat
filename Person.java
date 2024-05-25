import java.net.*;
public class Person{
    private String name;
	private int id = next_id++;
	private static int next_id = 0;
	private Socket socket;
	public String getName(){
		return this.name;
	}
	public boolean equals(Object obj){
		if(obj instanceof Person){
		    Person p = (Person) obj;
			return this.id == p.id;
		}else return false;
	}
	public Person(String name, Socket socket){
		if(socket == null) return;
		this.name = name == null ? "null" : name;
	}
}
