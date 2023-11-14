pipeline{
    agent any
    stages{
         stage('Checkout') {
            steps {
                // Clone the public Git repository
                script {
                    git url: 'https://github.com/angeleena9049/ansible-repository.git', branch: 'master'
                }
            }
        }
        stage("Init"){
            steps{
                script{
                    sh "This is the test pipeline for Ansible"
                }
            }
        }

        stage("Ansible Dry Run"){
            steps{
                script{
                    ansible-playbook -i inventory playbook.yml --check --diff
                }
            }
        }

    }
}