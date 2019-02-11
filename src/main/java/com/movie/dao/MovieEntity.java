package com.movie.dao;

public class MovieEntity {
	private int mid;
	private String title;
	private String year;
	private String director;
	private String language;
	private String story;
	private String poster;

	public MovieEntity() {
	}

	public MovieEntity(String title, String year, String director, String language, String story, String poster) {
		this.title = title;
		this.year = year;
		this.director = director;
		this.language = language;
		this.story = story;
		this.poster = poster;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return "MovieEntity [mid=" + mid + ", title=" + title + ", year=" + year + ", director=" + director + ", language="
				+ language + ", story=" + story + ", poster=" + poster + "]";
	}

}
