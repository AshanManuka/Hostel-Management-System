package lk.ijse.HostelManagementSystem.bo.custom.impl;

import lk.ijse.HostelManagementSystem.bo.custom.UserBO;
import lk.ijse.HostelManagementSystem.dao.DaoFactory;
import lk.ijse.HostelManagementSystem.dao.custom.impl.UserDaoImpl;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserBoImpl implements UserBO {
    UserDaoImpl userDaoImpl = (UserDaoImpl) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.USER);

    @Override
    public ArrayList<User> getAllUser() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteUser(String code) throws SQLException, ClassNotFoundException, IOException {
        return userDaoImpl.delete(code);
    }

    @Override
    public boolean saveUser(User dto) throws SQLException, ClassNotFoundException, IOException {
        return userDaoImpl.save(dto);
    }

    @Override
    public boolean updateUser(User dto) throws SQLException, ClassNotFoundException, IOException {
        return userDaoImpl.update(dto);
    }

    @Override
    public boolean existsUser(String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Room searchUser(String code) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewUserId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> searchUserCode() throws SQLException, ClassNotFoundException {
        return null;
    }
}
