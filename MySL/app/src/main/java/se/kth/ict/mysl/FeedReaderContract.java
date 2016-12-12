package se.kth.ict.mysl;

import android.provider.BaseColumns;

/**
 * Created by RafaelA on 2016-12-12.
 */

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {
    }

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "Table";
        public static final String EMAIL = "Email";
        public static final String START_DATE = "StartDate";
        public static final String END_DATE = "EndDate";
        public static final String PICKUP_DATE = "PickupDate";
    }
}