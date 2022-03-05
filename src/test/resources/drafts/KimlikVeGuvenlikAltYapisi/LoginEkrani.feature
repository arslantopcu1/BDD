# language: tr
@refreshContext
@resetDataBase
@GUI
@Manual
Özellik: Login Ekranı
	Sistemde tanımlı bir kullanıcı olarak
	Uygulamayı kullanmak için
	Sisteme giriş yapmak istiyorum.


    Senaryo taslağı: Login Ekranı  
    	
    	Diyelim ki "<kullanıcı>" giriş sayfasını açtı
		Eğer ki bilgilerini sisteme girip giriş tuşuna basarsa
    	O zaman sistem kullanıcıyı ana ekrana alır
        Örnekler: data
        | kullanıcı   	|
		| musteri    	|

	Senaryo taslağı: Login Ekranı - Yanlış bilgi hatası 
    	
    	Diyelim ki "<kullanıcı>" giriş sayfasını açtı
		Eğer ki bilgilerini sisteme girip giriş tuşuna basarsa
		Ama bilgilerin bir kısmı yanlışsa
    	O zaman sistem "Kullanıcı adı ya da şifre hatalı" hatası verir
        Örnekler: data
        | kullanıcı   			|
		| musteri-bad-email  	|
	
	Senaryo taslağı: Login Ekranı - Pasif kullanıcı hatası
    	
    	Diyelim ki "<kullanıcı>" giriş sayfasını açtı
		Eğer ki bilgilerini sisteme girip giriş tuşuna basarsa
		Ama kullanıcı pasif ise
    	O zaman sistem "Kullanıcı pasif. Sistem yöneticisi ile temasa geçiniz" hatası verir
        Örnekler: data
        | kullanıcı   	|
		| musteri-pasif-user |
		
	Senaryo taslağı: Login Ekranı - Kullanıcı kitleme
    	
    	Diyelim ki "<kullanıcı>" giriş sayfasını açtı
		Eğer ki bilgilerini üç kere yanlış girerse
    	O zaman sistem "Kullanıcı kitlendi. Sistem yöneticisi ile temasa geçiniz" hatası verir
        Örnekler: data
        | kullanıcı   	|
		| musteri    	|
		