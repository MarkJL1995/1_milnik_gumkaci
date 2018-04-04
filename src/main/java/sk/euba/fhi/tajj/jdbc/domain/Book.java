package sk.euba.fhi.tajj.jdbc.domain;

/**
 * Created by Igor Banduric.
 */
public class Book {

	private String name;
	private Integer year;

	public Book(String name, Integer year) {
		this.name = name;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public Integer getYear() {
		return year;
	}
}
