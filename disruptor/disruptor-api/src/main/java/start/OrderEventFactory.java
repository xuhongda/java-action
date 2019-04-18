package start;

import com.lmax.disruptor.EventFactory;

/**
 * @author xuhongda on 2019/4/18
 * start
 * java-action
 */
public class OrderEventFactory implements EventFactory<OrderEvent> {

    @Override
    public OrderEvent newInstance() {
        return new OrderEvent();
    }
}
