package product_consume.BlockingQueueDemo;

import product_consume.Producer;

abstract class AbstractProducer implements Producer, Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
    }
}
