package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Copies;

@Component
public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String USER = "student";
	private static final String PWD = "student";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Film findFilmById(int fId) {
		Film film = null;

		try {
			String sql = "SELECT * FROM film WHERE id = ?";
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, fId);
			
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Integer filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
			
				int langId = rs.getInt("language_id");
				
				String langIdTrans = language(langId);

				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				film = new Film (filmId, title, desc, releaseYear, langId, langIdTrans, rentDur,
						 rate, length, repCost, rating, features);

				
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}
	public String language(int langId) {
		  String langName = "";
		  try {
		   Connection conn = DriverManager.getConnection(URL, USER, PWD);
		   String sql = "SELECT name FROM language WHERE id = ?;";
		   PreparedStatement stmt = conn.prepareStatement(sql);
		   stmt.setInt(1, langId);
		   ResultSet rs = stmt.executeQuery();
		   while (rs.next()) {
		    langName = rs.getString("name");
		   }
		   rs.close();
		   stmt.close();
		   conn.close();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  return langName;
		 }

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;

		try {
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			// 5)iterate through results and display
			if (actorResult.next()) {
				int id = actorResult.getInt("id");
				String fn = actorResult.getString("first_name");
				String ln = actorResult.getString("last_name");

				actor = new Actor(id, fn, ln);

				actor.setFilms(findFilmsByActorId(actorId));
			}

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			String sql = "SELECT * " + " FROM actor " + " JOIN film_actor " + " ON actor.id = film_actor.actor_id "
					+ " WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int actorId = rs.getInt("id");
				String fn = rs.getString("first_name");
				String ln = rs.getString("last_name");

				Actor actor = new Actor(actorId, fn, ln);
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	@Override
	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			String sql = "SELECT * " + " FROM film " + " JOIN film_actor " + " ON film.id = film_actor.actor_id "
					+ " WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int langId = rs.getInt("language_id");
				String langIdTrans = language(langId);
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");

				Film film = new Film (filmId, title, desc, releaseYear, langId, langIdTrans, rentDur,
						 rate, length, repCost, rating, features);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Film> findFilmsByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			String sql = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?;"; // 2

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int langId = rs.getInt("language_id");
				
				String langIdTrans = language(langId);
				
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");

				Film film = new Film(filmId, title, desc, releaseYear, langId, langIdTrans, rentDur, rate, length, repCost, rating,
						features);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("in DAO "+ films);
		return films;
	}

	@Override
	public List<Copies> findCopiesById(int filmId) {
		List<Copies> copies = new ArrayList<>();

		try {
			String sql = " SELECT inventory_item.id, media_condition " + " FROM inventory_item " + " JOIN film "
					+ " ON inventory_item.film_id = film.id " + " WHERE film_id = ?";

			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, filmId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String cond = rs.getString("media_condition");
				int copyId = rs.getInt("id");

				Copies copy = new Copies(cond, copyId);
				copy.setCondition(cond);

				copies.add(copy);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return copies;
	}

	@Override
	public Actor createActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);

			conn.setAutoCommit(false); // START TRANSACTION
			// sql query
			String sql = "INSERT INTO actor (first_name, last_name) " + " VALUES (?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, actor.getFirstName());
			stmt.setString(2, actor.getLastName());

			int updateCount = stmt.executeUpdate();

			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();

				if (keys.next()) {
					int newActorId = keys.getInt(1);

					actor.setId(newActorId);

					if (actor.getFilms() != null && actor.getFilms().size() > 0) {
						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
						stmt = conn.prepareStatement(sql);
						for (Film film : actor.getFilms()) {

							stmt.setInt(1, film.getId());
							stmt.setInt(2, newActorId);
							updateCount = stmt.executeUpdate();
						}
					}
				}
			} else {
				actor = null;
			}
			conn.commit(); // COMMIT TRANSACTION
			if(!conn.isClosed()){
				conn.close();
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting actor " + actor);
		}
		return actor;
	}

	@Override
	public boolean saveActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			conn.setAutoCommit(false); // START TRANSACTION
						
			String sql = "UPDATE actor SET first_name=?, last_name=? " + " WHERE id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, actor.getFirstName());
			stmt.setString(2, actor.getLastName());
			stmt.setInt(3, actor.getId());
			
			
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				// Replace actor's film list
				sql = "DELETE FROM film_actor WHERE actor_id = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, actor.getId());
				updateCount = stmt.executeUpdate();
				
				sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
				stmt = conn.prepareStatement(sql);
			
				for (Film film : actor.getFilms()) {
					stmt.setInt(1, film.getId());
					stmt.setInt(2, actor.getId());
					updateCount = stmt.executeUpdate();
				}
				
				conn.commit(); // COMMIT TRANSACTION
			
				if(!conn.isClosed()){
					conn.close();
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteActor(Actor actor) {
		  Connection conn = null;
		  try {
		    
			conn = DriverManager.getConnection(URL, USER, PWD);
		    
		    conn.setAutoCommit(false); // START TRANSACTION
		    String sql = "DELETE FROM film_actor WHERE actor_id = ?";
		    
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, actor.getId());
		    
		    int updateCount = stmt.executeUpdate();
		   
		    sql = "DELETE FROM actor WHERE id = ?";
		    
		    stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, actor.getId());
		    
		    updateCount = stmt.executeUpdate();
		    
		    conn.commit();             // COMMIT TRANSACTION
			
		    if(!conn.isClosed()){
				conn.close();
			}
		    
		  }
		  catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); }
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    return false;
		  }
		  return true;
		}

	@Override
	public boolean createFilm(Film film) {
		boolean success = false;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			
			// sql query                      1        2            3             4
			String sql = "INSERT INTO film (title, description, release_year, language_id,"
					+ " rental_duration, rental_rate, length, replacement_cost, rating, special_features)" 
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)";

			conn.setAutoCommit(false); // START TRANSACTION
			
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getYear());
			stmt.setInt(4, film.getLangId());
			stmt.setInt(5, film.getRentalDur());
			stmt.setDouble(6, film.getRateRental());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplaceCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecFeat());
			
			int updateCount = stmt.executeUpdate();
			
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				
				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					
					film.setId(newFilmId);
				}
