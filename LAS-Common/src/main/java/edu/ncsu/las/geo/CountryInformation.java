package edu.ncsu.las.geo;

/**
 * Translates from native UTF-8 country name to the English name.
 * 
 */
public class CountryInformation {
	public static final java.util.HashMap<String, String> COUNTRY_TRANSLATE = new java.util.HashMap<String,String>();
	
	static {
		COUNTRY_TRANSLATE.put("Argentina", "Argentina");
		COUNTRY_TRANSLATE.put("Australia", "Australia");
		COUNTRY_TRANSLATE.put("Azərbaycan", "Azerbaijan");
		COUNTRY_TRANSLATE.put("België - Belgique - Belgien", "Belgium");
		COUNTRY_TRANSLATE.put("Bolivia", "Bolivia");
		COUNTRY_TRANSLATE.put("Botswana", "Botswana");
		COUNTRY_TRANSLATE.put("Brasil", "Brazil");
		COUNTRY_TRANSLATE.put("Burkina Faso", "Burkina Faso");
		COUNTRY_TRANSLATE.put("Cameroun", "Cameroon");
		COUNTRY_TRANSLATE.put("Canada", "Canada");
		COUNTRY_TRANSLATE.put("Cayman Islands", "Cayman Islands");
		COUNTRY_TRANSLATE.put("Chile", "Chile");
		COUNTRY_TRANSLATE.put("Colombia", "Colombia");
		COUNTRY_TRANSLATE.put("Costa Rica", "Costa Rica");
		COUNTRY_TRANSLATE.put("Cuba", "Cuba");
		COUNTRY_TRANSLATE.put("Danmark", "Denmark");
		COUNTRY_TRANSLATE.put("Deutschland", "Germany");
		COUNTRY_TRANSLATE.put("Ecuador", "Ecuador");
		COUNTRY_TRANSLATE.put("Eesti", "Estonia");
		COUNTRY_TRANSLATE.put("España", "Spain");
		COUNTRY_TRANSLATE.put("Europe", "Europe");
		COUNTRY_TRANSLATE.put("France", "France");
		COUNTRY_TRANSLATE.put("Ghana", "Ghana");
		COUNTRY_TRANSLATE.put("Hrvatska", "Croatia");
		COUNTRY_TRANSLATE.put("India", "India");
		COUNTRY_TRANSLATE.put("Indonesia", "Indonesia");
		COUNTRY_TRANSLATE.put("Ireland", "Ireland");
		COUNTRY_TRANSLATE.put("Italia", "Italy");
		COUNTRY_TRANSLATE.put("Jamaica", "Jamaica");
		COUNTRY_TRANSLATE.put("Kenya", "v");
		COUNTRY_TRANSLATE.put("Ködörösêse tî Bêafrîka - République Centrafricaine", "Central African Republic");
		COUNTRY_TRANSLATE.put("Latvija", "Latvia");
		COUNTRY_TRANSLATE.put("Lietuva", "Lithuania");
		COUNTRY_TRANSLATE.put("Lëtzebuerg", "Luxembourg");
		COUNTRY_TRANSLATE.put("Madagasikara", "Madagascar");
		COUNTRY_TRANSLATE.put("Magyarország", "Hungary");
		COUNTRY_TRANSLATE.put("Malaysia", "Malaysia");
		COUNTRY_TRANSLATE.put("Malta", "Malta");
		COUNTRY_TRANSLATE.put("Moçambique", "Mozambique");
		COUNTRY_TRANSLATE.put("México", "Mexico");
		COUNTRY_TRANSLATE.put("Nederland", "Netherlands");
		COUNTRY_TRANSLATE.put("New Zealand/Aotearoa", "New Zealand");
		COUNTRY_TRANSLATE.put("Nigeria", "Nigeria");
		COUNTRY_TRANSLATE.put("Norge", "Norway");
		COUNTRY_TRANSLATE.put("Papua New Guinea", "Papua New Guinea");
		COUNTRY_TRANSLATE.put("Perú", "Peru");
		COUNTRY_TRANSLATE.put("Philippines", "Philippines");
		COUNTRY_TRANSLATE.put("Polska", "Poland");
		COUNTRY_TRANSLATE.put("Portugal", "Portugal");
		COUNTRY_TRANSLATE.put("România", "Romania");
		COUNTRY_TRANSLATE.put("Saint Kitts and Nevis", "Saint Kitts and Nevis");
		COUNTRY_TRANSLATE.put("Schweiz/Suisse/Svizzera/Svizra", "Switzerland");
		COUNTRY_TRANSLATE.put("Singapore", "Singapore");
		COUNTRY_TRANSLATE.put("Slovenija", "Slovenia");
		COUNTRY_TRANSLATE.put("Slovensko", "Slovakia");
		COUNTRY_TRANSLATE.put("South Africa", "South Africa");
		COUNTRY_TRANSLATE.put("Suomi", "Finland");
		COUNTRY_TRANSLATE.put("Sverige", "Sweden");
		COUNTRY_TRANSLATE.put("Sénégal", "Senegal");
		COUNTRY_TRANSLATE.put("Tanzania", "Tanzania");
		COUNTRY_TRANSLATE.put("Türkiye", "Turkey");
		COUNTRY_TRANSLATE.put("UK", "United Kingdom");
		COUNTRY_TRANSLATE.put("United Kingdom", "United Kingdom");
		COUNTRY_TRANSLATE.put("United States of America", "United States");
		COUNTRY_TRANSLATE.put("Uruguay", "Uruguay");
		COUNTRY_TRANSLATE.put("Việt Nam", "Vietnam");
		COUNTRY_TRANSLATE.put("Österreich", "Austria");
		COUNTRY_TRANSLATE.put("Česko", "Czech Republic");
		COUNTRY_TRANSLATE.put("Ελλάδα", "Greece");
		COUNTRY_TRANSLATE.put("Κύπρος - Kıbrıs", "Cyprus");
		COUNTRY_TRANSLATE.put("Беларусь", "Belarus");
		COUNTRY_TRANSLATE.put("Македонија", "Macedonia");
		COUNTRY_TRANSLATE.put("РФ", "Russia");
		COUNTRY_TRANSLATE.put("Serbia", "");
		COUNTRY_TRANSLATE.put("מדינת ישראל", "Israel");
		COUNTRY_TRANSLATE.put("الأراضي الفلسطينية", "Palestine");
		COUNTRY_TRANSLATE.put("الإمارات العربيّة المتّحدة", "United Arab Emirates");
		COUNTRY_TRANSLATE.put("السعودية", "Saudi Arabia");
		COUNTRY_TRANSLATE.put("السودان", "Sudan");
		COUNTRY_TRANSLATE.put("العراق", "Iraq");
		COUNTRY_TRANSLATE.put("تونس", "Tunisia");
		COUNTRY_TRANSLATE.put("عمان", "Oman");
		COUNTRY_TRANSLATE.put("لبنان", "Lebanon");
		COUNTRY_TRANSLATE.put("مصر", "Egypt");
		COUNTRY_TRANSLATE.put("नेपाल", "Nepal");
		COUNTRY_TRANSLATE.put("বাংলাদেশ", "Bangladesh");
		COUNTRY_TRANSLATE.put("ประเทศไทย", "Thailand");
		COUNTRY_TRANSLATE.put("საქართველო", "Georgia");
		COUNTRY_TRANSLATE.put("‏البحرين‎", "Bahrain");
		COUNTRY_TRANSLATE.put("‏الكويت‎", "Kuwait");
		COUNTRY_TRANSLATE.put("‏ایران‎", "Iran");
		COUNTRY_TRANSLATE.put("‏قطر‎", "Qatar");
		COUNTRY_TRANSLATE.put("‏پاکستان‎", "Pakistan");
		COUNTRY_TRANSLATE.put("中国", "China");
		COUNTRY_TRANSLATE.put("日本 (Japan)", "Japan");
		COUNTRY_TRANSLATE.put("日本", "Japan");
		COUNTRY_TRANSLATE.put("臺灣", "Taiwan");
		COUNTRY_TRANSLATE.put("대한민국", "South Korea");
	}
	
