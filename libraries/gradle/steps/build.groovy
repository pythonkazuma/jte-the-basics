void call(){
    stage("Gradle: Build"){ 
        println "build from the gradle library" 
        docker.image("gradle").inside{
            sh "pwd"
            sh "ls"
            sh "gradle clean build"
            //sh "gradle build"
        }
    }
}
