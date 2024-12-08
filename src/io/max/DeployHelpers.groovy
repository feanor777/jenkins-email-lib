package io.max

class DeployHelpers implements Serializable {
    def steps

    DeployHelpers(steps) { this.steps = steps }

    def createPodYaml() {
        return steps.libraryResource("pods/node_pod.yaml")
    }
}
