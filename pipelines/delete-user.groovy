pipeline {
    agent any
    parameters {
        string(name: 'LOGIN', description: 'Login único del usuario a eliminar')
    }
    stages {
        stage('Validar entrada') {
            steps {
                script {
                    if (!params.LOGIN) {
                        error "El parámetro LOGIN es obligatorio."
                    }
                }
            }
        }
        stage('Eliminar usuario') {
            steps {
                script {
                    sh """
                    sudo userdel -r ${params.LOGIN}
                    echo "Usuario ${params.LOGIN} y su directorio personal han sido eliminados."
                    """
                }
            }
        }
    }
}
