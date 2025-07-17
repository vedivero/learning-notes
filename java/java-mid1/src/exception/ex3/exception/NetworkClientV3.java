package exception.ex3.exception;

public class NetworkClientV3 {

    private final String address;
    public boolean connectError;    //boolean의 기본값 : false
    public boolean sendError;

    public NetworkClientV3(String address) {
        this.address = address;
    }

    public void connect() throws ConnectExceptionV3 {

        if (connectError) {
            throw new ConnectExceptionV3(address, address + " 서버 연결 실패");
        }
        System.out.println(address + "서버 연결 성공");
    }

    public void send(String data) throws SendExceptionV3 {
        if (sendError) {
            throw new SendExceptionV3(data, address + " 메시지 데이터 전송 실패");
            //throw new RuntimeException("ex");
        }
        System.out.println(address + " 서버에 데이터 전송 : " + data);
    }

    public void disconnct() {
        System.out.println(address + " 서버 연결 해제");
    }

    public void initError(String data) {
        if (data.contains("error1")) {
            connectError = true;
        }
        if (data.contains("error2")) {
            sendError = true;
        }
    }
}
