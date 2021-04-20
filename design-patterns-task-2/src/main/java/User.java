
public abstract class User {
	
	protected String name;
	protected Mediator chat;
	
	public User(String name, Mediator chat) {
		this.name = name;
		this.chat = chat;
	}
		
	public abstract void sendMessage(String message);

	public abstract void removeFromChat();
	
	public String getName() {
		return name;
	}
}
