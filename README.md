# StartDisplay
This is a program that will be initially used at running events. It has a digital clock and imports all competitors data from an XML. It displays the clock and these runners starting at the given time. The clock can be adjusted to run five minutes ahead, so that people know in advance that they are to start soon. 
To do: This program will be turned into a webApplication. The computer storing the XML will be a server  that will generate a link and everyone at the event will be able to get the link and check current time and current competitors sarting or add an offset and check 1,2,3,etc. minutes ahead.
This application can be modified to be used with, for example, doctor appointments. A display in front of the doctor's door can run it and show time and who is next.


File description:
Application if a JFrame that will hold clock panel and competitors panel.

ClockApplet is a Thread that displays current time in a stardard way hh:mm:ss, so that it matches with the time variable of each Competitor object, so that these can be compared.

Competitor is a single competitor object with name, time, team; all other related characteristics of a competitor and disregarded(gender, discipline,etc.)

CompetitorsStructure - not implemented but may be used as a data structure to store all Competitors.

Display - gets List of sorted competitors by time and currently displays first 10. Suppesed to display all with time = clock time.

NamesReader - imports an XML file with multiple competitors, saves them as Competitor objects with name, team, time assiciated. Sorts them by time.
