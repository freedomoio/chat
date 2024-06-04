import java.net.*;
import java.util.*;
public class Chat{
    private Chat(){}
	private static Map<Integer, Room> roomMap = new TreeMap<>();
	private static Map<Integer, Person> perMap = new TreeMap<>();
	private static int port = -1;
	// when some one invoke the method close()
	// then the boolean will be true
	// subsequently the program will be closed
	private static boolean close = false;
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("setting");
		port = bundle.getInt("port");
		if(port <= 0) throw new IllegalStateException("property 'port' in setting.properties file must be more than 0");
	}
    public static void main(String[] args){
		ServerSocket ss = null;
		try{
			ss = new ServerSocket(port).setTimeOut(60);
		    while(!close){
				Socket socket = ss.accept();
				Person p = new Person(socket);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void removePer(int id){
		var per = perMap.get(id);
		try{
		    per.socket.close();
		}catch(IOException e){
		    e.printStackTrace();
		}
		perMap.remove(id);
	}
}
