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

  within that entry, there are numbered sections.  The "heading" section ks

Examples: the first URN in the work is `urn:cts:aflibre:aflibre.ah.hc:19420614.h1`       Zondag, 14 Juni 1942
urn:cts:aflibre:aflibre.ah.hc:19420614.p1

urn:cts:aflibre:aflibre.ah.hc:19420614.h1     
urn:cts:aflibre:aflibre.ah.hc:19420614.p1
