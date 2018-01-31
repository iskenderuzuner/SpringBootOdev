package com.spring.Spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.Spring.Haber;
import com.spring.Spring.SpringMain;
import com.spring.Spring.RESTServisi;

import org.springframework.boot.test.json.JacksonTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Iskender Uzuner
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@JsonTest

public class SpringBootTest {

	@Autowired
    private JacksonTester<Haber> json;
	
  /**
	haber testi
	
   */
	
	@Test
    public void testHaber() throws Exception {
        Haber haber = new Haber("Baslik", "Icerik");
        assertThat(this.json.write(haber)).hasJsonPathStringValue("@.haberBaslik");
        assertThat(this.json.write(haber)).extractingJsonPathStringValue("@.haberIcerik")
                .isEqualTo("Icerik");
    }
	
	/**
	 * RESTServisinde bulunan haberYAZ metotunu test eder.
	 * @throws Exception Hata fırlatır.
	 */
	
	@Test
	public void testHaberYaz() throws Exception {
	  	Haber haber = RESTServisi.haberYAZ("deneme", "icerik");
	  	assertEquals("deneme",haber.getHaberBaslik());
	  	assertEquals("icerik",haber.getHaberIcerik());
	}
	/**
	 * RESTServisinde bulunan haberListele metotunu test eder.
	 * @throws Exception Hata fırlatır.
	 */
	@Test
 	public void testHaberListele() throws Exception{

	  	RESTServisi.haberYAZ("Baslik", "icerik");
	    assertTrue(RESTServisi.haberListele().stream().anyMatch(item -> "Baslik".equals(item.getHaberBaslik())));	
	    assertTrue(RESTServisi.haberListele().stream().anyMatch(item -> "icerik".equals(item.getHaberIcerik())));	  	
	    
 	}
	
	/**
	 * RESTServisinde bulunan haberTemizle metotunu test eder.
	 * @throws Exception Hata fırlatır.
	 */
	
	@Test
	public void testHaberTemizle() throws Exception{

		assertTrue(RESTServisi.haberTemizle(), true);
	}
	
	/**
	 * RESTServisinde bulunan haberSil metotunu test eder.
	 * @throws Exception Hata fırlatır.
	 */
	
	@Test
 	public void testHaberSil() throws Exception{
	    List<Haber> HABERLERTEST = new ArrayList<>();
	  	Haber haber = RESTServisi.haberYAZ("deneme", "icerik");
	    HABERLERTEST.add(haber);
	  	assertEquals("Secilen index deki haber silindi",RESTServisi.haberSil(0));

 	}
 	
  /**
   * RESTServisi sınıfını test eder.
   * @throws Exception Hata Fırlatır.
   */
	
	@Test
 	public void testClass() throws Exception{
 		boolean hataOlustu = false;
 		try {
 			RESTServisi servis = new RESTServisi();
 		} catch(Exception e) {
 			hataOlustu = true;
 		}
 		
 		assertFalse(hataOlustu);
 	}
 	
  /**
   * Maini test eder
   */
	
	@Test
	public void testMain() { 
	  SpringMain.main(new String[]{
              "--spring.main.web-environment=false",
      });
	}
	
	

	

}
