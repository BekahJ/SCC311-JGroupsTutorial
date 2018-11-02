# JGroups Tutorial
## SCC311: Distributed Systems

### Introduction
As part of the Distributed Systems coursework, you are expected to make an active replication system for your RMI auction system. Although JGroups 3.x has a full JavaDoc (see link below), this simply displays the public methods and their required parameters. This repo contains some JGroups examples and offers some explanation as to how to use some of the methods outlined in the JavaDoc. This should follow along quite well with the Week5 JGroups lecture.

### JavaDoc
http://www.jgroups.org/javadoc/index.html

### Tips
If you're a OSX or Linux user, these tips are more for you than Windows users. I might add some stuff for Windows users here too at a later date though.
#### Setting the Classpath for JGroups
 - Windows:  set CLASSPATH=%CLASSPATH%;<Enter path of jgroups.jar>;.
   - e.g. set CLASSPATH=%CLASSPATH%;H:\SCC311-AuctionSystem\jgroups-3.6.14.Final.jar;.
 - Linux/OSX:  export CLASSPATH=$CLASSPATH:<Enter path of jgroups.jar>
   - e.g. export CLASSPATH=$CLASSPATH:/home/genericusername/SCC311-AuctionSystem/jgroups-3.6.14.Final.jar
#### Helpful Tools
As this coursework may involve a few terminal windows being open at once, I recommend a terminal mutliplexer such as tmux for OSX or Linux. This allows you to run multiple terminal panes in a single window. There are plenty of tutorials and 'cheat sheets' for how to install and use tmux online :)
Also, using scripts or build tools such as Apache Ant can be handy to automate your building process. I wont go into that in this tutorial as there are plenty of resouces for this on the vast majority of platforms. (But there are ant files with the source code as build.xml)

