package product_consume;

/**
 * 不同的模型实现中，生产者、消费者的具体实现也不同，所以需要为模型定义抽象工厂方法：
 */
public interface Model {
    Runnable newRunnableConsumer();

    Runnable newRunnableProducer();
}
