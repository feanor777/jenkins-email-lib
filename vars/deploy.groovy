def call(String envName) {
    if(envName == "STG") {
        echo "Environment is ${envName}"
    }
    def testVar = "test max"

    pipeline {
        agent any
        stages {
            stage('Test Stage 1') {
                steps {
                    echo "I'm at test stg"
                    echo "Here is testVar ${testVar}"
                }
            }
        }
    }
}