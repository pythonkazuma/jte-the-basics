void call(){
    stage("Gradle: Build"){ 
        println "build from the gradle library" 
        docker.image("gradle").inside{
            //sh "git clone https://github.com/pythonkazuma/Jenkins_Practical_Guide_3rd_Edition.git"
            //sh "cd Jenkins_Practical_Guide_3rd_Edition"
            //sh "gradle clean build"
            sh "gradle build"
        }
    }
}
