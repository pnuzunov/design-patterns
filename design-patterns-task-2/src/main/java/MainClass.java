
public class MainClass {

	public static void main(String[] args) {
		ChatMediator chat = new ChatMediator();
		
		User user1 = new ChatUser("David", chat);
		User user2 = new ChatUser("Simon", chat);
		User user3 = new ChatUser("Michael", chat);

		chat.addUser(user1);
		chat.addUser(user2);
		chat.addUser(user3);
		
		// David adds the bot
		user1.sendMessage("addBot");
		
		// Simon tries to add another bot unsuccessfully 
		user2.sendMessage("addBot");
		
		// Simon sends a message, will appear to him and everyone else
		user2.sendMessage("hi everyone");
		
		// Michael sends message with a forbidden word, system message will appear instead
		user3.sendMessage("hi wanna see my cat");
		
		// message will not appear, Michael is kicked from the chat
		user3.sendMessage("oh no sorry");
	}

}
