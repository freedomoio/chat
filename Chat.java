import java.net.*;
import java.util.*;
public class Chat{
    private Chat(){}
	private static List<Room> list = new ArrayList<>();
	private static int port = -1;
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("setting");
		port = bundle.getInt("port");
		if(port <= 0) throw new IllegalStateException("property 'port' in setting.properties file must be more than 0");
	}
    public static void main(String[] args){
		ServerSocket ss = null;
		try{
			ss = new ServerSocket(port);

		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
