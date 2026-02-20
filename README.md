# CI/CD Pipeline with Jenkins

## Overview
This project demonstrates a **CI/CD pipeline** using **Jenkins Shared Library**.

---

## Workflow

1. Initialize the **Jenkins Shared Library** repository  
2. Clone code from **GitHub**  
3. Install dependencies  
4. Build the project  
5. Wait for **Quality Gate (QG)** results  

---

## Post-Check Actions

### ✅ On Success
1. Build Docker image  
2. Push Docker image to **Docker Hub**  
3. Run Docker on port 3000
4. Send notification to **Telegram**  

### ❌ On Failure
1. Send failure notification to **Telegram** as a report  