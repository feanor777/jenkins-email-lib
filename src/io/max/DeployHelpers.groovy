package io.max

class DeployHelpers implements Serializable {
    static def createPodYaml() {
        return libraryResource("pods/node_pod.yaml")
    }
}
