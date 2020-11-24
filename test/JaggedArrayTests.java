import com.tsybulko.arraycontainer.exception.ArrayContainerException;
import com.tsybulko.jaggedarray.service.ArraySortService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JaggedArrayTests {
    ArraySortService sortService = new ArraySortService();
    private int [][] twoDimArray = {{2,4,5,8,9,13},{1,4,7,11},{4,18,20,5,3},{7,4,5,10,9,12,17}};

    @Test
    public void TestSortMax() {
        assertEquals(new int[][]{{1,4,7,11},{2,4,5,8,9,13},{7,4,5,10,9,12,17},{4,18,20,5,3}},sortService.sortByMax(twoDimArray));
    }

    @Test
    public void TestSortMin() {
        assertEquals(new int[][]{{1,4,7,11},{2,4,5,8,9,13},{4,18,20,5,3},{7,4,5,10,9,12,17}},sortService.sortByMin(twoDimArray));
    }

    @Test
    public void TestSortSum() {
        assertEquals(new int[][]{{1,4,7,11},{2,4,5,8,9,13},{4,18,20,5,3},{7,4,5,10,9,12,17}},sortService.sortBySum(twoDimArray));
    }

}
