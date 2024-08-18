package model.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
	
	
	private Double note;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	//nome da tabela que fará a junção das classes
	@JoinTable(
			name = "actors_movies", 
			joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id")
	)
	private List<Actor> actors;
	
	
	
	public Movie() {
	}

	public Movie(String name, Double note) {
		super();
		this.name = name;
		this.note = note;
	}

	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getNote() {
		return note;
	}


	public void setNote(Double note) {
		this.note = note;
	}


	public List<Actor> getActors() {
		if(actors == null) {
			actors = new ArrayList<>();
		}		
		return actors;
	}


	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	
	public void addActor(Actor actor) {
		if(actor != null && !getActors().contains(actor)) {
			getActors().add(actor);
			
			if(!actor.getMovies().contains(this)) {
				actor.getMovies().add(this);
			}
		}
	}

}
