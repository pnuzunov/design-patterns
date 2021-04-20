import java.util.ArrayList;
import java.util.List;

public class ChatMediator implements Mediator {

	private List<User> users;
	private ChatBot chatBot;
	
	public ChatMediator() {
		this.users = new ArrayList<User>();
	}
	
	public void addUser(User user) {
		this.users.add(user);
		
	}

	public void sendMessage(String message, User sender) {
		
		boolean isMessageForbidden = isMessageForbidden(message);
		if(isMessageForbidden) {
			
			this.removeUser(sender);
			this.sendMessageToSender(true, "You have been removed from the chat for using a forbidden word: "
											+ chatBot.getForbiddenWord() + "\'", sender);
			
			this.sendMessageToAll(true, sender.getName() +
							" has been removed from the chat for using a forbidden word: \'" 
							+ chatBot.getForbiddenWord() + "\'", sender);
			return;
		}
		
		if("addBot".equals(message)) {
			if(this.chatBot != null) {
				this.sendMessageToSender(true, "Chatbot is already active.", sender);
				return;
			}
			this.addChatBot("cat");
			this.sendMessageToSender(true, "You have added a chatbot.", sender);
			this.sendMessageToAll(true, "A chatbot has been added.", sender);
			return;
		}
		
		this.sendMessageToSender(false, message, sender);
		this.sendMessageToAll(false, message, sender);
		
	}

	private void sendMessageToAll(boolean systemMessage, String message, User sender) {
		for(User user: users) {
			
			if(user != sender) {
				if(!systemMessage)
					System.out.println(user.getName() + ": " + sender.getName() + " said \'" + message + "\'");
				else
					System.out.println(user.getName() + " (system message): " + message);
			}
		}
		System.out.println();
	}
	
	private void sendMessageToSender(boolean systemMessage, String message, User sender) {
		if(!systemMessage)
			System.out.println(sender.getName() + ": " + message);
		else
			System.out.println(sender.getName() + " (system message): " + message);
		System.out.println();
	}
	
	private void removeUser(User sender) {
		this.users.remove(sender);
	}

	public void addChatBot(String forbiddenWord) {
		chatBot = ChatBot.getInstance();
		chatBot.setForbiddenWord(forbiddenWord);
	}

	private boolean isMessageForbidden(String message) {
		if(chatBot == null)
			return false;
		return chatBot.isMessageForbidden(message);
	}
	
}
