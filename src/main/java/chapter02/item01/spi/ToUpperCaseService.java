package chapter02.item01.spi;

public class ToUpperCaseService implements StringServiceProvider
{
    @Override
    public StringService newService()
    {
        return new StringService(){

            @Override
            public String change(String forPrint)
            {
                return forPrint.toUpperCase();
            }
        };
    }
}
