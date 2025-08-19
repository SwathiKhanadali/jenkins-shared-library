def call(String Project, String ImageTag, String dockerHubuser) {
    withCredentials([usernamePassword(credentialsId: 'DockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) 
    {
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
    }
    sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
