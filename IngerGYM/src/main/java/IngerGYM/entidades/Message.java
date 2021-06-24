package IngerGYM.entidades;



	public class Message {

	    private String email;
	    private String messageText;
	    private String asunto;

	    public Message(String email, String asunto,String message) {
	        this.email = email;
	        this.messageText = message;
	        this.asunto=asunto;
	    }
	    
	    public String getAsunto() {
			return asunto;
		}

		public void setAsunto(String asunto) {
			this.asunto = asunto;
		}

		
		public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getMessageText() {
	        return messageText;
	    }

	    public void setMessageText(String message) {
	        this.messageText = message;
	    }

	}