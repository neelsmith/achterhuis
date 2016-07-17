/*
Parses source text of Anne Frank document, and creates a tab-delimited file with
two columns:

1. a CTS URN for the passage
2. the text contents of the passage


*/


String urnNameSpace = "aflibre"
String workGroupId = "af" // Anne Frank
String workId = "ah" // Achterhuis
String version = "hc" // College of the Holy Cross
String urnBase = "urn:cts:${urnNameSpace}:${urnNameSpace}.${workId}.${version}:"

File f = new File(args[0])
def mnthCountHash = ["Januari":"01", "Februari": "02", "Maart": "03",
		     "April": "04", "Mei": "05", "Juni": "06",
		     "Juli": "07", "Augustus": "08",  "September" : "09",
		     "October": "10", "November": "11", "December": "12"]



String currDate = ""
def pCount = 0
def matchCount = 0
f.eachLine { l ->
  def datematcher =  l =~ "(Maandag|Dinsdag|Woensdag|Donderdag|Vrijdag|Zaterdag|Zondag),+[ ]+([0-9]+)[ ]+([a-zA-Z]+)[ ]+(194[234])(.*)"
  if (datematcher.getCount()) {
    matchCount++;
    pCount = 0
    datematcher.each { mtch, weekday,modate,mth,yr, rmdr ->
      if (modate.size() < 2) {
	modate = "0${modate}"
      }
      currDate = "${urnBase}${yr}${mnthCountHash[mth]}${modate}"
      println "${currDate}.h1\t${l}"
    }
  } else {
    if (l ==~ /\s+/) {
      
    } else {
      pCount++;
      println "${currDate}.p${pCount}\t${l}"
    }
  }
}
System.err.println "Total diary entries identified: " + matchCount