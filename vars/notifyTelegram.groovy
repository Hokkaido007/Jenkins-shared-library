def call(String status, String message = "") {
    def chatId = "YOUR_TELEGRAM_CHAT_ID"
    def token = "YOUR_TELEGRAM_BOT_TOKEN"
    def text = "${status}: ${message}"
    sh "curl -s -X POST https://api.telegram.org/bot${token}/sendMessage -d chat_id=${chatId} -d text='${text}'"
}