# language: tr
@refreshContext
@resetDataBase
@Rest
@Manual
Özellik: Restful Servis Üzerinden Mail Dogrulama
	Yeni oluşturulmuş kullanıcı olarak
	Üyeliğimin oluşturulmasını tamamlamak için
	Restful servis ile doğrulama yapıp şifremi tanımlamak istiyorum

	
	Senaryo taslağı: Pozitif Doğrulama
  		Diyelim ki doğrulama kodunu içeren doğrulama mailini aldım
    	Eğer ki token : "<token>" şifre : "<şifre>" şifre tekrar: "<şifre tekrar>" bilgilerini servise parametre olarak gönderirsem 
    	Ve şifre gerekli kriterleri "sağlıyorsa"
    	O zaman Sistem tokenin kayıtlı olduğu kullanıcaya girilen şifreyi atar ve üyeliği aktif eder
		Örnekler: data
      		| token 	                 | şifre   | şifre tekrar   |
     		| j29ckdf287c4nqlrtrfo8576ti | asdddd@ | asdddd@  		|
    
     	
	Senaryo taslağı: Geçersiz istek hatası
  		Diyelim ki doğrulama kodunu içeren doğrulama mailini aldım
    	Eğer ki token : "<token>" şifre : "<şifre>" şifre tekrar: "<şifre tekrar>" bilgilerini servise parametre olarak gönderirsem 
    	Ama şifre gerekli kriterleri "sağlamıyorsa"
    	O zaman Sistem "<httpKodu>" kodu ile hata verir.
		Örnekler: data
      		| token 	  					| şifre 	     | şifre tekrar  | httpKodu |
     		| j29ckdf287c4nqlrtrfo8576ti 	| sifrelaier 	 | adsdd  		 | 400	    |

