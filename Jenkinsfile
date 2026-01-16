pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'Java17'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/spring-boot-app.git'
            }
        }
        stage('Build Spring Boot App') {
            steps {
                // -DskipTests is the key to removing the test part
                bat "mvn clean install -DskipTests"
            }
        }
        stage('Docker Build & Run') {
            steps {
                bat "docker build -t spring-app:1.0 ."
                bat "docker run -d -p 8080:8080 --name spring-container spring-app:1.0"
            }
        }
    }
}