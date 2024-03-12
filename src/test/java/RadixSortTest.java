import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sorting.RadixSort;

public class RadixSortTest {

    RadixSort sorting = new RadixSort(); 
    int[] v;

    @Test
    public void testSort() {
        v = new int[]{8, 1, 78, 45, 3, 2, 103};
        assertArrayEquals(sorting.radixSort(v), new int[]{1, 2, 3, 8, 45, 78, 103});	

        v = new int[]{2};
        assertArrayEquals(sorting.radixSort(v), new int[]{2}); 

        v = new int[]{10, 2, 3, 4, 1, 1, 5, 1, 2, 10, 5};
        assertArrayEquals(sorting.radixSort(v), new int[]{1, 1, 1, 2, 2, 3, 4, 5, 5, 10, 10}); 

        v = new int[]{1, 1, 1, 2, 2 ,2};
        assertArrayEquals(sorting.radixSort(v), new int[]{1, 1, 1, 2, 2, 2}); 
    }


}




