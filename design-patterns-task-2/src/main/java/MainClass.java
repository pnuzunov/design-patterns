
public class MainClass {

	public static void main(String[] args) {
		ChatMediator chat = new ChatMediator();
		
		User user1 = new ChatUser("David", chat);
		User user2 = new ChatUser("Simon", chat);
		User user3 = new ChatUser("Michael", chat);

		chat.addUser(user1);
		chat.addUser(user2);
		chat.addUser(user3);
		
		user1.sendMessage("addBot");
		user2.sendMessage("addBot");
		user2.sendMessage("hi everyone");
		user3.sendMessage("hi wanna see my cat");
	}

}
