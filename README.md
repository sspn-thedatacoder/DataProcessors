# DataProcessors
Simple processor building blocks for Hadoop/Spark


Built with Eclipse Neon  
1.)Download Hadoop 2.9 JARS (350 MB)  
2.)Go to Eclipse -->Project properties --->Libraries --->Add External JARS --->   
3.)Add all the JARS from hadoop/share/common (3 JARS)   
4.)Add all the JARS from hadoop/share/common/lib (Lot of JARS, more than 10)    
5.)That should be it, you should be able to run the project from Eclipse itself    


Additionally to play around with Hadoop  
Hadoop runs in local mode without any more configuration in v2.9, assuming you have JAVA installed and JAVA HOME Setup  
Currently using Java 1.8 SE.  


You can try out Hadoop commands from CLI  
./hadoop fs -ls (List files from the Hadoop File System)   
sudo ./hadoop fs -put \<Path to local file\> \<Path to destination\> (Copy a Local file to the Hadoop File system)   
sudo ./hadoop jar \<name of jar\>.jar \<Class containing main\> inputFile outputFile //or any other args    
bin/hadoop fs -text  inputFile // Displays a sequence file in text   




