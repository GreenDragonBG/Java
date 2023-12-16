package Banking;

public class AmountOutOfBouds extends Exception {
	
	public AmountOutOfBouds(String errorMessage) {
        super(errorMessage);
    }
}
