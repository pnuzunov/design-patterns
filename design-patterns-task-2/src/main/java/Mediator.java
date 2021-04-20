
public interface Mediator {
	
	public void addUser(User user);
	public void processMessage(String message, User sender);
	public void addChatBot(String forbiddenWord);
}
