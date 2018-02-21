import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

public class ch11_16a
{
    /*Write a method called is1to1 that accepts a map whose keys and values are strings as its parameter and returns true if
    no two keys map to the same value. For example, {Marty=206–9024, Hawking=123–4567, Smith=949–0504,Newton=123–4567} should return false,
    but {Marty=206–9024, Hawking=555–1234, Smith=949–0504, Newton=123–4567} should return true.
    The empty map is considered 1-to-1 and returns true.*/

    //to test class
    public void run()
    {
        Map<String,String> map = new HashMap<>();
        map.put("Marty","206-9024");
        map.put("Hawking","123-4567");
        //map.put("Hawking","555-1234");
        map.put("Smith","949-0504");
        map.put("Newton","123-4567");

        System.out.println(is1to1(map));
    }

    public boolean is1to1(Map<String,String> map)
    {
        boolean is1to1 = true;
        //a copy of map so we can remove objects, and then can we compare the values.
        Map<String,String> mapCopy = map;

        if (map.isEmpty() == true)
        {
            return is1to1;
        }
        try
        {
            //here we are removing current object, and checks if other keys have the same number, if yes then return false;
            for (Map.Entry<String, String> m: map.entrySet())
            {
                mapCopy.remove(m.getKey());
                if (mapCopy.containsValue(m.getValue()) == true)
                {
                    is1to1 = false;
                }
            }
        }catch (ConcurrentModificationException CMe)
        {
            return is1to1;
        }
        return is1to1;
    }
}
