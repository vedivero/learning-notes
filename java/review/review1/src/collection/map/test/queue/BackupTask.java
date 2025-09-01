package collection.map.test.queue;

public class BackupTask implements Task {

    @Override
    public void excute() {
        System.out.println("데이터 백업...");
    }
}
