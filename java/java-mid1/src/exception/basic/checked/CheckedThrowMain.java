package exception.basic.checked;

public class CheckedThrowMain {
    public static void main(String[] args) throws Exception {
        Service service = new Service();
        service.catchThrow(); //폭탄이 main 밖으로 나가면서 프로그램이 종료
        System.out.println("정상 종료");
    }
}
