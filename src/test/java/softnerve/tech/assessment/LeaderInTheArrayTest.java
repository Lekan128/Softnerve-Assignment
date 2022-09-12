package softnerve.tech.assessment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LeaderInTheArrayTest {

    @Test
    void getLeaderInTheArray() {
        assertEquals(LeaderInTheArray.getLeaderInTheArray(new int[] {7, 10, 4, 10, 6, 5, 2}), 10);
        //10 is on the right side of the array and  is bigger than 7
        assertNotEquals(LeaderInTheArray.getLeaderInTheArray(new int[] {7, 10, 4, 10, 6, 5, 2}), 7);
    }
}