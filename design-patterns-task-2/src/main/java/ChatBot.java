
public class ChatBot {
	
	private static ChatBot instance;
	private String forbiddenWord;
	
	private ChatBot() {
		
	}
	
	public static ChatBot getInstance() {
		if(instance == null) {
			instance = new ChatBot();
		}
		return instance;
	}
	
	public String getForbiddenWord() {
		return instance.forbiddenWord;
	}
	
	public void setForbiddenWord(String word) {
		instance.forbiddenWord = word;
	}
		
	public boolean isMessageForbidden(String message) {
		String[] words = message.split(" ");
		for(String word: words) {
			if("cat".equals(word)) {
				return true;
			}
		}
		return false;
	}
	
}
