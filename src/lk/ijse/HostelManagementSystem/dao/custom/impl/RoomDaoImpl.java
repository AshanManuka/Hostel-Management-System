package lk.ijse.HostelManagementSystem.dao.custom.impl;

import lk.ijse.HostelManagementSystem.dao.custom.RoomDao;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    private Session session;
    private Transaction transaction;


    @Override
    public String exist() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Room dto) throws SQLException, ClassNotFoundException, IOException {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<String> searchId() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<String> idList = new ArrayList<>();

        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        String hql = "FROM Room";
        Query query = session.createQuery(hql);
        List<Room> roomList = query.list();

        for (Room room: roomList) {
            idList.add(room.getRoomId());
        }

        transaction.commit();
        session.close();

        return idList;
    }

    @Override
    public Room search(String s) throws SQLException, ClassNotFoundException, IOException {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();

        String hql = "FROM Room WHERE roomId =:room_id";
        Query query = session.createQuery(hql);
        query.setParameter("room_id",s);
        List<Room> roomList = query.list();

        for (Room room: roomList) {
            return room;
        }

        transaction.commit();
        session.close();

        return null;
    }

    @Override
    public boolean update(Room dto) throws SQLException, ClassNotFoundException, IOException {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.update(dto);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        Room room = session.load(Room.class, s);
        session.delete(room);
        transaction.commit();
        session.close();
        return true;
    }


}
