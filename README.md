# 젠킨스 연동

* [젠킨스란-무엇인가](https://inpa.tistory.com/entry/Jenkins-%F0%9F%93%9A-%EC%A0%A0%ED%82%A8%EC%8A%A4%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80)
* [젠킨스-windows 설치-설정](https://inpa.tistory.com/entry/Jenkins-%F0%9F%A4%B5-%EC%A0%A0%ED%82%A8%EC%8A%A4-%EC%84%A4%EC%B9%98-%EC%84%A4%EC%A0%95)
* [젠킨스-ubuntu 설치-설치](https://devje.tistory.com/233)
* port 변경
<pre>
<code>
  $sudo systemctl stop jenkins
  $sudo systemctl disable jenkins
  $sudo systemctl enable jenkins

  실행 결과 시작
  ------------------
  Synchronizing state of jenkins.service with SysV service script with /lib/systemd/systemd-sysv-install.
  Executing: /lib/systemd/systemd-sysv-install enable jenkins
  Created symlink /etc/systemd/system/multi-user.target.wants/jenkins.service → /lib/systemd/system/jenkins.service.
  ------------------

  
  $sudo vi /lib/systemd/system/jenkins.service
  
  Environment="JENKINS_PORT=8080" 이부분을 
  Environment="JENKINS_PORT=9090" 으로 변경하고 저장한다

  $sudo systemctl start  jenkins
  $sudo systemctl status  jenkins

  
  
</code>
</pre>
  
* [GIT-GITHUB-Jenkins 연동 하는 방법](https://inpa.tistory.com/entry/Jenkins-%F0%9F%A4%B5-GithubGit-%EC%97%B0%EB%8F%99-%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95)
* [GIT-GITHUB-Jenkins webhook 연동 하는 방법](https://junhyunny.github.io/information/jenkins/github/jenkins-github-webhook/)


<pre>
<code>
  작업폴더 위치 : /var/lib/jenkins/workspace
  jenkins 스크립트
/*
pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'building the application...'
            }
        }
        stage('test') {
            steps {
                echo 'testing the application...'
            }
        }
        stage('deploy') {
            steps {
                echo 'deploying the application...'
            }
        }
    }
}
*/

pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'b7c67407-dc28-4296-8250-535c7e61b345',
                    url: 'https://github.com/masungil70/devops_step3.git'
            }
        }
        stage('build') {
            steps {
                 sh './gradlew build'
            }
        }
    }
}

</code>
</pre>

