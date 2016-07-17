/*
Parses source text of Anne Frank document, and writes to standard out
a tab-delimited file with two columns:

1. a CTS URN for the passage
2. the text contents of the passage

Usage, from root of this repository: 

    groovy scripts/ahparser.groovy srctext/achterhuis.txt

*/


// for error checking: count total number of daily diary entries:
def expectedTotal = 165
def matchCount = 0

// read input from a file named on command line
File f = new File(args[0])


String urnNameSpace = "aflibre" // full URI == http://neelsmith.github.io/aflibre
String workGroupId = "af" // Anne Frank
String workId = "ah" // Achterhuis
String version = "hc" // College of the Holy Cross
String urnBase = "urn:cts:${urnNameSpace}:${urnNameSpace}.${workId}.${version}:"


// map dutch month names to 2-char digit strings
def mnthCountHash = [
  "Januari":"01", "Februari": "02", "Maart": "03",
  "April": "04", "Mei": "05", "Juni": "06",
  "Juli": "07", "Augustus": "08",  "September" : "09",
  "October": "10", "November": "11", "December": "12"
]

// current value of 8-char string for date
String currDate = ""
// current count of paragraph units in entry
def pCount = 0
f.eachLine { l ->
  def datematcher =  l =~ "(Maandag|Dinsdag|Woensdag|Donderdag|Vrijdag|Zaterdag|Zondag),+[ ]+([0-9]+)[ ]+([a-zA-Z]+)[ ]+(194[234])(.*)"
  if (datematcher.getCount()) {
    matchCount++;
    pCount = 0
    datematcher.each { wholematch, weekday, modate, mth, yr, remains ->
      if (modate.size() < 2) {
	modate = "0${modate}"
      }
      currDate = "${urnBase}${yr}${mnthCountHash[mth]}${modate}"
      println "${currDate}.h1\t${l}"
    }
  } else {
    if (l ==~ /\s+/) {
      // skip blank or white-space-only lines
    } else {
      pCount++;
      println "${currDate}.p${pCount}\t${l}"
    }
  }
}
System.err.println "Total diary entries identified: " + matchCount
assert matchCount == expectedTotal
