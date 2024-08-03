# 젠킨스 연동

* [젠킨스란-무엇인가](https://inpa.tistory.com/entry/Jenkins-%F0%9F%93%9A-%EC%A0%A0%ED%82%A8%EC%8A%A4%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80)
* [젠킨스-windows 설치-설정](https://inpa.tistory.com/entry/Jenkins-%F0%9F%A4%B5-%EC%A0%A0%ED%82%A8%EC%8A%A4-%EC%84%A4%EC%B9%98-%EC%84%A4%EC%A0%95)
* [젠킨스-ubuntu 설치-설치](https://devje.tistory.com/233)
* [GIT-GITHUB-Jenkins 연동 하는 방법](https://inpa.tistory.com/entry/Jenkins-%F0%9F%A4%B5-GithubGit-%EC%97%B0%EB%8F%99-%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95)
* [GIT-GITHUB-Jenkins webhook 연동 하는 방법](https://junhyunny.github.io/information/jenkins/github/jenkins-github-webhook/)


<pre>
<code>
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
    }
}

</code>
</pre>

