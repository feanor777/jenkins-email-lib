def call() {
    def testVar = "test max"

    pipeline {
        agent any
        stages {
            stage('Test Stage 1') {
                steps {
                    echo "I'm at test stg"
                    ehco "Here is testVar ${testVar}"
                }
            }
        }
    }
}