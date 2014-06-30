package chapter02;


public class CreateUserApp
{
    User user;

    public CreateUserApp()
    {
        this.user = User.createUnknownCommonUser();
    }

    public void createNewCommonUser(String userName)
    {
        user = User.createCommonUser(userName);
    }

    public void createMasterUser(String userName)
    {
        user = User.createMasterUser(userName);
    }

    public String getUserName()
    {
        return this.user.getUserName();
    }

    public boolean isCommonUnknownUser()
    {
        return this.user.isUnknownNameUser() && this.isCommonUser();
    }

    public boolean isCommonUser()
    {
        return this.user.isTypeUser(UserType.COMMON);
    }

    public boolean isMasterUser()
    {
        return this.user.isTypeUser(UserType.MASTER);
    }

    public boolean isSpecialUser()
    {
        return (user instanceof SpecialUser);
    }
}