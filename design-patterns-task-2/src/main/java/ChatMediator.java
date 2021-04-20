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

	/**
	 * Processes the message from the sender. 
	 * @param message : The message from the sender.
	 * @param sender : The sender of the message.
	 */
	public void processMessage(String message, User sender) {
		
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

	/**
	 * Sends a message to all chat users except the sender.
	 * @param systemMessage : A flag indicating if the message is a system message or is sent by a chat user.
	 * @param message : The message the chat users will receive.
	 * @param sender : The sender of the message (or the invoker of the system message).
	 */
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
	
	/**
	 * Sends a message to the sender of the last message.
	 * @param systemMessage : A flag indicating if the message is a system message or is sent by a chat user.
	 * @param message : The message the chat users will receive.
	 * @param sender : The sender of the message (or the invoker of the system message).
	 */
	private void sendMessageToSender(boolean systemMessage, String message, User sender) {
		if(!systemMessage)
			System.out.println(sender.getName() + ": " + message);
		else
			System.out.println(sender.getName() + " (system message): " + message);
		System.out.println();
	}
	
	/**
	 * Removes the user from the chat.
	 * @param user : The user to be removed.
	 */
	private void removeUser(User user) {
		this.users.remove(user);
		user.removeFromChat();
	}

	/**
	 * Adds a chatbot to the chat.
	 * @param forbiddenWord : Sets a forbidden word for the chat.
	 */
	public void addChatBot(String forbiddenWord) {
		chatBot = ChatBot.getInstance();
		chatBot.setForbiddenWord(forbiddenWord);
	}

	/**
	 * Asks the chatbot whether the message sent has any forbidden words.
	 * @param message : The message that was sent.
	 * @return <b>True</b> if the message contains a forbidden word, <b>false</b> otherwise.
	 */
	private boolean isMessageForbidden(String message) {
		if(chatBot == null)
			return false;
		return chatBot.isMessageForbidden(message);
	}
	
}
