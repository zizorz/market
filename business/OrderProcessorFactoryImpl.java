package business;

public class OrderProcessorFactoryImpl implements OrderProcessorFactory {
    @Override
    public OrderProcessor create() {
        return new OrderProcessorImpl();
    }
}
