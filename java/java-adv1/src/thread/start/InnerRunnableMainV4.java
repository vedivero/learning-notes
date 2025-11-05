  package thread.start;

import static util.MyLogger.log;

  public class InnerRunnableMainV4 {
  
      public static void main(String[] args) {
  
          log("main() start");

          // Lamba
          // 메서드 조각을 바로 던지는 방법
          Thread thread = new Thread(() -> log("run()"));
          thread.start();
          
          log("main() end");
      }
  
  }
