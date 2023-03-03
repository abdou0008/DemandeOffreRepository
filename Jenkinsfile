pipeline {
     agent any
     stages {
       stage(‘Build’) {
           steps {
               sh "/opt/apache-maven/bin/clean package"
           }
         }
stage(‘Test’) {
steps {
sh "/opt/apache-maven/bin/mvn test"
}
}
}
}
