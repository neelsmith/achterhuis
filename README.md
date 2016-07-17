# achterhuis

Creating a citable version of Anne Frank's diary, *Het Achterhuis*.

This repository includes a copy of the public-domain text downloaded from <http://affordance.typepad.com//files/anne-frank.txt>, with POSIX newlines separating chunks of text.  This source text is parsed by a simple script written in groovy that assigns each non-empty line of the text a CTS URN.

## Citation scheme

The citable text's CTS URNs are constructed as follows.

### Bibliographic hierarchy

The CTS namespace is abbreviated `aflibre`.  The full URI for this namespace is `http://neelsmith.github.io/aflibre`.

The text group identifier `af` identifies "works by Anne Frank", and the work identifier `ah` identifiers *Het Achterhuis*.  The version identifier `hc` identifies this citable digital version from the College of the Holy Cross.

### Passage hierarchy

The diary is organized in a two-tier citation scheme.  The top level of the scheme is a single day's diary entry.  As a convenience for chronological manipulation or analysis of entries, this value is an eight-character string giving year, month and day in the form "YYYYMMDD".

Within each entry, there are numbered sections.  Each "heading" section giving the entry's date is identified as `h1`.  Subsequent paragraphs are identified with strings that look like `p1`, `p2` or `p12`.

Examples: the first citable chunk of text in the work has the URN `urn:cts:aflibre:af.ah.hc:19420614.h1`.  Its text content is

>Zondag, 14 Juni 1942

The following passage has the URN `urn:cts:aflibre:af.ah.hc:19420614.p1`.  Its text content is

>Vrijdag 12 Juni was ik al om 6 uur wakker en dat is heel begrijpelijk, daar ik jarig was. Maar om 6 uur mocht ik toch nog niet opstaan, dus moest ik mijn nieuwsgierigheid bedwingen tot kwart voor zeven. Toen ging het niet langer, ik ging naar de eetkamer, waar ik door Moortje (de kat) met kopjes verwelkomd werd.


## Some pre-formatted files

In the `srctext` directory:


- `achterhuis.txt` is the text downloaded from <http://affordance.typepad.com//files/anne-frank.txt>
- `achterhuis.tsv` is a two-column file delimited by tabs, giving the CTS URN and the text contents of each citable node, in document order.  (This is the output of `ahparser.groovy` using tab characters for delimiters.)
- `achterhuis82XF.tsv` is the equivalent file in 82XF format.  Citable texts in 82XF format explicitly express the position of a node in the document sequence.  They can therefore be used in environments like relationa databases withouting having to maintain the ordering implicit in the sequence of lines in`achterhuis.tsv`.
