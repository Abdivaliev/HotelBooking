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
    private ConnectionSource connection = ConnectionSource.instance();
    private static final RoomDAO roomDAO = new RoomDAO();

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM Room";
        try (Statement statement = connection.createConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getInt("id"));
                room.setBalcony(resultSet.getBoolean("balcony"));
                room.setExtra(resultSet.getString("extra"));
                room.setBooked(resultSet.getBoolean("isBooked"));
                room.setNumberOfBeds(resultSet.getInt("numberOfBeds"));
                room.setStatus(resultSet.getString("status"));
                room.setSquare(resultSet.getBigDecimal("square"));
                room.setNumberOfRooms(resultSet.getInt("numberOfRooms"));
                room.setRoomNumber(resultSet.getInt("room_number"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

//    public String save(){
//
//    }

    public static RoomDAO getInstance(){
        return roomDAO;
    }
}
