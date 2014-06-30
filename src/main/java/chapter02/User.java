package chapter02;

import com.google.common.base.Strings;

import java.util.HashMap;
import java.util.Map;


public class User
{
    private static final Map<String, User> historyOfCreatedUsers = new HashMap<>();
    private static final String UNKNOWN_NAME = "unknownName";

    private UserType userType;
    private String userName;


    protected User(UserType userType, String userName)
    {
        this.userType = userType;
        this.userName = userName;

        if (!userName.equals(UNKNOWN_NAME))
            subscribeUser(this);
    }

    public static User createUnknownCommonUser()
    {
        return createUser(UserType.COMMON, UNKNOWN_NAME);
    }

    public static User createMasterUser(String userName)
    {
        return createUser(UserType.MASTER, userName);
    }

    public static User createCommonUser(String userName)
    {
        return createUser(UserType.COMMON, userName);
    }

    private static User createUser(UserType userType, String userName)
    {

        if (userName.isEmpty())
            return createUnknownCommonUser();

        if (alreadyCreated(userName))
            return historyOfCreatedUsers.get(userName);

        if (userType.equals(UserType.MASTER))
            return new SpecialUser(userType,userName);

        return new User(userType, userName);
    }

    private static boolean alreadyCreated(String userName)
    {
        return !Strings.isNullOrEmpty(userName) && (historyOfCreatedUsers.containsKey(userName));
    }

    private static void subscribeUser(User user)
    {
        historyOfCreatedUsers.put(user.getUserName(), user);
    }

    public boolean isTypeUser(UserType userType)
    {
        return this.userType.equals(userType);
    }

    public boolean isUnknownNameUser()
    {
        return this.userName.equals(UNKNOWN_NAME);
    }

    public String getUserName()
    {
        return userName;
    }

}
