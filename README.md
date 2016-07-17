# achterhuis

Creating a citable version of Anne Frank's diary, *Het Achterhuis*.

This repository includes a copy of the public-domain text downloaded from <http://affordance.typepad.com//files/anne-frank.txt>, using POSIX newlines to separate chunks of text.  This source text is parsed by a simple script written in groovy that assigns each non-empty line of the text a CTS URN.

## Citation scheme

The citable text's CTS URNs are constructed as follows.

### Bibliographic hierarchy

The CTS namespace is abbreviated `aflibre`.  The full URI for this namespace is `http://neelsmith.github.io/aflibre`.

The text group identifier `af` identifies "works by Anne Frank", and the work identifier `ah` identifiers *Het Achterhuis*.  The version identifier `hc` identifies this citable digital version from the College of the Holy Cross.

### Passage hierarchy

The diary is organized in a two-tier citation scheme.  The top level of the scheme is a single day's diary entry.  As a convenience for chronological manipulation or analysis of entries, this value is an eight-character string giving year, month and day in the form "YYYYMMDD".

Within each entry, there are numbered sections.  Each "heading" section giving the entry's date is identified as `h1`.  Subsequent paragraphs are identified with strings that look like `p1`, `p2` or `p12`.

Examples: the first URN in the work is `urn:cts:aflibre:aflibre.ah.hc:19420614.h1`.  Its text content is

>Zondag, 14 Juni 1942

The following passage has the URN `urn:cts:aflibre:aflibre.ah.hc:19420614.p1`.  Its text content is

>Vrijdag 12 Juni was ik al om 6 uur wakker en dat is heel begrijpelijk, daar ik jarig was. Maar om 6 uur mocht ik toch nog niet opstaan, dus moest ik mijn nieuwsgierigheid bedwingen tot kwart voor zeven. Toen ging het niet langer, ik ging naar de eetkamer, waar ik door Moortje (de kat) met kopjes verwelkomd werd.
