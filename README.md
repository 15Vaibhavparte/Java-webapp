Automated CI/CD Pipeline for a Java Web App
This repository contains all the necessary configurations and a sample Java web application to demonstrate a fully automated Continuous Integration/Continuous Deployment (CI/CD) pipeline. The project is designed to showcase the integration of several DevOps tools to build, test, and deploy an application automatically upon every code change.

1. Project Overview
This project automates the deployment of a simple Java web application using a CI/CD pipeline. The process is initiated by a code push to the GitHub repository, which triggers a Jenkins job. Jenkins then uses Maven to build the application into a .war file and deploys it to a Tomcat server running on an AWS EC2 instance. This workflow ensures a seamless and efficient software delivery process.

Technologies Used
Version Control: Git & GitHub

Build Tool: Apache Maven

CI/CD Server: Jenkins

Application Server: Apache Tomcat

Cloud Provider: AWS EC2

Remote Access: MobaXterm

2. Execution Sequence: A Step-by-Step Guide
This section details the entire process from setting up the infrastructure to running the automated pipeline.

Part 1: Initial Setup
Create an AWS EC2 Instance: Launch an EC2 instance to serve as the host for Jenkins and Tomcat.

SSH into the Instance: Connect to the EC2 instance securely using a tool like MobaXterm.

Install Essential Software:

Java (JDK 11): This is required for both Jenkins and the Java web application.

Git: To clone the project from the GitHub repository.

Jenkins: The core automation server.

Apache Tomcat: The web server where the application will be deployed.

Configure Tomcat Server:

Change Port: By default, both Jenkins and Tomcat run on port 8080. To avoid conflicts, configure Tomcat to run on a different port, such as 9090, by editing the server.xml file located in the conf folder.

Set up User Roles: Edit tomcat-users.xml to add a user with manager-script role. This is crucial for Jenkins to be able to deploy applications to Tomcat.

Part 2: Jenkins Configuration
Unlock and Set Up Jenkins: Access the Jenkins web interface via http://<EC2_Public_IP>:8080, unlock it using the initial administrator password, and install the suggested plugins.

Configure Global Tools: Navigate to Manage Jenkins -> Global Tool Configuration and set up the installation paths for JDK and Maven.

Install 'Deploy to Container' Plugin: From Manage Jenkins -> Manage Plugins, install the Deploy to container plugin. This plugin enables Jenkins to deploy artifacts to application servers like Tomcat.

Create a Jenkins Job:

Create a new freestyle job.

Provide the GitHub repository URL for the source code.

In the Build Steps, configure Jenkins to use Maven with the goals clean package to build the .war file.

In the Post-build Actions, configure the Deploy to container plugin to deploy the generated .war file to the Tomcat server on the EC2 instance.

Part 3: Automated Deployment
Trigger the Pipeline: After a code push to the GitHub repository, the Jenkins job will automatically be triggered.

Build and Deploy: Jenkins will pull the latest code, build it with Maven, and then deploy the .war file to the Tomcat server.

Verify Deployment: The web application will now be live and accessible at http://<EC2_Public_IP>:9090/webapp-name.

3. Key Features and Functionalities
Automated Builds: Maven automatically compiles the source code and packages it into a .war file.

Continuous Integration: Jenkins constantly monitors the GitHub repository for new commits and automatically triggers a new build.

Continuous Deployment: A successful build automatically deploys the new .war file to the Tomcat server without manual intervention.

Centralized Orchestration: Jenkins acts as the central hub, managing the entire workflow from code commit to deployment.

Infrastructure as a Service (IaaS): The pipeline leverages AWS EC2, demonstrating cloud-based deployment.

4. Instructions for Use
To replicate this project, follow the execution sequence detailed above. Ensure you have an AWS account and a GitHub repository for your Java web application. The sample application should be a basic Maven project structured to produce a .war file.

Important Note: Make sure to properly configure the security group for your EC2 instance in the AWS console to allow traffic on ports 22 (SSH), 8080 (Jenkins), and 9090 (Tomcat).

5. Visual Content
This project is best understood with visual aids. The following sections are dedicated to showcasing the pipeline in action.

Screenshots
Screenshots should be placed within the documentation to illustrate each key step of the setup and configuration process.

assets/screenshots/ec2_instance.png: Screenshot of the EC2 instance running in the AWS console.

assets/screenshots/tomcat_config.png: Screenshot showing the edited server.xml and tomcat-users.xml files.

assets/screenshots/jenkins_dashboard.png: Screenshot of the Jenkins dashboard after initial setup.

assets/screenshots/jenkins_job_config.png: Screenshots of the Jenkins job configuration pages (SCM, Build, Post-build Actions).

assets/screenshots/successful_build.png: Screenshot showing a successful Jenkins build in the build history.

assets/screenshots/deployed_webapp.png: Screenshot of the Java web application running live on the Tomcat server.

Video of Workflow
A short video or GIF demonstrating the end-to-end workflow is highly recommended.

assets/video/pipeline_demo.mp4 or assets/video/pipeline_demo.gif: A video or GIF showing a code change, a Git commit, and the final web application updating automatically in the browser after the Jenkins pipeline completes. This video should be referenced in the main project overview.
