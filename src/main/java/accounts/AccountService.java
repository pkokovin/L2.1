package accounts;

import dbService.DBException;
import dbService.DBService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {
    private final Map<String, UserProfile> loginToProfile;
    private final Map<String, UserProfile> sessionIdToProfile;
    private DBService dbService = new DBService();

    public AccountService() {
        loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
    }

    public void addNewUser(UserProfile userProfile) throws DBException {
        String loginCurrent = null;
        try {
            loginCurrent = dbService.getUserByLogin(userProfile.getLogin()).getLogin();
        } catch (NullPointerException e) {

        }
        if (loginCurrent == null || !userProfile.getLogin().equals(loginCurrent)) {
            dbService.addUser(userProfile.getLogin(), userProfile.getPass());
        }
    }
//    public void addNewUser(UserProfile userProfile) {
//        loginToProfile.put(userProfile.getLogin(), userProfile);
//    }
    public UserProfile getUserByLogin(String login) throws DBException {
        UserProfile userProfile = null;
        try {
            userProfile = new UserProfile(dbService.getUserByLogin(login).getLogin(), dbService.getUserByLogin(login).getPassword());
        } catch (NullPointerException e) {

        }
        return userProfile;
    }
//    public UserProfile getUserByLogin(String login) {
//        return loginToProfile.get(login);
//    }

    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
