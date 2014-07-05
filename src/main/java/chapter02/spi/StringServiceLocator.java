package chapter02.spi;

import java.util.HashMap;
import java.util.Map;


public class StringServiceLocator
{
    private StringServiceLocator(){}

    private static final Map<String,StringServiceProvider> providers = new HashMap<>();
    public static final String DEFAULT_PROVIDER_NAME = "--default--";


    public static void registerProvider(String name,StringServiceProvider stringServiceProvider)
    {
        providers.put(name, stringServiceProvider);
    }

    public static void registerDefaultProvider(StringServiceProvider stringServiceProvider)
    {
        providers.put(DEFAULT_PROVIDER_NAME, stringServiceProvider);
    }

    public static StringService newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static StringService newInstance(String name) {
        StringServiceProvider p = providers.get(name);
        if (p == null)
            throw new IllegalArgumentException(
                    "No printer registered with name: " + name);
        return p.newService();
    }


}
