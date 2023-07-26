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
        String query = "SELECT * FROM room";
        try (Statement statement = connection.createConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            roomInserter(rooms, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public Room getRoomByNumber(Integer id) {

        Room room = new Room();
        String query = "SELECT * FROM room where room_number=" + id + ";";
        try (Statement statement = connection.createConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                roomParser(room, resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }


    public List<Room> getAllRoomsByParameter(String statusOfRoom, String startDate, String endDate, String numberOfBeds) throws SQLException {
        List<Room> rooms = new ArrayList<>();

        Statement statement = connection.createConnection().createStatement();
        String sql = "SELECT * FROM room WHERE status_of_room = '" + statusOfRoom + "' AND is_booked = FALSE AND number_of_beds = " + numberOfBeds + " AND id NOT IN (SELECT id FROM booking WHERE start_date <= '" + endDate + "' AND end_date >= '" + startDate + "')";
        ResultSet rs = statement.executeQuery(sql);
        roomInserter(rooms, rs);
        return rooms;
    }

    private void roomInserter(List<Room> rooms, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Room room = new Room();
            roomParser(room, resultSet);
            rooms.add(room);
        }
    }

    private void roomParser(Room room, ResultSet resultSet) throws SQLException {
        room.setId(resultSet.getInt("id"));
        room.setBalcony(resultSet.getBoolean("balcony"));
        room.setExtra(resultSet.getString("extra"));
        room.setBooked(resultSet.getBoolean("is_booked"));
        room.setNumberOfBeds(resultSet.getInt("number_of_beds"));
        room.setStatusOfRoom(resultSet.getString("status_of_room"));
        room.setSquare(resultSet.getDouble("square"));
        room.setNumberOfRooms(resultSet.getInt("number_of_rooms"));
        room.setRoomNumber(resultSet.getInt("room_number"));
        room.setPhotoLink(resultSet.getString("photo_link"));
    }

    public static RoomDAO getInstance() {
        return roomDAO;
    }
}
