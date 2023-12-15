package info.thecodinglive.xmlConfig;

import basic.Boss;
import basic.Employee;
import basic.WorkManager;
import basic.WorkService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClassLoadTest {
    private WorkService workService;

   @BeforeEach
    void setup() {
       workService = new WorkService();
   }

   @Test
    void testEmployeeWork() {
       WorkManager employee = new Employee();
       workService.setWorkManager(employee);
       workService.askWork();
   }

   @Test
    void testBossWork() {
       WorkManager boss = new Boss();
       workService.setWorkManager(boss);
       workService.askWork();
   }
}
