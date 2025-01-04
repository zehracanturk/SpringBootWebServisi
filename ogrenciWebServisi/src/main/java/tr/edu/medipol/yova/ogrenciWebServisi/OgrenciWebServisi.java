package tr.edu.medipol.yova.ogrenciWebServisi;

import java.util.*;

import org.springframework.web.bind.annotation.*;

/*
 * http://localhost:8081/ogrenci/ adresine gelen istekleri karşılar
 * */

@RestController
@RequestMapping("/ogrenci")

public class OgrenciWebServisi {
	

	public record Ogrenci(String adSoyad, String Numara) {};
	
	private static List<Ogrenci> ogrenciler= new ArrayList<>();
	
	static {
		
		ogrenciler.add(new Ogrenci("Ali", "100000000001"));
		ogrenciler.add(new Ogrenci("Ayse","100000000002"));
		ogrenciler.add(new Ogrenci("Fatma","100000000003"));
	}
	
	/** .../listele şeklinde gelen HTTP GET isteklerini karşılar*/
	@GetMapping("/listele")
	
	public List<Ogrenci> listele(){
		
		return ogrenciler;
	}
	
	@PostMapping("/ekle")
	public boolean ekle(@RequestBody Ogrenci yeniOgrenci){
		
		ogrenciler.add(yeniOgrenci);
		return true;
	}
	
}
