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
                    echo "This is the test pipeline for Ansible"
                }
            }
        }

        stage("Ansible Dry Run"){
            steps{
                script{
                    sh "which ansible-playbook"
                   sh " ansible-playbook -i inventory playbook.yml --check --diff "
                }
            }
        }

    }
}
