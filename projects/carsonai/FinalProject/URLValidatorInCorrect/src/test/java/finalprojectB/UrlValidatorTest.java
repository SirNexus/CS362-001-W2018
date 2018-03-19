
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	    
    UrlValidator url = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
    assertFalse(url.isValid(null));
    assertTrue(url.isValid("http://www.google.com"));
    assertTrue(url.isValid("http:/www.google.com"));
    assertTrue(url.isValid("http://ww.google.com"));
    assertFalse(url.isValid("http://www.google.com:80"));
    // assertFalse(url.isValid("http:")); This catches the second bug

    // Should include more manual URLs here
   }

   public void testYourFirstPartition()
   {
    //You can use this function to implement your First Partition testing	 
    UrlValidator urlVal1 = new UrlValidator();
    assertFalse(urlVal1.isValid("http:"));

   }
   
   public void testYourSecondPartition(){
     //You can use this function to implement your Second Partition testing	   
    String[] schemes = {"http","https"};
     
     UrlValidator urlVal2 = new UrlValidator(schemes);
     assertTrue(urlVal2.isValid("https://google.com"));

   }
   //You need to create more test cases for your Partitions if you need to 

   public void testYourThirdPartition(){
    //You can use this function to implement your Third Partition testing	   
    long options = 1;
    
    UrlValidator urlVal3 = new UrlValidator(options);
    assertTrue(urlVal3.isValid("https://google.com"));

  }
  //You need to create more test cases for your Partitions if you need to 

  public void testYourFourthPartition(){
    //You can use this function to implement your Fourth Partition testing	
    long options = 1;

    UrlValidator urlVal4 = new UrlValidator(null, null, options);
    assertTrue(urlVal4.isValid("https://google.com"));

  }
  //You need to create more test cases for your Partitions if you need to 

  public void testYourFifthPartition(){
    //You can use this function to implement your Fifth Partition testing	  
    String[] schemes = {"http","https"};
    long options = 1;
    
    UrlValidator urlVal5 = new UrlValidator(schemes, null, options);
   assertTrue(urlVal5.isValid("https://google.com"));

  }
  //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
     //You can use this function for programming based testing

     UrlValidator url = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);

     String[] validURLs = {
      "http://www.google.com",
      "ftp://www.google.com",
      "http://go.com"
     };

     String[] invalidURLs = {
      "http://www.google.com:-1",
      "http://www.google.com/../",
     };
     
     for (int i = 0; i < validURLs.length; i++){
       assertTrue(url.isValid(validURLs[i]));
     }

     for (int i = 0; i < invalidURLs.length; i++){
      assertFalse(url.isValid(invalidURLs[i]));
    }
     

   }
   


}
