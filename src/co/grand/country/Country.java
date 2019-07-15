package co.grand.country;

public class Country {
	private String name;
	private int population;;

	public Country() {}

	

	public Country(String name, int population) {
		
		this.name = name;
		this.population = population;
	}

	public int getPopulation() {
		
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public String toString() {
		return "Player [name=" + name + ", Population =" + population + "]";
	}

	

	

}
