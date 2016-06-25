package model.query;

public class MustSimulatedLoanQuery  implements ClientQuery {
	private String message;

	public MustSimulatedLoanQuery(String message) {
		
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public MustSimulatedLoanQuery(){
	
	}

}
