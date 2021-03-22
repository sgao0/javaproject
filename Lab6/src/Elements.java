
public class Elements {
	private String name;
	private String symbol;
	private int num;
	private double weight;
	
	public Elements(String name, String symbol, int num, double weight) {
		this.name = name;
		this.symbol = symbol;
		this.num = num;
		this.weight = weight;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public String getSymbol() {
		return this.symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getWeight() {
		return this.weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return "Name: " + name + "(" + symbol +") - Atomic No " + num + " - Atomic Weight " + weight;
	}
}
