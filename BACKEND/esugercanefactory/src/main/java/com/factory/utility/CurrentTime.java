package com.factory.utility;

import java.text.SimpleDateFormat;
import java.util.*;

public class CurrentTime {

	  public static String getCurrentDateTimeMS() {
	        Date dNow = new Date();
	        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	        String datetime = ft.format(dNow);
	        return datetime;
	    }
}
