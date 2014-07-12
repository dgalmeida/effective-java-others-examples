package chapter02.item01.sfm;


public class CreateUserApp
{
    User user;

    public CreateUserApp()
    {
        this.user = User.createUnknownCommonUser();
    }

    public void createNewCommonUser(String userName)
    {
        this.user = User.createCommonUser(userName);
    }

    public void createMasterUser(String userName)
    {
        this.user = User.createMasterUser(userName);
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
        return (this.user instanceof SpecialUser);
    }
}