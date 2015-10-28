package pool;
import pool.Resource;
import pool.ResourcePool;


public class ResourcePoolMock extends ResourcePool {

    public ResourcePoolMock(int nResources) {
        super(nResources);
    }

    @Override
    protected Resource createResource() {
        return new ResourceMock();
    }

}
