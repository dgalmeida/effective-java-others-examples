package chapter02.item01.sfm;

public class SpecialUser extends User
{
    private static final String SPECIAL_SING = "--spc--";

    public SpecialUser(UserType userType,String userName)
    {
        super(userType, userName+SPECIAL_SING);
    }
}
