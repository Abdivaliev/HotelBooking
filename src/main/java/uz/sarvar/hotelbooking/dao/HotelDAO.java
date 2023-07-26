package uz.sarvar.hotelbooking.dao;

import uz.sarvar.hotelbooking.ConnectionSource;
import uz.sarvar.hotelbooking.model.Hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelDAO {
    private static final HotelDAO hotelDAO = new HotelDAO();
    ConnectionSource connectionSource = ConnectionSource.instance();


    public Hotel getHotelInfo() throws SQLException {
        Statement statement = connectionSource.createConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from hotel");
        Hotel hotel = null;
        while (resultSet.next()) {
            hotel = new Hotel(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );
        }
        return hotel;
    }


    public static HotelDAO getInstance() {
        return hotelDAO;
    }
}
