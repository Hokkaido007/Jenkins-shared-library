// cloneCode.groovy
// Usage:
// cloneCode(repoUrl: 'https://github.com/user/repo.git', branch: 'main', targetDir: 'my-app')

def call(Map config = [:]) {
    // Extract config with defaults
    String repoUrl   = config.get('repoUrl', '')
    String branch    = config.get('branch', 'main')
    String targetDir = config.get('targetDir', '.')
    boolean failOnError = config.get('failOnError', true)

    if (!repoUrl) {
        error "❌ repoUrl is required"
    }

    echo "▶ Cloning repository: ${repoUrl}"
    echo "   Branch: ${branch}, Target directory: ${targetDir}"

    try {
        // Check if target directory exists
        def dirExists = sh(script: "test -d ${targetDir}", returnStatus: true) == 0
        if (dirExists) {
            echo "ℹ Directory exists, pulling latest changes..."
            sh """
                cd ${targetDir}
                git fetch origin ${branch}
                git reset --hard origin/${branch}
            """
        } else {
            sh "git clone -b ${branch} ${repoUrl} ${targetDir}"
        }
        echo "✔ Repository ready at ${targetDir}"
    } catch (Exception e) {
        echo "❌ Failed to clone repository: ${e.getMessage()}"
        if (failOnError) {
            error("Aborting pipeline due to git failure.")
        }
    }
}
