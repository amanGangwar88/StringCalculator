 package com.durgasoft.jdbc;

import static org.junit.Assert.assertEquals;

public class TestCalculator {
 
	 
		public void testEmptyString() {
			StringCalculator calculator=new StringCalculator();
			assertEquals(0, StringCalculator.add(""));
		}
	
		@org.junit.Test
		public void testOneNumber() {
			assertEquals(1, StringCalculator.add("1"));
		}

		@org.junit.Test
		public void testTwoNumbers(){
			assertEquals(3, StringCalculator.add("1,2"));
		}

		@org.junit.Test
	    public void testThreeNumbers(){
	    	assertEquals(6, StringCalculator.add("1,2,3"));
	    }

	    @org.junit.Test
	    public void testNewLine(){
	    	assertEquals(6, StringCalculator.add("1\n2,3"));
	    }

	    @org.junit.Test
	    public void testNegativeNumver(){
	    	try {
				StringCalculator.add("-1,2");
			}
			catch (IllegalArgumentException e){
				assertEquals(e.getMessage(), "Negatives not allowed: -1");
			}

			try {
				StringCalculator.add("2,-4,3,-5");
			}
			catch (IllegalArgumentException e){
				assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
			}
	    }

	    @org.junit.Test
	    public void testOverThousand(){
	    	assertEquals(2, StringCalculator.add("1000,2"));
	    }

	    @org.junit.Test
	    public void testOtherDelimiter(){
	    	assertEquals(3, StringCalculator.add("//;\n1;2"));
	    }
}
