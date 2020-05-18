package product_consume.wait_notify;

import product_consume.Consumer;

abstract class AbstractConsumer implements Consumer,Runnable{

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}
