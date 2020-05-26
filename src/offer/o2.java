package offer;

/**
 * 实现线程安全的单例模式
 */
public class o2 {


}

/**
 * 经典饿汉式
 */
class Singleton1 {
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}

/**
 * 经典懒汉式
 * 线程不安全
 */
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * 线程安全懒汉式
 */
class Singleton3 {
    //这种写法能够在多线程中很好的工作，但是每次调用getInstance方法时都需要进行同步，造成不必要的同步开销，而且大部分时候我们是用不到同步的，所以不建议用这种模式。
    private static Singleton3 instance;

    private Singleton3() {
    }

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}


/**
 * DCL(双重检查模式)
 *
 */
class Singleton4 {
    private volatile static Singleton4 instance;

    private Singleton4() {
    }

    //这种写法在getSingleton方法中对singleton进行了两次判空，第一次是为了不必要的同步，第二次是在singleton等于null的情况下才创建实例。
    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}


/**
 * 静态内部类单例模式
 * 推荐
 */
class Singleton5 {
    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.sInstance;
    }

    //第一次加载Singleton类时并不会初始化sInstance，只有第一次调用getInstance方法时虚拟机加载SingletonHolder 并初始化sInstance ，
    // 这样不仅能确保线程安全也能保证Singleton类的唯一性，所以推荐使用静态内部类单例模式。
    private static class SingletonHolder {
        private static final Singleton5 sInstance = new Singleton5();
    }
}