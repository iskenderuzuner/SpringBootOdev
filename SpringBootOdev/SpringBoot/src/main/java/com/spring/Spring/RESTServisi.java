package com.spring.Spring;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Iskender Uzuner
 *
 */

@RestController
public class RESTServisi {

    private static final List<Haber> HABERLER = new ArrayList<>();
    
    /**
     * RESTServisi haberleri icin islemleri olusturur.
     */
    
    @RequestMapping("/haber/olustur")
   	public static Haber haberYAZ(String haberbasligi, String habericerigi) 
   	{
   		Haber haber = new Haber(haberbasligi, habericerigi);
   		HABERLER.add(haber);
   		return haber;
   	}
    
    /**
     * Haberleri listelemek icin.
     * @return ile yaratilan bütün haberler.
     */
    
	@RequestMapping("/haber/listele")
	public static List<Haber> haberListele()
	{
		return HABERLER;
	}
	
	/**
	 * Oluşturulan bütün haberleri temizlemek için kullanılır.
	 * @return Haberlerin temizlendiğine dair kullanıcıya mesaj
	 */
	
	@RequestMapping("/haber/temizle")
	public static String haberTemizle()
	{
		HABERLER.clear();
		return "Haberlerin tumu silindi.";
	}
	
	/**
	 * Verilen indexteki haberi silmek için kullanılır.
	 * @param index Kullacının verdiği index değeri
	 * @return Verilen indexteki haberin silidindiğie dair kullanıcıya mesaj.
	 */
	@RequestMapping("/haber/sil")
	public static String haberSil(int index)
	{
		HABERLER.remove(index);
		return "Secilen index deki haber silindi.";
	}	
}
