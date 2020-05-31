package collection_examples;

public class City 
{
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public City(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "City [city=" + city + "]";
	}
	

}
