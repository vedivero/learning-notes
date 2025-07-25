package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV4 {
    private int outInstance = 3;

    public Printer process(int paramVar) {
        int localVar = 1;   // 지역 변수는 스택 프레임이 종료되는 순간 함께 제거된다.

        class LocalPrinter implements Printer {

            int value = 0;

            @Override
            public void print() {
                System.out.println("value = " + value);

                //인스턴스는 지역 변수보다 더 오래 로드된다.
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);// 매개 변수도 지역변수 취급
                System.out.println("outInstance = " + outInstance);
            }
        }
        Printer Printer = new LocalPrinter();
        //localPrinter.print();를 여기서 실행하지 않고 Printer 인스턴스만 반환한다.

        //만약 localVar의 값을 변경한다면? 다시 캡쳐되게 해야하는건가?
        //localVar=10;
        //paramVar=10;

        return Printer;
    }

    public static void main(String[] args) {
        LocalOuterV4 localOuterV2 = new LocalOuterV4();
        Printer printer = localOuterV2.process(2);
        //printer.print()를 나중에 실행한다. process()의 스택 프레임이 사라진 이후에 실행
        printer.print();

        //추가
        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
    }
}
