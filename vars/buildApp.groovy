def call() {
    echo "Building app..."
    sh "npm install"
    sh "npm run build"
}
