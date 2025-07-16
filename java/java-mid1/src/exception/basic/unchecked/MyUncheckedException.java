package exception.basic.unchecked;

import exception.basic.checked.MyCheckedException;

/**
 * RuntimeException를 상속받는 것 = unChecked
 */
public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String message) {
        super(message);
    }
}
