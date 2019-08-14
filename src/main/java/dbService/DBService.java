package dbService;

import dbService.dataSets.UsersDataSet;

public interface DBService {
    UsersDataSet getUser(long id) throws DBException;
    UsersDataSet getUserByLogin(String login) throws DBException;
    long addUser(String name, String password) throws DBException;
}
