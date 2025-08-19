def call(String Project, String ImageTag, String dockerHubuser) {
    withCredentials([usernamePassword(credentialsId: 'DockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        // Avoid Groovy interpolation entirely
        sh '''#!/bin/bash
        echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
        '''
    }

    sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
