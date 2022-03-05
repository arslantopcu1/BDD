# language: tr
@refreshContext
@resetDataBase
@GUI
Özellik: Kullanıcı düzenleme
	Sistemde kullanıcı güncelleme yetkisi olan kullanıcı olarak
	Sistemi kullanacak bir kullanıcıyı düzenlemek için
	Kullanıcı düzenleme sayfasına girerek kullanıcı düzenlemek istiyorum.

	Senaryo taslağı: Kullanıcı tanımlama - Eksik bilgi hatası
    	
    	Diyelim ki "<kullanıcı>" GUI üzerinden sisteme giriş yaptı
    	Ve "<düzenlenecekKullanıcı>" kullanıcısının düzenleme sayfasına girdi
		Eğer ki "<yeniKullanıcı>" kullanıcı bilgilerini güncellerse
		Ama kullanıcı bilgilerinin bir ksımı eksikse
    	O zaman sistem ekle tuşunu kapatır
    	Örnekler: data
        | kullanıcı   		| düzenlenecekKullanıcı			|	yeniKullanıcı   				|
		| musteri    		| musteri-2       			    |	musteri--wt-surname--wt-name	|