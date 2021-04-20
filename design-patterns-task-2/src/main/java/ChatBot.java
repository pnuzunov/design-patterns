
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
	
	/**
	 * Checks if a message contains a forbidden word.
	 * @param message : The message.
	 * @return <b>True</b> if the message contains a forbidden word, <b>false</b> otherwise.
	 */
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
