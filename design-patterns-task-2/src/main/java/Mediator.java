
public interface Mediator {
	
	public void addUser(User user);
	public void sendMessage(String message, User sender);
	public void addChatBot(String forbiddenWord);
}
