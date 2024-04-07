### Authors: Brian Anderson, Kjellden Knutzen, Nazanal Laughlin, Jessica Vargas, Bryan Welton

# Introduction

This guide contains instructions for how to install an ApacheSpark database onto
an Ubuntu server. It presupposes that:

- You have a functional, running Ubuntu server
- You have root access on said server

# Part 1: Dependencies

Apache spark relies on both Java and Python to run. Because of this, we must
ensure both are installed on the server.

## Maven

Maven is a build tool that both the backend and database have been configured to
use for building their respective Java output Jars. To install maven follow
these steps:

1. Visit the site [Maven installation](https://maven.apache.org/install.html) to
   view the installation instructions.
2. Download the compiled binary archive from
   [Maven download](https://maven.apache.org/download.cgi)
3. Unpack the compiled archive using your decompression algorithm of choice.
4. Add the location of the bin/ folder inside the unpacked directory to your
   system's $PATH variable.
5. A successful installation can be tested by calling `mvn` in a terminal and
   viewing the "help" output.

Maven has many useful tools for testing and building code. The following are a
list of commands that we have found to be useful:

1. Compile code `mvn compile`
2. Build the code without running tests to package as Java jar files
   `mvn clean install -DskipTests`
3. Build the code and run tests `mvn clean install`

## Java

The reccommended java version for working with Apache Spark is JDK8, however as
the rest of the project has been set up to run with JDK 21 we'll be setting up
Spark to run on JDK 21 using some modifications from the standard install and
run procedure. Run the following command to install JDK21 on the server:
`sudo apt-get -y install openjdk-21-jdk-headless`

You can confirm that java is installed properly afterwords by running:
`java -version`

You can run a Jar that uses Spark with the following command in Java 21:
`java --add-opens java.base/sun.nio.ch=ALL-UNNAMED -jar target/Database-1.0-SNAPSHOT-jar-with-dependencies.jar`

## Python

The recommended python version for working with ApacheSpark is Python3. Run the
following command to install Python3 on the server: `sudo apt install python3`

You can confirm that python is installed properly afterwords by running:
`python3 --version`

# Part 2: Installing Spark

Now that all of the dependencies are in place, we can begin our Spark install.

1. Open
   [the apache spark downloads page](https://spark.apache.org/downloads.html)
   (https://spark.apache.org/downloads.html)
2. Ensure that, on the page, the first dropdown next to "Choose a spark release"
   has 3.5.0 selected
3. Ensure that, on the page, the second dropdown next to "Choose a package type"
   has "Pre-built for Apache Hardoop 3.3 and later" selected
4. Right click on the link listed next to "Download Spark" and copy it (At the
   time of writing, this link is
   https://www.apache.org/dyn/closer.lua/spark/spark-3.5.0/spark-3.5.0-bin-hadoop3.tgz).
5. Run the following command in your server to download Apache Spark:
   `wget {link}`
6. Once the file is downloaded, unzip it using the tar command:
   `tar -xzf spark-3.5.0-bin-hadoop3.tgz`
7. Once it is untar-ed, rename it to spark for easier access:
   `mv spark-3.5.0-bin-hadoop3 spark`

Apache spark should now be installed.

# Part 3: Installing Android Studio

## System Requirements

Ensure that your system meets the following requirements before installing
Android Studio:

- **Operating System:** Windows, macOS, or Linux
- **RAM:** 8 GB or higher
- **Disk Space:** 4 GB minimum (SSD recommended)
- **Java Development Kit (JDK):** Version 8 or later

## Installation Steps

### Step 1: Download Android Studio

Visit the
[official Android Studio download page](https://developer.android.com/studio)
and download the latest version for your operating system.

### Step 2: Install Java Development Kit (JDK)

Android Studio requires JDK to be installed. Download and install the
[Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
if you haven't already.

### Step 3: Install Android Studio

#### For Windows:

1. Run the downloaded installer (`.exe`).
2. Follow the on-screen instructions to complete the installation.
3. Launch Android Studio after installation.

#### For macOS:

1. Open the downloaded `.dmg` file.
2. Drag and drop Android Studio into the "Applications" folder.
3. Launch Android Studio from the "Applications" folder.

#### For Linux:

1. Extract the downloaded archive to a location of your choice.
2. Open a terminal and navigate to the extracted directory.
3. Run `./studio.sh` to launch Android Studio.

### Step 4: Set up Android Studio

1. On the welcome screen, click on "Configure" and select "SDK Manager."
2. Install the necessary Android SDK components and tools for your development
   needs.
3. Click on "Configure" again and select "AVD Manager" to create Android Virtual
   Devices for testing.

### Step 5: Configure Emulator (Optional)

If you plan to use the Android Emulator, ensure hardware acceleration (Intel
HAXM or AMD SVM) is enabled on your system.

# Part 4: Installing Ubuntu Server with AWS

### Prerequisites:

- An AWS account with active billing.
- An SSH client like PuTTY or MobaXterm.

### Steps:

1. Launch an EC2 Instance:

1. Go to the AWS Management Console and navigate to the EC2 service.
1. Click on "Launch Instance".
1. Choose an Ubuntu AMI (Amazon Machine Image). We recommend Ubuntu Server 22.04
   LTS.
1. Select an instance type based on your requirements. t2.micro is a good option
   for beginners.
1. Configure storage. 8 GB EBS volume is sufficient for most basic setups.
1. In the "Configure Instance Details" step, under "Security Group", ensure
   ports 22 (SSH), 80 (HTTP), and 443 (HTTPS) are open for inbound traffic. You
   can create a new security group for this purpose.
1. Add tags for better organization (optional).
1. Click "Launch" and wait for the instance to launch.
1. Connect to the Instance:

1. Once the instance is running, go to the "Instances" tab and note the public
   IP address of your instance.
1. Open your SSH client and establish a connection to the instance using the
   following command:

`ssh -i your_key_pair.pem ubuntu@public_ip_address`

Replace `your_key_pair.pem` with the path to your key pair file downloaded while
launching the instance.

3. Update and Upgrade the System:

`sudo apt update && sudo apt upgrade -y`

4. Install Apache Web Server:

`sudo apt install apache2 -y`

5. Verify Apache Installation:

Open your web browser and visit your instance's public IP address
(http://public_ip_address). If Apache is installed correctly, you should see the
default Apache welcome page.

6. Install Node.js and npm:

We recommend using the Node Version Manager (nvm) to manage multiple Node.js
versions easily.

`curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.5/install.sh | bash`

`source ~/.bashrc`

Install the desired Node.js version:

`nvm install 18.12.1 (or any other desired version)`

Verify the installation:

`node -v`

`npm -v`

7. Secure Your Server:

- Set a strong password for the ubuntu user.
- Consider using a firewall like UFW to restrict incoming traffic.
- Keep your system and software updated.
