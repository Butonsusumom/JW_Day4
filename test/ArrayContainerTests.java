import com.tsybulko.arraycontainer.entity.Array;
import com.tsybulko.arraycontainer.exception.ArrayContainerException;
import com.tsybulko.arraycontainer.service.SearchService;
import com.tsybulko.arraycontainer.service.SortService;
import com.tsybulko.arraycontainer.util.ArrayGenerators;
import com.tsybulko.arraycontainer.util.CheckNumbers;
import org.junit.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ArrayContainerTests {

    private Array array = new Array(new int[]{7, 6, 2, 1, 5, 3, 4, 8, 10, 9});
    private Array sortedArray = new Array(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    private SearchService searchService = new SearchService();
    private SortService sortService = new SortService();

    @Test
    public void TestSearch() throws ArrayContainerException {
        int test = sortedArray.binarySearch(6);
    assertEquals(6-1,sortedArray.binarySearch(6));
}

    @Test
    public void TestMin() throws ArrayContainerException {
        assertEquals(1,sortedArray.getMin());
    }

    @Test
    public void TestMax() throws ArrayContainerException {
        assertEquals(10,sortedArray.getMax());
    }

    @Test
    public void TestSimple(){
        Array simpleArray = new Array(new int[]{7, 2, 1, 5, 3});
        assertEquals(simpleArray, searchService.findSimple(array));
    }

    @Test
    public void TestFibonacci(){
        Array fibonacciArray = new Array(new int[]{2, 1, 5, 3, 8});
        assertEquals(fibonacciArray, searchService.findFibonacci(array));
    }

    @Test
    public void TestThreeDigits(){
        Array baseArray = new Array(new int[]{777, 242, 581, 585, 379});
        Array treedigitArray = new Array(new int[]{581,379});
        assertEquals(treedigitArray, searchService.findThreeDigitNumbers(baseArray));
    }

    @Test
    public void TestFile() throws FileNotFoundException {
        Array baseArray = new Array(new int[]{777, 242, 581, 585, 379});
        ArrayGenerators arrayGenerator = new ArrayGenerators();
        Array array = arrayGenerator.readFile("C:\\Users\\KSU\\Java Web 2020\\Day4\\target\\array.txt");
        assertEquals(array, baseArray);
    }

    @Test
    public void testIsSorted() {
        boolean expected = sortedArray.isSorted();
        assertTrue(expected);
    }

    @Test
    public void TestBubble(){
        Array actual = SortService.bubbleSort(array);
        Array expected = sortedArray;
        assertEquals(actual, expected);
    }

    @Test
    public void TestSelection(){
        Array actual = SortService.insertionSort(array);
        Array expected = sortedArray;
        assertEquals(actual, expected);
    }

    @Test
    public void TestInsertion(){
        Array actual = SortService.selectionSort(array);
        Array expected = sortedArray;
        assertEquals(actual, expected);
    }


}
