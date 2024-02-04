# Introduction
This guide contains instructions for how to install an ApacheSpark database onto an Ubuntu server.
It presupposes that:
* You have a functional, running Ubuntu server
* You have root access on said server

# Part 1: Dependencies
Apache spark relies on both Java and Python to run. Because of this, we must ensure both are installed on the server.

## Java
The reccommended java version for working with ApacheSpark is JDK8. Run the following command to install JDK8 on the server:
`sudo apt-get -y install openjdk-8-jdk-headless`

You can confirm that java is installed properly afterwords by running:
`java -version`

## Python
The reccommended python version for working with ApacheSpark is Python3. Run the following command to install Python3 on the server:
`sudo apt install python3`

You can confirm that python is installed properly afterwords by running:
`python3 --version`

# Part 2: Installing Apache
Now that all of the dependencies are in place, we can begin our Apache install.
1. Open [the apache spark downloads page](https://spark.apache.org/downloads.html) (https://spark.apache.org/downloads.html)
2. Ensure that, on the page, the first dropdown next to "Choose a spark release" has 3.5.0 selected
3. Ensure that, on the page, the second dropdown next to "Choose a package type" has "Pre-built for Apache Hardoop 3.3 and later" selected
4. Right click on the link listed next to "Download Spark" and copy it (At the time of writing, this link is https://www.apache.org/dyn/closer.lua/spark/spark-3.5.0/spark-3.5.0-bin-hadoop3.tgz).
5. Run the following command in your server to download Apache Spark: `wget {link}`
6. Once the file is downloaded, unzip it using the tar command: `tar -xzf spark-3.5.0-bin-hadoop3.tgz`
7. Once it is untar-ed, rename it to spark for easier access: `mv spark-3.5.0-bin-hadoop3 spark`
   
Apache spark should now be installed.
