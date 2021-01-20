package week12d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {
    /*
    0 10 PERFECT
0 7 NEED_UPGRADE
1 12 NEED_UPGRADE
0 9 PERFECT
0 11 NO_FENCE
1 13 PERFECT
     */

    @Test
    void testLastSelled() {
        Street st= new Street();
        st.sellSite(new Site(false, 10, Fence.PERFECT));
        st.sellSite(new Site(false, 7, Fence.NEED_UPGRADE));
        st.sellSite(new Site(true, 12, Fence.NEED_UPGRADE));
        st.sellSite(new Site(false, 9, Fence.PERFECT));
        st.sellSite(new Site(false, 11, Fence.NO_FENCE));
        st.sellSite(new Site(true, 13, Fence.PERFECT));

        assertEquals(3, st.lastSelledNumber());
    }

    @Test
    void testSellingStats() {
        Street st= new Street();
        st.sellSite(new Site(false, 10, Fence.PERFECT));
        st.sellSite(new Site(false, 7, Fence.NEED_UPGRADE));
        st.sellSite(new Site(true, 12, Fence.NEED_UPGRADE));
        st.sellSite(new Site(false, 9, Fence.PERFECT));
        st.sellSite(new Site(false, 11, Fence.NO_FENCE));
        st.sellSite(new Site(true, 13, Fence.PERFECT));

        assertEquals("PERFECT, NEED_UPGRADE, NO_FENCE: [3, 2, 1]", st.sellingStats());
    }

}