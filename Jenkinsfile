def TARGET_PATH = '/www/server/wison-wpos'
def SOURCE_PATH = './wpos-server/target'
def SHELL_NAME = 'wison-wpos.sh'

pipeline {
    agent any

    tools {
        maven 'maven-3.6.3'
    }

    stages {
        stage('getGitlabBranchName') {
            steps {
                echo "current branch is: ${env.gitlabBranch}"
            }
        }

        stage('build-test') {
            when {
                environment name: 'gitlabBranch', value: 'test'
            }
            steps {
                withEnv(['JENKINS_NODE_COOKIE=dontkillme']) {
                    configFileProvider([configFile(fileId: 'maven-global-settings', variable: 'MAVEN_GLOBAL_ENV')]) {
                        sh "mvnd -s $MAVEN_GLOBAL_ENV clean package -U -DskipTests"
                        sh "cp $SOURCE_PATH/*.jar $TARGET_PATH"
                        sh "cp ./$SHELL_NAME $TARGET_PATH"
                        sh "sh $TARGET_PATH/$SHELL_NAME restart"
                    }
                }
            }
        }
    }
}





