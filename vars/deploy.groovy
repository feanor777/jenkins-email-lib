import io.max.DeployHelpers

def call() {
    def podYaml = (new DeployHelpers()).createPodYaml()

    pipeline {
        agent {
            kubernetes {
                label "library-test"
                yaml "${podYaml}"
            }
        }

        stages {
            stage("Build") {
                steps {
                    sh "npm --version"
                }
            }
            stage("Test") {
                steps {
                    test1()
                    test2()
                }
            }
        }
    }
}

def test1() {
    def testVar = "test max"
    echo "Here is testVar ${testVar}"
}

def test2() {
    echo "here is test2"
}