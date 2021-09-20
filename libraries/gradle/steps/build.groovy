void call(){
    stage("Gradle: Build"){ 
        println "build from the gradle library" 
        docker.image(”gradle").inside{
            sh ”gradle clean build"
        }
    }
}
