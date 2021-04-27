
public class ChatBot {
	
	private static ChatBot instance;
	private String forbiddenWord;
	
	private ChatBot() {
		forbiddenWord = "";
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
	 * @return <b>True</b> if the message contains a forbidden word, <b>False</b> otherwise.
	 */
	public boolean isMessageForbidden(String message) {
		String[] words = message.split(" ");
		for(String word: words) {
			if(forbiddenWord.equals(word)) {
				return true;
			}
		}
		return false;
	}
	
}
