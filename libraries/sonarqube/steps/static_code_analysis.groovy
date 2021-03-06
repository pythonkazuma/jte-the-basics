void call(){
    stage("SonarQube: Static Code Analysis"){
        println "static code analysis from the sonarqube library"
        // parse configuration 
        String scannerVersion = config.scanner_version ?: "SonarScanner 4.0"
        String serverName = config.server_name ?: "My SonarQube Server"
        Boolean enforceQualityGate = config.containsKey("enforce_quality_gate") ?
                config.enforce_quality_gate : true
        String projectKey = config.sonarqube_projectKey
        node {
            def scannerHome = tool(scannerVersion)
            withSonarQubeEnv(serverName) { 
                //sh "${scannerHome}/bin/sonar-scanner"
                sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=${projectKey} -Dsonar.java.binaries=target/classes"
            }
        }
        timeout(time: 1, unit: 'HOURS') {
            def qg = waitForQualityGate() 
            if (qg.status != 'OK') {
                if(enforceQualityGate){
                    error "Pipeline aborted due to quality gate failure: ${qg.status}"
                } else {
                    warning "Quality gate failure: ${qg.status}"
                }
            }
        }
    }
}
