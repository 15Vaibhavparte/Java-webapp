# Automated CI/CD Pipeline for a Java Web App

This repository contains all the necessary configurations and a sample Java web application to demonstrate a fully automated Continuous Integration/Continuous Deployment (CI/CD) pipeline. The project is designed to showcase the integration of several DevOps tools to build, test, and deploy an application automatically upon every code change.

---

## 1. Project Overview

This project automates the deployment of a simple Java web application using a CI/CD pipeline.  
The process is initiated by a code push to the GitHub repository, which triggers a Jenkins job.  
Jenkins then uses Maven to build the application into a `.war` file and deploys it to a Tomcat server running on an AWS EC2 instance.  
This workflow ensures a seamless and efficient software delivery process.

**Technologies Used**
- **Version Control:** Git & GitHub
- **Build Tool:** Apache Maven
- **CI/CD Server:** Jenkins
- **Application Server:** Apache Tomcat
- **Cloud Provider:** AWS EC2
- **Remote Access:** MobaXterm

---

## 2. Execution Sequence: A Step-by-Step Guide

This section details the entire process from setting up the infrastructure to running the automated pipeline.

### **Part 1: Initial Setup**
1. **Create an AWS EC2 Instance**  
   Launch an EC2 instance to serve as the host for Jenkins and Tomcat.

2. **SSH into the Instance**  
   Connect to the EC2 instance securely using a tool like MobaXterm.

3. **Install Essential Software**
   - **Java (JDK 11):** Required for both Jenkins and the Java web application.
   - **Git:** To clone the project from the GitHub repository.
   - **Jenkins:** The core automation server.
   - **Apache Tomcat:** The web server where the application will be deployed.

4. **Configure Tomcat Server**
   - **Change Port:** Configure Tomcat to run on port **9090** by editing the `server.xml` file to avoid conflicts with Jenkins (which uses port 8080).
   - **Set up User Roles:** Edit `tomcat-users.xml` to add a user with the `manager-script` role, enabling Jenkins to deploy applications to Tomcat.

---

### **Part 2: Jenkins Configuration**
1. **Unlock and Set Up Jenkins**  
   Access the Jenkins web interface via `http://<EC2_Public_IP>:8080`, unlock it, and install the suggested plugins.

2. **Configure Global Tools**  
   Navigate to **Manage Jenkins → Global Tool Configuration** and set up the installation paths for JDK and Maven.

3. **Install 'Deploy to Container' Plugin**  
   Install this plugin to enable Jenkins to deploy artifacts to Tomcat.

4. **Create a Jenkins Job**
   - Create a new **freestyle job**.
   - Provide the **GitHub repository URL** for your source code.
   - In the **Build Steps**, configure Jenkins to use Maven with the goals:  
     ```bash
     clean package
     ```
   - In **Post-build Actions**, use the *Deploy to container* plugin to deploy the generated `.war` file to the Tomcat server on the EC2 instance.

---

### **Part 3: Automated Deployment**
1. **Trigger the Pipeline**  
   A code push to the GitHub repository will automatically trigger the Jenkins job.

2. **Build and Deploy**  
   Jenkins will pull the latest code, build it with Maven, and deploy the `.war` file to the Tomcat server.

3. **Verify Deployment**  
   The web application will be live at:  

---

## 3. Key Features and Functionalities
- **Automated Builds:** Maven automatically compiles the source code and packages it into a `.war` file.
- **Continuous Integration:** Jenkins constantly monitors the GitHub repository for new commits and automatically triggers a new build.
- **Continuous Deployment:** A successful build automatically deploys the new `.war` file to the Tomcat server without manual intervention.
- **Centralized Orchestration:** Jenkins acts as the central hub, managing the entire workflow.
- **Infrastructure as a Service (IaaS):** The pipeline leverages AWS EC2, demonstrating cloud-based deployment.

---

## 4. Instructions for Use
To replicate this project:
1. Follow the execution sequence detailed above.
2. Ensure you have:
- An **AWS account**
- A **GitHub repository** for your Java web application.
3. The sample application should be a **basic Maven project** structured to produce a `.war` file.

> **Important:** Configure the security group for your EC2 instance in the AWS console to allow traffic on:
> - **Port 22** (SSH)
> - **Port 8080** (Jenkins)
> - **Port 9090** (Tomcat)

---

## 5. Visual Content

### **Screenshots**
- `assets/screenshots/ec2_instance.png` – EC2 instance running in AWS console.
- <img width="1860" height="924" alt="Screenshot 2025-08-11 120602" src="https://github.com/user-attachments/assets/97dd1741-9f01-4cd7-accb-b3ab4db73c1b" />
- `assets/screenshots/tomcat_config.png` – Edited `server.xml`,`tomcat-users.xml` and `context.xml` files.
- <img width="1248" height="686" alt="Screenshot 2025-08-12 131323" src="https://github.com/user-attachments/assets/d2fc20de-e514-4fc4-9bef-cfc9caed3529" />
- <img width="1227" height="559" alt="Screenshot 2025-08-12 131028" src="https://github.com/user-attachments/assets/9ea3d323-d362-47b2-bfea-7082e96d3236" />
- <img width="1197" height="685" alt="Screenshot 2025-08-12 131445" src="https://github.com/user-attachments/assets/f66809c6-11d7-4faf-acab-c8d18bd139d1" />

- `assets/screenshots/jenkins_dashboard.png` – Jenkins dashboard after setup.
- <img width="1811" height="1028" alt="Screenshot 2025-08-12 205750" src="https://github.com/user-attachments/assets/76e423d0-5f4e-494c-8b89-d1c4e2c42d26" />
- `assets/screenshots/jenkins_job_config.png` – Jenkins job configuration pages (SCM, Build, Post-build Actions).
- <img width="1779" height="1025" alt="Screenshot 2025-08-12 210028" src="https://github.com/user-attachments/assets/bfbb949d-8300-413e-b736-5ed5eff00b32" />
- <img width="1786" height="962" alt="Screenshot 2025-08-12 210209" src="https://github.com/user-attachments/assets/b1c7b3ea-ee14-469c-a8ca-b8011d3f251c" />
- <img width="1837" height="998" alt="Screenshot 2025-08-12 212630" src="https://github.com/user-attachments/assets/ce82a0cb-37e5-41b1-bd7d-e47a117d1b10" />
- <img width="1699" height="985" alt="Screenshot 2025-08-12 212451" src="https://github.com/user-attachments/assets/f51c31fe-a055-451d-8464-f0027ca10b31" />
- <img width="1712" height="972" alt="Screenshot 2025-08-12 212444" src="https://github.com/user-attachments/assets/b2ed5dfc-8668-41ea-846d-f2cf9dfb6832" />
- `assets/screenshots/deployed_webapp.png` – Java web application running live on Tomcat.
- <img width="1601" height="926" alt="Screenshot 2025-08-12 213737" src="https://github.com/user-attachments/assets/1831fe38-595d-4b28-b3e9-5f81a364fedb" />
---

### **Video of Workflow**
https://github.com/user-attachments/assets/9ae04a69-59bc-49d9-a3dc-333601fae285


