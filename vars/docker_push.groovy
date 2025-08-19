def call(String Project, String ImageTag, String dockerHubuser) {
    withCredentials([usernamePassword(credentialsId: 'DockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        // Use stdin to pass the password securely
        sh """
            echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
        """
    }

    sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
