# Receiver Test
This is an example taken from the week 5 lecture slides.

### What this does
The Receiver Adapter in JGroups allows for *non blocking* (passive) communication. In this example's case, the sender simply sends off the messages to the memebers of the channel and doesn't require any form of response to continue in its own program.

### Build Tool
This example uses Apache Ant to build. How this happens can be seen in the xml
file within the project.
Try running the command "ant run" to compile and run example.
"ant clean" will remove the compiled files.
