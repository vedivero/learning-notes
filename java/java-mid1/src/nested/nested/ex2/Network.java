package nested.nested.ex2;

public class Network {

    public void sendMessage(String text) {
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }

    
    // 기존 NetworkMessage 클래스는 Network 클래스에 중첩
    private static class NetworkMessage {

        private String content;

        public NetworkMessage (String content) {
            this.content = content;
        }

        public void print() {
            System.out.println("content = " + content);
        }
    }

}
