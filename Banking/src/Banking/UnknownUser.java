package Banking;

public class UnknownUser extends Exception {
	
	public UnknownUser(String errorMessage) {
        super(errorMessage);
    }
}
