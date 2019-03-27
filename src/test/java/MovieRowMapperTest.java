import com.bonolex.movieland.entity.Movie;
import com.bonolex.movieland.jdbc.entityrowmapper.MovieRowMapper;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieRowMapperTest {


    @Test
    public void mapRowTest() throws SQLException {

        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getLong("id")).thenReturn(1L);
        when(resultSet.getString("name_russian")).thenReturn("Тест");
        when(resultSet.getString("name_native")).thenReturn("Test");
        when(resultSet.getString("picture_path")).thenReturn("http://images/test.jpg");
        when(resultSet.getDouble("price")).thenReturn(10.99);
        when(resultSet.getDouble("rating")).thenReturn(9.99);
        when(resultSet.getString("release_year")).thenReturn("2019");

        MovieRowMapper movieRowMapper = new MovieRowMapper();
        Movie movie = movieRowMapper.mapRow(resultSet, 0);
        assertEquals(1L, (Object) movie.getId());
        assertEquals("Тест", movie.getNameRussian());
        assertEquals("Test", movie.getNameNative());
        assertEquals("http://images/test.jpg", movie.getPicturePath());
        assertEquals(9.99, (Object) movie.getRating());
        assertEquals(10.99, (Object) movie.getPrice());
        assertEquals("2019", movie.getYearOfRelease());

    }

}
