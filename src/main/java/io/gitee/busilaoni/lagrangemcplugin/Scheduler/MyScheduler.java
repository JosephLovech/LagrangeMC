package io.gitee.busilaoni.lagrangemcplugin.Scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 *  定时任务
 */
public class MyScheduler {

    /**
     * 创建定时器工厂对象
     */
    private static SchedulerFactory factory = new StdSchedulerFactory();

    /**
     * 创建定时任务
     * param jobDetail
     * param trigger
     * return
     */
    public static Scheduler createScheduler(JobDetail jobDetail, Trigger trigger){

        try {
            //获取定时器
            Scheduler scheduler = factory.getScheduler();

            //scheduler绑定job和trigger并执行
            scheduler.scheduleJob(jobDetail, trigger);
            return scheduler;
        } catch (SchedulerException e) {
            e.printStackTrace();
            System.out.println("[warning]: 无法生成定时器");
            return null;
        }
    }

    /**
     * 创建触发器
     * param cron 定时任务执行的时间 例：0/30 * * * * ?
     * param isNow 是否立刻执行
     * param name 标识符名
     * param group 标识符组
     * return
     */
    public static Trigger createCronTrigger(String cron, boolean isNow, String name, String group){

        Trigger trigger = null;

        //构建trigger
        TriggerBuilder builder = TriggerBuilder.newTrigger()
                .withIdentity(name,group)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron));

        //是否立刻启动
        if (isNow){
            trigger = builder.startNow().build();
        }else {
            trigger = builder.build();
        }

        return trigger;
    }

    /**
     * 创建任务
     * param clazz 继承Job的类
     * param name 标识符名
     * param group 标识符组
     * return
     */
    public static JobDetail createJobDetail(Class clazz, String name, String group){

        //构建JobDetail
        JobDetail jobDetail = JobBuilder.newJob(clazz)
                .withIdentity(name,group)
                .build();

        return jobDetail;
    }

    /**
     * 启动计时器
     * param scheduler
     * return
     */
    public static Scheduler startScheduler(Scheduler scheduler){

        try {
            //启动计时器
            scheduler.start();

        } catch (SchedulerException e) {
            e.printStackTrace();
            System.out.println(String.format("[warning]: 计时器启动失败 %s", scheduler.toString()));
        }

        return scheduler;
    }

    /**
     * 关闭计时器
     * param scheduler
     * return
     */
    public static Scheduler stopScheduler(Scheduler scheduler){

        try {
            //关闭计时器
            scheduler.shutdown();

        } catch (SchedulerException e) {
            e.printStackTrace();
            System.out.println(String.format("[warning]: 计时器关闭失败 %s", scheduler.toString()));
        }

        return scheduler;
    }
}
