
public class ChatUser extends User {

	public ChatUser(String name, Mediator chat) {
		super(name, chat);
	}

	@Override
	public void sendMessage(String message) {
		if(this.chat != null)
			this.chat.processMessage(message, this);
	}
	
	@Override
	public void removeFromChat() {
		this.chat = null;
	}
}
