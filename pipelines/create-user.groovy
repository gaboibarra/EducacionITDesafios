pipeline {
    agent any
    parameters {
        string(name: 'LOGIN', description: 'Login único del usuario (nombre.apellido)')
        string(name: 'NOMBRE_COMPLETO', description: 'Nombre completo del usuario')
        choice(name: 'DEPARTMENTO', choices: ['contabilidad', 'finanzas', 'tecnologia'], description: 'Departamento del usuario')
    }
    stages {
        stage('Validar entrada') {
            steps {
                script {
                    if (!params.LOGIN || !params.NOMBRE_COMPLETO || !params.DEPARTMENTO) {
                        error "Todos los parámetros son obligatorios."
                    }
                }
            }
        }
        stage('Crear usuario') {
            steps {
                script {
                    def tempPassword = UUID.randomUUID().toString().substring(0, 8)
                    
                    sh """
                    sudo useradd -m -c '${params.NOMBRE_COMPLETO}' -s /bin/bash -G ${params.DEPARTMENTO} ${params.LOGIN}
                    echo '${params.LOGIN}:${tempPassword}' | sudo chpasswd
                    sudo passwd --expire ${params.LOGIN}
                    echo "Usuario ${params.LOGIN} creado con contraseña temporal: ${tempPassword}"
                    """
                    
                    writeFile file: 'temp_password.txt', text: tempPassword
                }
            }
        }
        stage('Mostrar contraseña') {
            steps {
                script {
                    echo "La contraseña temporal para el usuario ${params.LOGIN} es:"
                    sh "cat temp_password.txt"
                }
            }
        }
    }
    post {
        always {
            deleteDir() // Limpia el espacio de trabajo después de la ejecución
        }
    }
}
