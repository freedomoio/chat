import java.net.*;
public class Person implements Runnable{
    private String name;
	private static int nextId = 0;
	private int id = nextId++;
	protected Socket socket;
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
	public void run(){
		if(this.socket == null) throw new IllegalStateException("this socket is null");
		try{
		    try(Scanner in = new Scanner(socket.getInputStream());
				PrintWriter out = new PrintWriter(socket.getOutputStream()){
				out.println("Welcome to Chat Room!");
				out.println("join <房间号> 以加入房间。");
				out.print("> ");
				String cmd;
				while(in.hasNext()){
				    cmd = in.next().trim();
					String[] paras = cmd.split(" ");
					if("help".equals(paras[0])) out.println(help());
					else if("quit".equals(paras[0])){
						if(paras.length == 1) Chat.removePer(id);
						if(paras.length == 3) checkAdmin(paras);
					}
					else if("join".equals(paras[0])){
						if(paras.length != 2) out.println("错误：参数只能有一个。");
						try{
						    Chat.link(Integer.parseInt(paras[1]));
						}catch(NumberFormatException e){
						    out.println("输入的参数必须是数字。");
						}
					}
					out.print("> ");
				}
		    }
		}catch(IOException e){
		    e.printStackTrace();
		}
	}
	private void quit(){}
	private StringBuilder help(){
		var b = new StringBuilder();
		b.append("help 显示本条帮助信息\n");
		b.append("quit 断开连接(或者程序)\n");
		b.append("join <房间号> 加入房间\n");
		b.append("create <房间名> 创建房间");
		b.append("show 显示房间列表\n");
		b.append("\t-n 显示当前房间信息\n");
		b.append("...");
		return b;
	}
	private void checkAdmin(String[] paras){
		if(paras.length == 3){
		    if("quit".equals(paras[0]) && "-a".equals()
		}
	}
}
