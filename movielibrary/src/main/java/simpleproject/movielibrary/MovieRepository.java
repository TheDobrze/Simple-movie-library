package simpleproject.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Movie> getAll(){
        List<Movie> query = jdbcTemplate.query("SELECT id, name, score FROM movie", BeanPropertyRowMapper.newInstance(Movie.class));
        return query;
    }

    public Movie getById(int id){
        Movie movie = jdbcTemplate.queryForObject("SELECT id, name,score FROM movie WHERE id =?", BeanPropertyRowMapper.newInstance(Movie.class), id);
        return  movie;
    }

    public int save(List<Movie> movies) {
        movies.forEach(movie -> jdbcTemplate.
                update("INSERT INTO movie(name,score) VALUES(?,?)",
                        movie.getName(),movie.getScore()
                        ));
        return 1;
    }
    public int update(Movie movie){
        return jdbcTemplate.update("UPDATE movie SET name=?, score=? WHERE id=?",
                movie.getName(),movie.getScore(),movie.getId());
    }
}
