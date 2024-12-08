package io.max

class DeployHelpers implements Serializable {
    def createNodePodYaml() {
        return """
apiVersion: v1
kind: Pod
metadata:
  name: ci-pod
spec:
  containers:
    - name: node
      image: node:latest
      command:
        - sleep
      args:
        - 99d
  restartPolicy: Never  
"""
    }
}
