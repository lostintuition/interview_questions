package interviews.algorithms.uf;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class WeightedQuickUnionFindTest {

    @Test
    public void testWeightedQuickUnionFind() {
        WeightedQuickUnionFind uf = new WeightedQuickUnionFind(10);
        uf.union(4,3);
        uf.union(3,8);
        uf.union(6,5);
        uf.union(9,4);
        uf.union(2,1);
        uf.union(8,9);
        uf.union(5,0);
        uf.union(7,2);
        uf.union(6,1);
        uf.union(1,0);
        uf.union(6,7);

        assertThat(uf.count(), is(equalTo(2)));
        assertThat(uf.connected(2, 6), is(equalTo(true)));
        assertThat(uf.connected(4, 7), is(equalTo(false)));
        assertThat(uf.find(3), is(equalTo(4)));
        assertThat(uf.find(7), is(equalTo(6)));
    }
}