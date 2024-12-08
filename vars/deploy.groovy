def call(String envName) {
    verifyEnv(envName)
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

private void verifyEnv(String envName) {
    if (envName == "STG") {
        echo "Environment is ${envName}"
    } else if(envName == "PROD") {
        currentBuild.result = 'ABORTED'
        error('Stopping early because it is a PROD')
    }
}