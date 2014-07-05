package chapter02.sfm;

import chapter02.sfm.CreateUserApp;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class CreateUserAppTest
{

   @Test
    public void create_common_user() throws Exception
    {

        CreateUserApp createUserApp = new CreateUserApp();
        createUserApp.createNewCommonUser("CommonUserName");

        assertThat(createUserApp.getUserName()).isEqualTo("CommonUserName");
        assertThat(createUserApp.isCommonUser()).isTrue();
    }

   @Test
    public void create_master_user() throws Exception
    {
        String SPECIAL_SIGN = "--spc--";
        CreateUserApp createUserApp = new CreateUserApp();
        createUserApp.createMasterUser("MasterUserName");

        assertThat(createUserApp.getUserName()).isEqualTo("MasterUserName"+SPECIAL_SIGN);
        assertThat(createUserApp.isMasterUser()).isTrue();
        assertThat(createUserApp.isSpecialUser()).isTrue();
    }

    @Test
    public void create_unknown_name_user()
    {
        CreateUserApp createUserApp = new CreateUserApp();
        String emptyString = "";
        createUserApp.createNewCommonUser(emptyString);

        assertThat(createUserApp.getUserName()).isEqualTo("unknownName");
        assertThat(createUserApp.isCommonUnknownUser()).isTrue();
    }
}
