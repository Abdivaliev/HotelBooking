package uz.sarvar.hotelbooking.dao;

import uz.sarvar.hotelbooking.ConnectionSource;
import uz.sarvar.hotelbooking.model.Room;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    private Connection connection;

    public RoomDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM Room";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getInt("id"));
                room.setBalcony(resultSet.getBoolean("balcony"));
                room.setExtra(resultSet.getString("extra"));
                room.setBooked(resultSet.getBoolean("isBooked"));
                room.setNumberOfBeds(resultSet.getInt("numberOfBeds"));
                room.setStatus(resultSet.getString("status"));
                room.setSquare(resultSet.getDouble("square"));
                room.setNumberOfRooms(resultSet.getInt("numberOfRooms"));
                room.setNumber(resultSet.getInt("number"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
