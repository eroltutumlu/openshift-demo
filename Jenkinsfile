pipeline {
    agent any
        tools {
        maven 'Maven'
    }
    environment {
        EMAIL_RECIPIENTS = 'eroltutumlu@gmail.com'
    }
    stages {
        stage("build") {
            steps {
                echo 'building the application...'
                                echo "Java VERSION"
                sh 'mvn install' 


            }
        }

        stage("test") {
            steps {
                echo 'testing the application...'
                sh 'mvn test' 
            }
        }

        stage("deploy") {
            steps {
                echo 'deploying the application...'
            }
        }
    }
    
        post {
        // Always runs. And it runs before any of the other post conditions.
        always {
            // Let's wipe out the workspace before we finish!
            deleteDir()
        }
        success {
            sendEmail("Successful");
        }
        unstable {
            sendEmail("Unstable");
        }
        failure {
            sendEmail("Failed");
        }
    }
    
}


def sendEmail(status) {
    mail(
            to: "$EMAIL_RECIPIENTS",
            subject: "Build $BUILD_NUMBER - " + status + " (${currentBuild.fullDisplayName})",
            body: "Changes:\n Check console output at: $BUILD_URL/console" + "\n")
}
