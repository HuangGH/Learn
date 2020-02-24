package spring;

import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.support.SimpleTriggerContext;

/**
 * @author hgh
 * @since 2020-02-24 16:31
 */
public class CronTaskDemo {
    public static void main(String[] args) {
        CronTask cronTask = new CronTask(CronTaskDemo::sout, "0 0/2 * * * *");
        System.out.println(new SimpleTriggerContext().lastCompletionTime());
        System.out.println(cronTask.getTrigger().nextExecutionTime(new SimpleTriggerContext()));
        System.out.println(cronTask.getTrigger().nextExecutionTime(new SimpleTriggerContext()));
        System.out.println(cronTask.getTrigger().nextExecutionTime(new SimpleTriggerContext()));

        System.out.println(System.currentTimeMillis());
    }


    public static void sout() {
        System.out.println("test");
    }
}
