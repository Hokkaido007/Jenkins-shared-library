def call(String image) {
    sh "docker build -t ${image} ."
    sh "docker push ${image}"
}
