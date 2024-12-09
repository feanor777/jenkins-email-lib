import io.max.DeployHelpers

def call() {
    def podYaml = new DeployHelpers(this).createPodYaml()

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
                    container("node") {
                        sh "npm --version"
                        sh 'echo "Hello, World!" > file-max.txt'
                        sh 'ls -l'
                        stash name: 'max-test', includes: '*.txt'
                        sh 'ls -l'
                    }
                }
            }

            stage("Test") {
                steps {
                    container("node2") {
                        test1()
                        test2()
                        dir('/documents') {
                            sh 'ls -l'
                            unstash 'max-test'
                            sh 'ls -l'
                        }
                    }
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