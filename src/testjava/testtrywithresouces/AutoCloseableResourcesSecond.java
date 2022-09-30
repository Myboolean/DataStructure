package testjava.testtrywithresouces;

public class AutoCloseableResourcesSecond implements AutoCloseable {
 
    public AutoCloseableResourcesSecond() {
        System.out.println("Constructor -> AutoCloseableResources_Second");
    }
 
    public void doSomething() {
        System.out.println("Something -> AutoCloseableResources_Second");
    }
 
    @Override
    public void close() throws Exception {
        System.out.println("Closed AutoCloseableResources_Second");
    }
    private  static void orderOfClosingResources() {
        AutoCloseableResourcesFirst af = new AutoCloseableResourcesFirst();
        AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond();
        try (af ;
             as ) {

            af.doSomething();
            as.doSomething();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        orderOfClosingResources();
    }
}