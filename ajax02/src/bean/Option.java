package bean;

public class Option {
	private String cityName;
	private String cityValue;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityValue() {
		return cityValue;
	}
	public void setCityValue(String cityValue) {
		this.cityValue = cityValue;
	}
	public Option() {
	}
	public Option(String cityName, String cityValue) {
		this.cityName = cityName;
		this.cityValue = cityValue;
	}
	
}
