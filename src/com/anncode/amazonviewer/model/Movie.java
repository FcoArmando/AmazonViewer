package com.anncode.amazonviewer.model;

import com.anncode.amazonviewer.dao.MovieDao;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 */
public class Movie extends Film implements IVisualizable, MovieDao {

	private int id;
	private int timeViewed;

	public Movie(){
	}

	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}
	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: MOVIE ::" +
				"\n Title: " + getTitle() +
				"\n Genero: " + getGenre() +
				"\n Year: " + getYear() +
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub

		if (dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeViewed(0);
		}


	}

	public static ArrayList<Movie> makeMoviesList() {
		Movie movie = new Movie();
		//ArrayList<Movie> movies = new ArrayList();
		/*for (int i = 1; i <= 5; i++) {
			movies.add(new Movie("Movie " + i, "Genero " + i, "Creador " + i, 120+i, (short)(2017+i)));
		}*/

		return movie.read();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void view(){
		setViewed(true);
		Movie movie = new Movie();
		movie.setMovieViewed(this);
		Date dateI = startToSee(new Date());

		for (int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}

		//Termine de verla
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Viste: " + toString());
		System.out.println("Por: " + getTimeViewed() + " milisegundos");
	}
}