	public String getCountryTranslated(String value) {
		return COUNTRY_TRANSLATE.getOrDefault(value, value);
	}
	
	public static class CountryCode {
		public String countryName;
		public String isoCode2;
		public String isoCode3;
		public String isoCodeNumber;
		
		public CountryCode(String countryName, String isoCode2, String isoCode3, String isoCodeNumber) {
			this.countryName   = countryName;
			this.isoCode2      = isoCode2;
			this.isoCode3      = isoCode3;
			this.isoCodeNumber = isoCodeNumber;
		}
	}
	
	public static final java.util.HashMap<String, CountryCode> COUNTRY_CODE_BY_NAME = new java.util.HashMap<String,CountryCode>();
	static {
		COUNTRY_CODE_BY_NAME.put("Afghanistan", new CountryCode("Afghanistan","AF","AFG","004"));
		COUNTRY_CODE_BY_NAME.put("Aland Islands", new CountryCode("Aland Islands","AX","ALA","248"));
		COUNTRY_CODE_BY_NAME.put("Albania", new CountryCode("Albania","AL","ALB","008"));
		COUNTRY_CODE_BY_NAME.put("Algeria", new CountryCode("Algeria","DZ","DZA","012"));
		COUNTRY_CODE_BY_NAME.put("American Samoa", new CountryCode("American Samoa","AS","ASM","016"));
		COUNTRY_CODE_BY_NAME.put("Andorra", new CountryCode("Andorra","AD","AND","020"));
		COUNTRY_CODE_BY_NAME.put("Angola", new CountryCode("Angola","AO","AGO","024"));
		COUNTRY_CODE_BY_NAME.put("Anguilla", new CountryCode("Anguilla","AI","AIA","660"));
		COUNTRY_CODE_BY_NAME.put("Antarctica", new CountryCode("Antarctica","AQ","ATA","010"));
		COUNTRY_CODE_BY_NAME.put("Antigua and Barbuda", new CountryCode("Antigua and Barbuda","AG","ATG","028"));
		COUNTRY_CODE_BY_NAME.put("Argentina", new CountryCode("Argentina","AR","ARG","032"));
		COUNTRY_CODE_BY_NAME.put("Armenia", new CountryCode("Armenia","AM","ARM","051"));
		COUNTRY_CODE_BY_NAME.put("Aruba", new CountryCode("Aruba","AW","ABW","533"));
		COUNTRY_CODE_BY_NAME.put("Australia", new CountryCode("Australia","AU","AUS","036"));
		COUNTRY_CODE_BY_NAME.put("Austria", new CountryCode("Austria","AT","AUT","040"));	
		COUNTRY_CODE_BY_NAME.put("Azerbaijan", new CountryCode("Azerbaijan","AZ","AZE","031"));
		COUNTRY_CODE_BY_NAME.put("Bahamas", new CountryCode("Bahamas","BS","BHS","044"));
		COUNTRY_CODE_BY_NAME.put("Bahrain", new CountryCode("Bahrain","BH","BHR","048"));
		COUNTRY_CODE_BY_NAME.put("Bangladesh", new CountryCode("Bangladesh","BD","BGD","050"));
		COUNTRY_CODE_BY_NAME.put("Barbados", new CountryCode("Barbados","BB","BRB","052"));
		COUNTRY_CODE_BY_NAME.put("Belarus", new CountryCode("Belarus","BY","BLR","112"));
		COUNTRY_CODE_BY_NAME.put("Belgium", new CountryCode("Belgium","BE","BEL","056"));
		COUNTRY_CODE_BY_NAME.put("Belize", new CountryCode("Belize","BZ","BLZ","084"));
		COUNTRY_CODE_BY_NAME.put("Benin", new CountryCode("Benin","BJ","BEN","204"));
		COUNTRY_CODE_BY_NAME.put("Bermuda", new CountryCode("Bermuda","BM","BMU","060"));
		COUNTRY_CODE_BY_NAME.put("Bhutan", new CountryCode("Bhutan","BT","BTN","064"));
		COUNTRY_CODE_BY_NAME.put("Bolivia", new CountryCode("Bolivia","BO","BOL","068"));
		COUNTRY_CODE_BY_NAME.put("Bosnia and Herzegovina", new CountryCode("Bosnia and Herzegovina","BA","BIH","070"));
		COUNTRY_CODE_BY_NAME.put("Botswana", new CountryCode("Botswana","BW","BWA","072"));
		COUNTRY_CODE_BY_NAME.put("Bouvet Island", new CountryCode("Bouvet Island","BV","BVT","074"));
		COUNTRY_CODE_BY_NAME.put("Brazil", new CountryCode("Brazil","BR","BRA","076"));
		COUNTRY_CODE_BY_NAME.put("British Virgin Islands", new CountryCode("British Virgin Islands","VG","VGB","092"));
		COUNTRY_CODE_BY_NAME.put("British Indian Ocean Territory", new CountryCode("British Indian Ocean Territory","IO","IOT","086"));
		COUNTRY_CODE_BY_NAME.put("Brunei Darussalam", new CountryCode("Brunei Darussalam","BN","BRN","096"));
		COUNTRY_CODE_BY_NAME.put("Bulgaria", new CountryCode("Bulgaria","BG","BGR","100"));
		COUNTRY_CODE_BY_NAME.put("Burkina Faso", new CountryCode("Burkina Faso","BF","BFA","854"));
		COUNTRY_CODE_BY_NAME.put("Burundi", new CountryCode("Burundi","BI","BDI","108"));
		COUNTRY_CODE_BY_NAME.put("Cambodia", new CountryCode("Cambodia","KH","KHM","116"));
		COUNTRY_CODE_BY_NAME.put("Cameroon", new CountryCode("Cameroon","CM","CMR","120"));
		COUNTRY_CODE_BY_NAME.put("Canada", new CountryCode("Canada","CA","CAN","124"));
		COUNTRY_CODE_BY_NAME.put("Cape Verde", new CountryCode("Cape Verde","CV","CPV","132"));
		COUNTRY_CODE_BY_NAME.put("Cayman Islands", new CountryCode("Cayman Islands","KY","CYM","136"));
		COUNTRY_CODE_BY_NAME.put("Central African Republic", new CountryCode("Central African Republic","CF","CAF","140"));
		COUNTRY_CODE_BY_NAME.put("Chad", new CountryCode("Chad","TD","TCD","148"));
		COUNTRY_CODE_BY_NAME.put("Chile", new CountryCode("Chile","CL","CHL","152"));
		COUNTRY_CODE_BY_NAME.put("China", new CountryCode("China","CN","CHN","156"));
		COUNTRY_CODE_BY_NAME.put("Hong Kong, SAR China", new CountryCode("Hong Kong, SAR China","HK","HKG","344"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Macao, SAR China","MO","MAC","446"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Christmas Island","CX","CXR","162"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Cocos (Keeling) Islands","CC","CCK","166"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Colombia","CO","COL","170"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Comoros","KM","COM","174"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Congo (Brazzaville)","CG","COG","178"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Congo, (Kinshasa)","CD","COD","180"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Cook Islands","CK","COK","184"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Costa Rica","CR","CRI","188"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Côte d'Ivoire","CI","CIV","384"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Croatia","HR","HRV","191"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Cuba","CU","CUB","192"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Cyprus","CY","CYP","196"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Czech Republic","CZ","CZE","203"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Denmark","DK","DNK","208"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Djibouti","DJ","DJI","262"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Dominica","DM","DMA","212"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Dominican Republic","DO","DOM","214"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Ecuador","EC","ECU","218"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Egypt","EG","EGY","818"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("El Salvador","SV","SLV","222"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Equatorial Guinea","GQ","GNQ","226"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Eritrea","ER","ERI","232"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Estonia","EE","EST","233"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Ethiopia","ET","ETH","231"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Falkland Islands (Malvinas)","FK","FLK","238"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Faroe Islands","FO","FRO","234"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Fiji","FJ","FJI","242"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Finland","FI","FIN","246"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("France","FR","FRA","250"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("French Guiana","GF","GUF","254"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("French Polynesia","PF","PYF","258"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("French Southern Territories","TF","ATF","260"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Gabon","GA","GAB","266"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Gambia","GM","GMB","270"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Georgia","GE","GEO","268"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Germany","DE","DEU","276"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Ghana","GH","GHA","288"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Gibraltar","GI","GIB","292"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Greece","GR","GRC","300"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Greenland","GL","GRL","304"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Grenada","GD","GRD","308"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Guadeloupe","GP","GLP","312"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Guam","GU","GUM","316"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Guatemala","GT","GTM","320"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Guernsey","GG","GGY","831"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Guinea","GN","GIN","324"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Guinea-Bissau","GW","GNB","624"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Guyana","GY","GUY","328"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Haiti","HT","HTI","332"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Heard and Mcdonald Islands","HM","HMD","334"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Holy See (Vatican City State)","VA","VAT","336"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Honduras","HN","HND","340"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Hungary","HU","HUN","348"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Iceland","IS","ISL","352"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("India","IN","IND","356"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Indonesia","ID","IDN","360"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Iran, Islamic Republic of","IR","IRN","364"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Iraq","IQ","IRQ","368"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Ireland","IE","IRL","372"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Isle of Man","IM","IMN","833"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Israel","IL","ISR","376"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Italy","IT","ITA","380"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Jamaica","JM","JAM","388"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Japan","JP","JPN","392"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Jersey","JE","JEY","832"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Jordan","JO","JOR","400"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Kazakhstan","KZ","KAZ","398"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Kenya","KE","KEN","404"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Kiribati","KI","KIR","296"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Korea (North)","KP","PRK","408"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Korea (South)","KR","KOR","410"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Kuwait","KW","KWT","414"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Kyrgyzstan","KG","KGZ","417"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Lao PDR","LA","LAO","418"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Latvia","LV","LVA","428"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Lebanon","LB","LBN","422"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Lesotho","LS","LSO","426"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Liberia","LR","LBR","430"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Libya","LY","LBY","434"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Liechtenstein","LI","LIE","438"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Lithuania","LT","LTU","440"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Luxembourg","LU","LUX","442"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Macedonia, Republic of","MK","MKD","807"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Madagascar","MG","MDG","450"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Malawi","MW","MWI","454"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Malaysia","MY","MYS","458"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Maldives","MV","MDV","462"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Mali","ML","MLI","466"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Malta","MT","MLT","470"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Marshall Islands","MH","MHL","584"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Martinique","MQ","MTQ","474"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Mauritania","MR","MRT","478"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Mauritius","MU","MUS","480"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Mayotte","YT","MYT","175"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Mexico","MX","MEX","484"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Micronesia, Federated States of","FM","FSM","583"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Moldova","MD","MDA","498"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Monaco","MC","MCO","492"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Mongolia","MN","MNG","496"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Montenegro","ME","MNE","499"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Montserrat","MS","MSR","500"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Morocco","MA","MAR","504"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Mozambique","MZ","MOZ","508"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Myanmar","MM","MMR","104"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Namibia","NA","NAM","516"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Nauru","NR","NRU","520"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Nepal","NP","NPL","524"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Netherlands","NL","NLD","528"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Netherlands Antilles","AN","ANT","530"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("New Caledonia","NC","NCL","540"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("New Zealand","NZ","NZL","554"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Nicaragua","NI","NIC","558"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Niger","NE","NER","562"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Nigeria","NG","NGA","566"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Niue","NU","NIU","570"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Norfolk Island","NF","NFK","574"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Northern Mariana Islands","MP","MNP","580"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Norway","NO","NOR","578"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Oman","OM","OMN","512"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Pakistan","PK","PAK","586"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Palau","PW","PLW","585"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Palestinian Territory","PS","PSE","275"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Panama","PA","PAN","591"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Papua New Guinea","PG","PNG","598"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Paraguay","PY","PRY","600"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Peru","PE","PER","604"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Philippines","PH","PHL","608"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Pitcairn","PN","PCN","612"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Poland","PL","POL","616"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Portugal","PT","PRT","620"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Puerto Rico","PR","PRI","630"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Qatar","QA","QAT","634"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Réunion","RE","REU","638"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Romania","RO","ROU","642"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Russian Federation","RU","RUS","643"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Rwanda","RW","RWA","646"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Saint-Barthélemy","BL","BLM","652"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Saint Helena","SH","SHN","654"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Saint Kitts and Nevis","KN","KNA","659"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Saint Lucia","LC","LCA","662"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Saint-Martin (French part)","MF","MAF","663"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Saint Pierre and Miquelon","PM","SPM","666"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Saint Vincent and Grenadines","VC","VCT","670"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Samoa","WS","WSM","882"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("San Marino","SM","SMR","674"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Sao Tome and Principe","ST","STP","678"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Saudi Arabia","SA","SAU","682"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Senegal","SN","SEN","686"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Serbia","RS","SRB","688"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Seychelles","SC","SYC","690"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Sierra Leone","SL","SLE","694"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Singapore","SG","SGP","702"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Slovakia","SK","SVK","703"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Slovenia","SI","SVN","705"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Solomon Islands","SB","SLB","090"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Somalia","SO","SOM","706"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("South Africa","ZA","ZAF","710"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("South Georgia and the South Sandwich Islands","GS","SGS","239"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("South Sudan","SS","SSD","728"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Spain","ES","ESP","724"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Sri Lanka","LK","LKA","144"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Sudan","SD","SDN","736"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Suriname","SR","SUR","740"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Svalbard and Jan Mayen Islands","SJ","SJM","744"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Swaziland","SZ","SWZ","748"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Sweden","SE","SWE","752"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Switzerland","CH","CHE","756"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Syrian Arab Republic (Syria)","SY","SYR","760"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Taiwan, Republic of China","TW","TWN","158"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Tajikistan","TJ","TJK","762"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Tanzania, United Republic of","TZ","TZA","834"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Thailand","TH","THA","764"));
		COUNTRY_CODE_BY_NAME.put("", new CountryCode("Timor-Leste","TL","TLS","626"));
		COUNTRY_CODE_BY_NAME.put("Togo", new CountryCode("Togo","TG","TGO","768"));
		COUNTRY_CODE_BY_NAME.put("Tokelau", new CountryCode("Tokelau","TK","TKL","772"));
		COUNTRY_CODE_BY_NAME.put("Tonga", new CountryCode("Tonga","TO","TON","776"));
		COUNTRY_CODE_BY_NAME.put("Trinidad and Tobago", new CountryCode("Trinidad and Tobago","TT","TTO","780"));
		COUNTRY_CODE_BY_NAME.put("Tunisia", new CountryCode("Tunisia","TN","TUN","788"));
		COUNTRY_CODE_BY_NAME.put("Turkey", new CountryCode("Turkey","TR","TUR","792"));
		COUNTRY_CODE_BY_NAME.put("Turkmenistan", new CountryCode("Turkmenistan","TM","TKM","795"));
		COUNTRY_CODE_BY_NAME.put("Turks and Caicos Islands", new CountryCode("Turks and Caicos Islands","TC","TCA","796"));
		COUNTRY_CODE_BY_NAME.put("Tuvalu", new CountryCode("Tuvalu","TV","TUV","798"));
		COUNTRY_CODE_BY_NAME.put("Uganda", new CountryCode("Uganda","UG","UGA","800"));
		COUNTRY_CODE_BY_NAME.put("Ukraine", new CountryCode("Ukraine","UA","UKR","804"));
		COUNTRY_CODE_BY_NAME.put("United Arab Emirates", new CountryCode("United Arab Emirates","AE","ARE","784"));
		COUNTRY_CODE_BY_NAME.put("United Kingdom", new CountryCode("United Kingdom","GB","GBR","826"));
		COUNTRY_CODE_BY_NAME.put("United States of America", new CountryCode("United States of America","US","USA","840"));
		COUNTRY_CODE_BY_NAME.put("US Minor Outlying Islands", new CountryCode("US Minor Outlying Islands","UM","UMI","581"));
		COUNTRY_CODE_BY_NAME.put("Uruguay", new CountryCode("Uruguay","UY","URY","858"));
		COUNTRY_CODE_BY_NAME.put("Uzbekistan", new CountryCode("Uzbekistan","UZ","UZB","860"));
		COUNTRY_CODE_BY_NAME.put("Vanuatu", new CountryCode("Vanuatu","VU","VUT","548"));
		COUNTRY_CODE_BY_NAME.put("Venezuela", new CountryCode("Venezuela (Bolivarian Republic)","VE","VEN","862"));
		COUNTRY_CODE_BY_NAME.put("Viet Nam", new CountryCode("Viet Nam","VN","VNM","704"));
		COUNTRY_CODE_BY_NAME.put("Virgin Islands, US", new CountryCode("Virgin Islands, US","VI","VIR","850"));
		COUNTRY_CODE_BY_NAME.put("Wallis and Futuna Islands", new CountryCode("Wallis and Futuna Islands","WF","WLF","876"));
		COUNTRY_CODE_BY_NAME.put("Western Sahara", new CountryCode("Western Sahara","EH","ESH","732"));
		COUNTRY_CODE_BY_NAME.put("Yemen", new CountryCode("Yemen","YE","YEM","887"));
		COUNTRY_CODE_BY_NAME.put("Zambia", new CountryCode("Zambia","ZM","ZMB","894"));
		COUNTRY_CODE_BY_NAME.put("Zimbabwe", new CountryCode("Zimbabwe","ZW","ZWE","716"));
	}
	
	
}
