package classes;

public class Result {
	
	private int deads;
	private int damaged;
	
	public Result(int deads, int damaged) {
		this.deads = deads;
		this.damaged = damaged;
	}
	
	public void write() {
		System.out.print(deads + " blacks and ");
		System.out.println(damaged + " whites");
	}
	
	public boolean isWinner() {
		return deads == 4;
	}
}