//					
//					if (actor.getFilms() != null && actor.getFilms().size() > 0) {
////						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
////						stmt = conn.prepareStatement(sql);
////						for (Film film : actor.getFilms()) {
//							
//							stmt.setInt(1, film.getFilmId());
//							stmt.setInt(2, newActorId);
//							updateCount = stmt.executeUpdate();
//						}
				
			} else {
				film = null;
			}
			
			conn.commit(); // COMMIT TRANSACTION
			
			if(!conn.isClosed()){
				conn.close();
			}
			
			success = true;
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			//throw new RuntimeException("Error inserting film " + film.getTitle());
			return success;
		}
		return success;
}

	@Override
	public boolean updateFilm(int filmId, Film updated) {
		  Connection conn = null;
		  System.out.println(updated+"$$$$$$$$$$$$$$$$$$$$$");
		    try {
		        conn = DriverManager.getConnection(URL, USER, PWD);
		        conn.setAutoCommit(false); // START TRANSACTION
		        String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?,"
						+ " rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?, rating = ?, special_features = ?" 
						+ " WHERE id = ?";
		
		        
		        
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, updated.getTitle());
				stmt.setString(2, updated.getDescription());
				stmt.setInt(3, updated.getYear());
				stmt.setInt(4, updated.getLangId());
				stmt.setInt(5, updated.getRentalDur());
				stmt.setDouble(6, updated.getRateRental());
				stmt.setInt(7, updated.getLength());
				stmt.setDouble(8, updated.getReplaceCost());
				stmt.setString(9, updated.getRating());
				stmt.setString(10, updated.getSpecFeat());
				stmt.setInt(11, updated.getId());
		        
				System.out.println(filmId);
				
		        int updateCount = stmt.executeUpdate();
		        
		        conn.commit(); // COMMIT TRANSACTION
		        if(!conn.isClosed()){
		            conn.close();
		        }
		    } catch (SQLException sqle) {
		        sqle.printStackTrace();
		        if (conn != null) {
		            try { conn.rollback(); }
		            catch (SQLException sqle2) {
		                System.err.println("Error trying to rollback");
		            }
		        }
		        return false;
		    }
		    return true;
		}
		

	@Override
	public boolean deleteFilm(int filmId) {
		Connection conn = null;
		try {
			
			conn = DriverManager.getConnection(URL, USER, PWD);
			
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			
			int updateCount = stmt.executeUpdate();
			conn.commit();  // COMMIT TRANSACTION
			
			if(!conn.isClosed()){
				conn.close();
			}
			
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try { conn.rollback(); }
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

}
