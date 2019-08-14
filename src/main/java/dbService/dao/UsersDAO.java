package dbService.dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsersDAO {
    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public long getUserId(String login) throws HibernateException {
        long result = 0;
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        UsersDataSet tmpUsersDataSet = ((UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult());
        if (tmpUsersDataSet != null) {
            result = tmpUsersDataSet.getId();
        }
        return result;
    }

    public String getUserPassword(String login) throws HibernateException {
        String result = null;
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        UsersDataSet tmpUserDataSet = ((UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult());
        if (tmpUserDataSet != null) {
            result = tmpUserDataSet.getPassword();
        }
        return result;
    }

    public long insertUser(String login, String password) throws HibernateException {
        return (Long) session.save(new UsersDataSet(login, password));
    }
}
