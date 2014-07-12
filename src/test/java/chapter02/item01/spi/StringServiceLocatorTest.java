package chapter02.item01.spi;

import org.junit.Test;

import chapter02.item01.spi.StringService;
import chapter02.item01.spi.StringServiceLocator;
import chapter02.item01.spi.StringServiceProvider;
import chapter02.item01.spi.ToLowerCaseService;
import chapter02.item01.spi.ToUpperCaseService;
import static org.fest.assertions.Assertions.assertThat;


public class StringServiceLocatorTest
{
    @Test public void create_default_printer(){
        StringServiceLocator.registerDefaultProvider(new ToUpperCaseService());

        StringService stringService = StringServiceLocator.newInstance();

        assertThat(stringService.change("test")).isEqualTo("TEST");
    }


    @Test public void register_new_service(){
        StringServiceLocator.registerProvider("lowercase-service",new ToLowerCaseService());

        StringService stringService = StringServiceLocator.newInstance("lowercase-service");

        assertThat(stringService.change("TEST")).isEqualTo("test");
    }


    @Test public void register_custom_service(){

        StringServiceLocator.registerProvider("lowercase-service",

         new StringServiceProvider() {

            @Override
            public StringService newService()
            {
                return new StringService() {
                    @Override
                    public String change(String forPrint)
                    {
                        return forPrint+"anouninus+change";
                    }
                };
            }
        });

        StringService stringService = StringServiceLocator.newInstance("lowercase-service");

        assertThat(stringService.change("TEST")).contains("anouninus+change");
    }

}
