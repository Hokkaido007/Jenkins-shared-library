def call(String message) {
    withCredentials([
        string(credentialsId: 'TELEGRAM_BOT_TOKEN', variable: 'TELEGRAM_TOKEN'),
        string(credentialsId: 'TELEGRAM_CHAT_ID', variable: 'CHAT_ID')
    ]) {
        sh """
        curl -s -X POST "https://api.telegram.org/bot$TELEGRAM_TOKEN/sendMessage" \
        -d chat_id=$CHAT_ID \
        -d text='${message}'
        """
    }
}