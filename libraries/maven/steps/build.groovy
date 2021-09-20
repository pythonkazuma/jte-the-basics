void call(){
    stage("Maven: Build"){
        println "build from the maven library"
        docker.image("maven").inside{
            sh "mvn clean package"
        }
    }
}
