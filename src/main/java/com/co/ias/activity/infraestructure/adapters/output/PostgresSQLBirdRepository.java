package com.co.ias.activity.infraestructure.adapters.output;

import com.co.ias.activity.birds.application.domain.Bird;
import com.co.ias.activity.birds.application.domain.valueObjs.BirdId;
import com.co.ias.activity.birds.application.ports.output.BirdRepository;
import com.co.ias.activity.infraestructure.logSystem.Log;
import com.co.ias.activity.infraestructure.models.BirdDAO;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

@Repository
public class PostgresSQLBirdRepository implements BirdRepository {
    private final DataSource dataSource;

    public PostgresSQLBirdRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(Bird bird) {
        String sql = "INSERT INTO birds (common_name, scientific_name, area_name, confirmed_quantity) values (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString( 1, bird.getCommonName().getValue() );
            preparedStatement.setString( 2, bird.getScientificName().getValue() );
            preparedStatement.setString( 3, bird.getAreaName().getValue() );
            if (bird.getConfirmedQuantity() != null) {
                preparedStatement.setInt(4, bird.getConfirmedQuantity().getValue());
            } else {
                preparedStatement.setNull(4, Types.INTEGER);
            }
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error DB....: " + e.getMessage());
            throw new RuntimeException("Error querying database", e);
        }
    }

    @Override
    public Optional<Bird> get(BirdId birdId) {
        String sql = "SELECT * FROM birds WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, birdId.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                BirdDAO birdDAO = BirdDAO.fromResultSet(resultSet);
                Bird bird = birdDAO.toDomain();
                return  Optional.of(bird);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            System.out.println("Error DB....: "  + e.getMessage());
            throw new RuntimeException("Error querying database", e);
        }
    }

    @Override
    public void update(Bird bird) {
        String sql = "UPDATE birds SET common_name = ?, scientific_name = ?, area_name = ?, confirmed_quantity = ? WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString( 1, bird.getCommonName().getValue() );
            preparedStatement.setString( 2, bird.getScientificName().getValue() );
            preparedStatement.setString( 3, bird.getAreaName().getValue() );
            preparedStatement.setInt( 4, bird.getConfirmedQuantity().getValue() );
            preparedStatement.setLong( 5, bird.getId().getValue() );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log log = new Log(e.getMessage(), "Error querying database");
            log.logger();
            throw new RuntimeException("Error querying database", e);
        }
    }

    @Override
    public Boolean delete(BirdId birdId) {
        String sql = "DELETE FROM birds WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong( 1, birdId.getValue() );
            return preparedStatement.execute();
        } catch (SQLException e) {
            Log log = new Log(e.getMessage(), "Error querying database");
            log.logger();
            throw new RuntimeException("Error querying database", e);
        }
    }
}
