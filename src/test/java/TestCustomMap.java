import com.ak.CustomMap;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by MacDuck on 7/29/17.
 */
public class TestCustomMap {

    @Test
    public void putTest(){
        CustomMap map = new CustomMap(30);
        boolean isPutWork = map.put(40, (long)4);

        assertEquals(true, isPutWork);
    }

    @Test
    public void getTest(){
        CustomMap map = new CustomMap();
        map.put(20, (long)4);
        assertEquals(new Long(4), map.get(20));
    }

    @Test
    public void sizeTest(){
        CustomMap map = new CustomMap();
        map.put(10, (long)4);
        map.put(12, (long)55);
        map.put(12, (long)55);
        assertEquals(2, map.size());
    }
}
