void call(){
    stage("SonarQube: Static Code Analysis"){
        println "static code analysis from the sonarqube library"
        node {
            def scannerHome = tool 'SonarScanner 4.0’;
            withSonarQubeEnv('My SonarQube Server') { 
                sh "${scannerHome}/bin/sonar-scanner"
            }
        }
    }
}
