
# 🚀 **Automatización de Gestión de Usuarios en Linux con Jenkins**

## 📋 Descripción del Proyecto

*Este proyecto implementa pipelines en Jenkins para automatizar la gestión de usuarios en sistemas Linux. Proporciona dos funcionalidades principales:*

## **Creación de usuarios:**

- *Automatiza la creación de usuarios con parámetros personalizados.*
- *Asigna un grupo, un shell y genera una contraseña temporal.*

## **Eliminación de usuarios:**

- *Permite eliminar usuarios existentes junto con sus directorios personales y grupos.*

## **Objetivo**
*Simplificar la administración de usuarios y minimizar errores operativos mediante una herramienta confiable y reproducible.*

## ✨ **Características**
 * ✔️ *Gestión automatizada de usuarios (creación y eliminación).*
 * ✔️ *Personalización mediante parámetros como login, nombre completo y departamento.*
 * ✔️ *Compatible con cualquier sistema Linux.*
 * ✔️ *Fácil integración con Jenkins.*

## 🛠️ Requisitos Previos
### 1. Requisitos del Servidor
* **Sistema Operativo:**  ***Linux (Ubuntu, Debian, etc.).***
* **Permisos:**  ***Acceso como usuario sudo para ejecutar comandos administrativos.***

* **Jenkins:**
***Instalado y configurado en el servidor.***
* **Plugins requeridos:**
***Pipeline***
***Git Plugin***

* **Paquetes necesarios en el servidor:**
***useradd (instalado por defecto).***
***git para clonar el repositorio.***

### 2. Repositorio de GitHub
Clona este repositorio en Jenkins:
***https://github.com/gaboibarra/EducacionITDesafios.git***

## ⚙️ Configuración del Proyecto en Jenkins
### 1. Pipeline de Creación de Usuarios
***Pasos para Configurar***
* **En Jenkins Crear un nuevo pipeline:**
* Nombre: PipelineCrearUsuarios.
* Configura el pipeline seleccionando Pipeline script from SCM.
Completa los campos:
* SCM: Git.
* Repository URL: https://github.com/gaboibarra/EducacionITDesafios.git.
* Script Path: pipelines/create-user.groovy.
***Guarda los cambios.***
