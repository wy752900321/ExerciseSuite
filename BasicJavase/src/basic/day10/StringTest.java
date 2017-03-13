package basic.day10;

public class StringTest {
	      public static void main(String[] args) {
	    	  System.out.println("abc");
		      String cde = "cde";
		      System.out.println("abc" + cde);
		      String c = "abc".substring(2,3);
		      System.out.println(c);
		      String d = cde.substring(1, 2);
		      System.out.println(d);
		}
/*	      public boolean equals(Object anObject) {
	    		if (this == anObject) {
	    		    return true;
	    		}
	    		if (anObject instanceof String) {
	    		    String anotherString = (String)anObject;
	    		    int n = count;
	    		    if (n == anotherString.count) {
	    			char v1[] = value;
	    			char v2[] = anotherString.value;
	    			int i = offset;
	    			int j = anotherString.offset;
	    			while (n-- != 0) {
	    			    if (v1[i++] != v2[j++])
	    				return false;
	    			}
	    			return true;
	    		    }
	    		}
	    		return false;*/
	    	    }
