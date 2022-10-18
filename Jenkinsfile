pipeline {
    agent {
        docker { image 'openjdk:11' }
    }

    stages {
        stage('Source') {
            steps {
                echo "PR Event Type: ${X_Event_Key}";
                echo "Source Branch Name: ${branch_source}";
                echo "Destination Branch Name: ${branch_destination}";
               
                script {
                    if ("${X_Event_Key}" == "pullrequest:created" || "${X_Event_Key}" == "pullrequest:updated") { 
                        git  branch:"${branch_source}", url: "https://miguelgan@bitbucket.org/poc-samples/poc-backend-repo.git";
                    }
                    else if ("${X_Event_Key}" == "pullrequest:fulfilled") {
                        git  branch:"${branch_destination}", url: "https://miguelgan@bitbucket.org/poc-samples/poc-backend-repo.git";
                    }
                    else {
                        currentBuild.result = "FAILURE";
                        sh "exit 1";
                    }
                }
            }
        }
        stage('Build') {
            steps {
               sh "./mvnw clean install -DskipTests";
            }
        }
        stage('Test') {
            steps {
               sh "./mvnw test -Punit";
            }
        }
        stage('Docker') {
            when {
                expression {
                    "${X_Event_Key}" == "pullrequest:fulfilled";
                }
            }
            steps {
                echo "Building Docker Image";
            }
        }
    }
}