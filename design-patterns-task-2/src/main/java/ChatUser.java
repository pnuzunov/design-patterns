
public class ChatUser extends User {

	public ChatUser(String name, Mediator chat) {
		super(name, chat);
	}

	@Override
	public void sendMessage(String message) {
		this.chat.sendMessage(message, this);
	}
}
